/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DBLib.ConnectionLib;
import Model.CommentModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author haumqce130436@fpt.edu.vn
 */
public class demo {
        private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;
    private static Connection connection;

    public static void main(String[] args) throws SQLException {
        Connection con = ConnectionLib.getConnection();
        CommentModel cm = new CommentModel(con);

        String sql = "INSERT INTO `comment`(`comment_id`, `comment_email`, `comment_description`, `status`, `user_id`, `post_id`) VALUES (?,?,?,?,?,?)";
        preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, cm.getAllComment().size());
        preparedStatement.setString(2, "antu@gmail.com");
        preparedStatement.setString(3, "asdasdasdasdasdassadasdsadsada");
        preparedStatement.setInt(4, 1);
        preparedStatement.setInt(5, 1);
        preparedStatement.setInt(6, 2);

        preparedStatement.executeUpdate();

    }
}
