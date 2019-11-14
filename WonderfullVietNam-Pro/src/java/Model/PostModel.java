/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DBLib.ConnectionLib;
import Info.PostInfo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class PostModel {

    //Declare variables
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final Connection connection;
    public static int SoDong_Trang = 4;
    private ArrayList<PostInfo> list;

    /**
     * Create PostModel constructor to connect this application with database on
     * mysql
     */
    public PostModel(Connection connection) {
        this.connection = connection;
    }

    /**
     * Create ArrayList to pull all information of Post from database into
     * ArrayList
     *
     *
     * @return
     * @throws java.sql.SQLException
     */
    public ArrayList<PostInfo> getPost() throws SQLException {
        ArrayList<PostInfo> postInfoList = new ArrayList<>();
        String sql = "SELECT * FROM `post` WHERE `status` = 1 ORDER BY `post_time` DESC";
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            postInfoList.add(new PostInfo(resultSet.getInt("post_id"), resultSet.getInt("place_id"), resultSet.getString("post_text"),
                    resultSet.getDate("post_time"), resultSet.getInt("status"), resultSet.getInt("user_id"), resultSet.getInt("editor_id")));
        }
        return postInfoList;
    }
    
        public ArrayList<PostInfo> getAllPost() throws SQLException {
        ArrayList<PostInfo> postInfoList = new ArrayList<>();
        String sql = "SELECT * FROM `post`";
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            postInfoList.add(new PostInfo(resultSet.getInt("post_id"), resultSet.getInt("place_id"), resultSet.getString("post_text"),
                    resultSet.getDate("post_time"), resultSet.getInt("status"), resultSet.getInt("user_id"), resultSet.getInt("editor_id")));
        }
        return postInfoList;
    }

    /**
     * 
     * @param place_id
     * @param post_text
     * @param post_time
     * @param status
     * @param user_id
     * @param editor_id
     * @throws SQLException 
     */
    public void insertPost(int place_id, String post_text, int status, int user_id, int editor_id) throws SQLException {
        String sql = "INSERT INTO `post`(`post_id`,`place_id`, `post_text`, `status`, `user_id`, `editor_id`) VALUES (?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, getAllPost().size());
        preparedStatement.setInt(2, place_id);
        preparedStatement.setString(3, post_text);
        preparedStatement.setInt(4, status);
        preparedStatement.setInt(5, user_id);
        preparedStatement.setInt(6, editor_id);

        preparedStatement.executeUpdate();
    }

    /**
     * Create UpdatePost method to modify information of the post
     *
     * @param postInfo
     * @throws SQLException
     */
    public void updatePost(PostInfo postInfo) throws SQLException {
        String sql = "UPDATE `post` SET `place_id`=?,`post_text`=?,`post_time`=?,`status`=?,`user_id`=?,`editor_id`=? WHERE `post_id` = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, postInfo.getPlace_id());
        preparedStatement.setString(2, postInfo.getPost_text());
        preparedStatement.setDate(3, postInfo.getPost_time());
        preparedStatement.setInt(4, postInfo.getStatus());
        preparedStatement.setInt(5, postInfo.getUser_id());
        preparedStatement.setInt(6, postInfo.getEditor_id());
        preparedStatement.setInt(7, postInfo.getPost_id());

        preparedStatement.executeUpdate();
    }

    /**
     * Create deletePost to set the this status equal zero (status = 0)
     *
     * @param postInfo
     * @throws SQLException
     */
    public void deletePost(PostInfo postInfo) throws SQLException {
        String sql = "UPDATE `post` SET `status`=0 WHERE `post_id` = ?";
        preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, postInfo.getPost_id());

        preparedStatement.executeUpdate();
    }

    /**
     * Create searchPost method to search any post by their's post_id
     *
     * @param post_id
     * @return
     * @throws SQLException
     */
    public ArrayList<PostInfo> searchPost(int id) throws SQLException {
        //pl is postList
        ArrayList<PostInfo> pl = new ArrayList<>();
        String sql = "SELECT * FROM `post` WHERE `post_id` = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            pl.add(new PostInfo(resultSet.getInt("post_id"), resultSet.getInt("place_id"), resultSet.getString("post_text"),
                    resultSet.getDate("post_time"), resultSet.getInt("status"), resultSet.getInt("user_id"), resultSet.getInt("editor_id")));
        }

        return pl;
    }

    public ArrayList<PostInfo> getPaging(int page, String search, String sortColumn) {
        try {
            String sqlStr = "";
            sqlStr += " SELECT *";
            sqlStr += " FROM `post` WHERE `status` = 1 ORDER BY `post_time` DESC ";

            if (search != "") {
//                sqlStr += " WHERE (`place_name` like '%" + search + "%')";
            }

            if (sortColumn != "") {
                //thuc hien sap xep
            }

            //phan trang
            int tongSoSanPham = getNumberOfProduct(page, search, sortColumn);
            int tongSoTrang = (int) Math.ceil(tongSoSanPham / SoDong_Trang);
            int index = (page - 1) * SoDong_Trang;

            sqlStr += " LIMIT " + index + ", " + SoDong_Trang;

            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(sqlStr);
            list = new ArrayList<PostInfo>();
            while (resultSet.next()) {
                list.add(new PostInfo(resultSet.getInt("post_id"), resultSet.getInt("place_id"), resultSet.getString("post_text"),
                    resultSet.getDate("post_time"), resultSet.getInt("status"), resultSet.getInt("user_id"), resultSet.getInt("editor_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.list;
    }

    public int getNumberOfProduct(int page, String search, String sortColumn) throws SQLException {
        String sqlStr = "";
        sqlStr += " SELECT count(*) as soLuong ";
        sqlStr += " FROM `post`";

        if (search != "") {
//            sqlStr += " WHERE (`place_name` like '%" + search + "%')";
        }

        this.statement = this.connection.createStatement();
        this.resultSet = this.statement.executeQuery(sqlStr);
        resultSet.next();
        return resultSet.getInt("soLuong");
    }

    public String getPagingString(int currentPage, String search, String sortColumn) {
        String strPaging = "<ul class='pagination'>";
        try {
            int tongSoSanPham = getNumberOfProduct(currentPage, search, sortColumn);
            int tongSoTrang = (int) Math.ceil(tongSoSanPham / SoDong_Trang);
            for (int stt_trang = 1; stt_trang <= tongSoTrang; stt_trang++) {
                if (search == "") {
                    if (stt_trang == currentPage) {
                        strPaging += "<li class='page-item active'><a class='page-link' href='?postNo=" + stt_trang + "'>" + stt_trang + "</a></li>";
                    } else {
                        strPaging += "<li class='page-item'><a class='page-link' href='?postNo=" + stt_trang + "'>" + stt_trang + "</a></li>";
                    }
                } else {
                    if (stt_trang == currentPage) {
                        strPaging += "<li class='page-item active'><a class='page-link' href='?postNo=" + stt_trang + "&s=" + search + "'>" + stt_trang + "</a></li>";
                    } else {
                        strPaging += "<li class='page-item'><a class='page-link' href='?postNo=" + stt_trang + "&s=" + search + "'>" + stt_trang + "</a></li>";
                    }
                }
            }

            strPaging += "</ul>";
        } catch (SQLException ex) {
            Logger.getLogger(PlaceModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return strPaging;
    }
}
