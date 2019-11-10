/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DBLib.ConnectionLib;
import Info.CommentInfo;
import java.sql.Connection;
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
public class CommentModel {
    //Declare variables

    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final Connection connection;
    public static int SoDong_Trang = 4;
    private ArrayList<CommentInfo> list;

    ConnectionLib con = new ConnectionLib();

    /**
     * Create CommentModel method to connect this application with database on
     * mysql
     */
    public CommentModel(Connection connection) {
        this.connection = connection;
    }

    /**
     * Create getComment method to get all information of any comment after push
     * into ArrayList
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<CommentInfo> getComment() throws SQLException {
        ArrayList<CommentInfo> cl = new ArrayList<>();
        String sql = "SELECT * FROM `comment` WHERE status = 1";
        preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            cl.add(new CommentInfo(resultSet.getInt("comment_id"), resultSet.getString("comment_email"), resultSet.getDate("comment_time"),
                    resultSet.getString("comment_description"), resultSet.getInt("status"), resultSet.getInt("user_id"), resultSet.getInt("post_id")));
        }
        return cl;
    }

    /**
     * Create UpdatePost method to modify information of the post
     *
     * @param commentInfo
     * @throws SQLException
     */
    public void insertComment(CommentInfo commentInfo) throws SQLException {
        String sql = "INSERT INTO `comment`(`comment_email`, `comment_time`, `comment_description`, `status`, `user_id`, `post_id`) "
                + "VALUES (?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, commentInfo.getComment_email());
        preparedStatement.setDate(2, commentInfo.getComment_time());
        preparedStatement.setString(3, commentInfo.getComment_description());
        preparedStatement.setInt(4, commentInfo.getStatus());
        preparedStatement.setInt(5, commentInfo.getUser_id());
        preparedStatement.setInt(6, commentInfo.getPost_id());

        preparedStatement.executeUpdate();
    }

    /**
     * Create updateComment method to modify information of the comment
     *
     * @param commentInfo
     * @throws SQLException
     */
    public void updateComment(CommentInfo commentInfo) throws SQLException {
        String sql = "UPDATE `comment` SET `comment_email`=?,`comment_time`=?,"
                + "`comment_description`=?,`status`=?,`user_id`=?,`post_id`=? WHERE `comment_id`=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, commentInfo.getComment_email());
        preparedStatement.setDate(2, commentInfo.getComment_time());
        preparedStatement.setString(3, commentInfo.getComment_description());
        preparedStatement.setInt(4, commentInfo.getStatus());
        preparedStatement.setInt(5, commentInfo.getUser_id());
        preparedStatement.setInt(6, commentInfo.getPost_id());
        preparedStatement.setInt(7, commentInfo.getComment_id());

        preparedStatement.executeUpdate();
    }

    /**
     * Create deleteComment method to set the status equal zero (status = 0)
     *
     * @param commentInfo
     * @throws java.sql.SQLException
     */
    public void deleteComment(CommentInfo commentInfo) throws SQLException {
        String sql = "UPDATE `comment` SET `status`=0 WHERE `comment_id` = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, commentInfo.getComment_id());

        preparedStatement.executeUpdate();
    }

    /**
     * Create searchComment method to search any comment by their's comment_id
     *
     * @param commentInfo
     * @return
     * @throws SQLException
     */
    public ArrayList<CommentInfo> seachComment(CommentInfo commentInfo) throws SQLException {
        ArrayList<CommentInfo> cl = new ArrayList<>();
        String sql = "SELECT `comment_email`, `comment_time`, `comment_description`, `status`, `user_id`, `post_id` FROM `comment` WHERE `comment_id`= ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, commentInfo.getComment_id());

        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            cl.add(new CommentInfo(resultSet.getString("comment_email"), resultSet.getDate("comment_time"), resultSet.getString("comment_description"), resultSet.getInt("status"), resultSet.getInt("user_id"), resultSet.getInt("post_id")));
        }
        return cl;
    }

    public ArrayList<CommentInfo> getPaging(int page, String search, String sortColumn) {
        try {
            String sqlStr = "";
            sqlStr += " SELECT *";
            sqlStr += " FROM `comment`";

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
            list = new ArrayList<CommentInfo>();
            while (resultSet.next()) {
                list.add(new CommentInfo(resultSet.getInt("comment_id"), resultSet.getString("comment_email"), resultSet.getDate("comment_time"),
                        resultSet.getString("comment_description"), resultSet.getInt("status"), resultSet.getInt("user_id"), resultSet.getInt("post_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.list;
    }

    public int getNumberOfProduct(int page, String search, String sortColumn) throws SQLException {
        String sqlStr = "";
        sqlStr += " SELECT count(*) as soLuong ";
        sqlStr += " FROM `comment`";

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
                        strPaging += "<li class='active'><a href='?commentNo=" + stt_trang + "'>" + stt_trang + "</a></li>";
                    } else {
                        strPaging += "<li><a href='?commentNo=" + stt_trang + "'>" + stt_trang + "</a></li>";
                    }
                } else {
                    if (stt_trang == currentPage) {
                        strPaging += "<li class='active'><a href='?commentNo=" + stt_trang + "&s=" + search + "'>" + stt_trang + "</a></li>";
                    } else {
                        strPaging += "<li><a href='?commentNo=" + stt_trang + "&s=" + search + "'>" + stt_trang + "</a></li>";
                    }
                }
            }

            strPaging += "</ul>";
        } catch (SQLException ex) {
            Logger.getLogger(CommentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return strPaging;
    }

    /**
     * Create the method accept for the comment
     *
     * @param id
     * @throws SQLException
     */
    public void acceptComment(int id) throws SQLException {
        String sql = "UPDATE `comment` SET `status`=1 WHERE `comment_id` = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
