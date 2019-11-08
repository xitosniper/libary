/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DBLib.ConnectionLib;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import wonderfulvn.CommentInfo;

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

    ConnectionLib con = new ConnectionLib();

    /**
     * Create CommentModel method to connect this application with database on mysql
     */
    public CommentModel() {
        connection = con.getConnection();
    }
    
    /**
     * Create getComment method to get all information of any comment after push into ArrayList 
     * @return
     * @throws SQLException 
     */
    public ArrayList<CommentInfo> getComment() throws SQLException {
        ArrayList<CommentInfo> cl = new ArrayList<>();
        String sql = "SELECT * FROM `comment` WHERE status = 1";
        preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            cl.add(new CommentInfo(resultSet.getInt("comment_id"), resultSet.getString("comment_email"), resultSet.getDate("comment_time"),
                    resultSet.getString("comment_description"), resultSet.getInt("status"), resultSet.getInt("user_id"), resultSet.getInt("post_id")));
        }
        return cl;
    }
    
    /**
     * Create UpdatePost method to modify information of the post
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
        while(resultSet.next()) {
            cl.add(new CommentInfo( resultSet.getString("comment_email"), resultSet.getDate("comment_time"), resultSet.getString("comment_description"), resultSet.getInt("status"), resultSet.getInt("user_id"), resultSet.getInt("post_id")));
        }
        return cl;
    }
}
