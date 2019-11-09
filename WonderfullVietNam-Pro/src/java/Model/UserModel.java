/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DBLib.ConnectionLib;
import Info.UserInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author DELL
 */
public class UserModel {

    //call Class
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

//    ConnectionLib con = new ConnectionLib();
    //crete userinfo list
    private ArrayList<UserInfo> userList;
    private ArrayList<UserInfo> userUPList;

    /**
     * Constructor of user model
     *
     * @throws java.sql.SQLException
     */
    public UserModel(Connection con) throws SQLException {
        this.connection = con;
        preparedStatement = null;
        statement = null;
        userList = new ArrayList<>();
    }

    /**
     * Select and add element from table to list
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<UserInfo> GetUser() throws SQLException {
        userList = new ArrayList<>();
        statement = connection.createStatement();
        String sqlStr = "SELECT * FROM user WHERE status = 1";
        resultSet = statement.executeQuery(sqlStr);
        while (resultSet.next()) {
            userList.add(new UserInfo(resultSet.getInt("user_id"), resultSet.getString("user_name"), resultSet.getInt("user_gender"), resultSet.getString("user_img"), resultSet.getString("user_phone"), resultSet.getString("user_address"), resultSet.getString("user_username"), resultSet.getString("user_password"), resultSet.getInt("status"), resultSet.getInt("role_id")));
        }
        return userList;
    }

    /**
     * insert new data into database
     *
     * @param userInfo
     * @throws SQLException
     */
    public void insertUser(UserInfo userInfo) throws SQLException {
        
        String sqlStr = "INSERT INTO `user`(`user_name`, `user_gender`, `user_img`, `user_phone`, `user_address`, `user_username`, `user_password`, `status`, `role_id`) VALUES (?,?,?,?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, userInfo.getUser_name());
        preparedStatement.setInt(2, userInfo.getUser_gender());
        preparedStatement.setString(3, userInfo.getUser_img());
        preparedStatement.setString(4, userInfo.getUser_phone());
        preparedStatement.setString(5, userInfo.getUser_address());
        preparedStatement.setString(6, userInfo.getUser_username());
        preparedStatement.setString(7, userInfo.getUser_password());
        preparedStatement.setInt(8, userInfo.getStatus());
        preparedStatement.setInt(9, userInfo.getRole_id());
        preparedStatement.executeUpdate();
    }

    /**
     * update data to database
     *
     * @param userInfo
     * @throws SQLException
     */
    public void updateUser(UserInfo userInfo) throws SQLException {
        String sqlStr = "UPDATE user SET user_name = ?, user_gender = ?, user_img = ?, user_phone = ?, user_address = ?, user_username = ?, user_password = ?, status = ?, role_id = ? WHERE user_id = ?";
        preparedStatement = connection.prepareStatement(sqlStr);
        preparedStatement.setString(1, userInfo.getUser_name());
        preparedStatement.setInt(2, userInfo.getUser_gender());
        preparedStatement.setString(3, userInfo.getUser_img());
        preparedStatement.setString(4, userInfo.getUser_phone());
        preparedStatement.setString(5, userInfo.getUser_address());
        preparedStatement.setString(6, userInfo.getUser_username());
        preparedStatement.setString(7, userInfo.getUser_password());
        preparedStatement.setInt(8, userInfo.getStatus());
        preparedStatement.setInt(9, userInfo.getRole_id());

        //update new data 
        preparedStatement.executeUpdate();
    }

    /**
     * get all user
     *
     * @throws SQLException
     */
    public void GetAllUser() throws SQLException {
        String sqlStr = "SELECT * FROM user";
        preparedStatement = connection.prepareStatement(sqlStr);

        //show all user new data 
        preparedStatement.executeUpdate();
    }

    /**
     * Delete user
     *
     * @param user_id
     * @throws SQLException
     */
    public void deleteUser(int user_id) throws SQLException {
        String sqlStr = "UPDATE `user` SET `status`= 0 WHERE `user_id`";
        preparedStatement = connection.prepareStatement(sqlStr);
        preparedStatement.setInt(1, user_id);
        preparedStatement.executeUpdate();
    }

    /**
     * search user
     *
     * @param username
     * @return
     * @throws SQLException
     */
    public UserInfo searchUser(String username) throws SQLException {
        userList = GetUser();
        for (UserInfo userInfo : userList) {
            if (userInfo.getUser_username().equals(username)) {
                return userInfo;
            }
        }
        return null;
    }
    /**
     * Method searchUserName by name and return id of user
     * @param username
     * @return
     * @throws SQLException 
     */
    public int searchUserName(String username) throws SQLException {
        ArrayList<UserInfo> userList = GetUser();
        for (UserInfo userInfo : userList) {
            if (userInfo.getUser_username().equals(username)) {
                return userInfo.getUser_id();
            }
        }
        return -1;
        
    }

    /**
     * check user input user name
     *
     * @param userInput
     * @return
     */
    public boolean regexUserName(String userInput) {
        String regex = "^[a-zA-Z0-9_-]{4,16}$";
        //Create pattern by method to compiling regex
        Pattern pattern = Pattern.compile(regex);
        //Create matcher
        Matcher matcher = pattern.matcher(userInput);
        //check data user inputed with regex
        boolean checkUS = matcher.matches();
        //return result
        return checkUS;
    }

    /**
     * check user input password
     *
     * @param userInput
     * @return
     */
    public boolean regexPassword(String userInput) {
        String regex = "^[a-zA-Z0-9_-]{6,16}$";
        //Create pattern by method to compiling regex
        Pattern pattern = Pattern.compile(regex);
        //Create matcher
        Matcher matcher = pattern.matcher(userInput);
        //check data user inputed with regex
        boolean checkPWD = matcher.matches();
        //return result
        return checkPWD;
    }
    
    public boolean checkAccount(String username, String password) throws SQLException {
        ArrayList<UserInfo> userList = GetUser();
        EncodeMD5 d5 = new EncodeMD5();
        for (UserInfo userInfo : userList) {
            if (username.equals(userInfo.getUser_username()) && d5.getMD5(password).equals(userInfo.getUser_password())) {
                return true;
            }
        }
        return false;
    }
}
