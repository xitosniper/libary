/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DBLib.ConnectionLib;
import Info.PostInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    ConnectionLib con = new ConnectionLib();

    /**
     * Create PostModel constructor  to connect this application with database on mysql
     */
    public PostModel() {
        connection = con.getConnection();
    }

    /**
     * Create ArrayList to pull all information of Post from database into ArrayList     *
     * @return
     * @throws java.sql.SQLException
     */
    public ArrayList<PostInfo> getPost() throws SQLException {
        ArrayList<PostInfo> postInfoList = new ArrayList<>();
        String sql = "SELECT * FROM `post` WHERE `status` = 1";
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            postInfoList.add(new PostInfo(resultSet.getInt("post_id"), resultSet.getInt("place_id"), resultSet.getString("post_text"),
                    resultSet.getDate("post_time"), resultSet.getInt("status"), resultSet.getInt("user_id"), resultSet.getInt("editor_id")));
        }
        return postInfoList;     
    }

    /**
     * Create insertPost method to add new post 
     * @param postInfo
     * @throws SQLException 
     */
    public void insertPost(PostInfo postInfo) throws SQLException {
        String sql = "INSERT INTO `post`(`place_id`, `post_text`, `post_time`, `status`, `user_id`, `editor_id`) VALUES (?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, postInfo.getPlace_id());
        preparedStatement.setString(2, postInfo.getPost_text());
        preparedStatement.setDate(3, postInfo.getPost_time());
        preparedStatement.setInt(4, postInfo.getStatus());
        preparedStatement.setInt(5, postInfo.getUser_id());
        preparedStatement.setInt(6, postInfo.getEditor_id());
        
        preparedStatement.executeUpdate();        
    }
    
    /**
     * Create UpdatePost method to modify information of the post
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
     * @param post_id
     * @return
     * @throws SQLException 
     */
    public ArrayList<PostInfo> searchPost(PostInfo postInfo) throws SQLException {
        //pl is postList
        ArrayList<PostInfo> pl = new ArrayList<>();
        String sql = "SELECT `place_id`, `post_text`, `post_time`, `status`, `user_id`, `editor_id` FROM `post` WHERE `post_id` = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, postInfo.getPost_id());
        
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            pl.add(new PostInfo(resultSet.getInt("place_id"), resultSet.getString("post_text"),
                    resultSet.getDate("post_time"), resultSet.getInt("status"), resultSet.getInt("user_id"), resultSet.getInt("editor_id")));
        }
        
        return pl;
    }
}
