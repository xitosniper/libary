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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author DELL
 */
public class UserModel {

    //call Class
    ConnectionLib cl = new ConnectionLib();
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public static int SoDong_Trang = 10;

//    ConnectionLib con = new ConnectionLib();
    //crete userinfo list
    private ArrayList<UserInfo> userList;
    private ArrayList<UserInfo> userUPList;

    /**
     * Constructor of user model
     */
    public UserModel(Connection connection) throws SQLException {
        this.connection = connection;
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
    public ArrayList<UserInfo> getUser() throws SQLException {
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

        String sqlStr = "INSERT INTO user`(user_id`, user_name, user_gender, user_img, user_phone, user_address, user_username, user_password, status, role_id) VALUES (?,?,?,?,?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, GetAllUser().size());
        preparedStatement.setString(2, userInfo.getUser_name());
        preparedStatement.setInt(3, userInfo.getUser_gender());
        preparedStatement.setString(4, userInfo.getUser_img());
        preparedStatement.setString(5, userInfo.getUser_phone());
        preparedStatement.setString(6, userInfo.getUser_address());
        preparedStatement.setString(7, userInfo.getUser_username());
        preparedStatement.setString(8, EncodeMD5.getMD5(userInfo.getUser_password()));
        preparedStatement.setInt(9, userInfo.getStatus());
        preparedStatement.setInt(10, userInfo.getRole_id());
        preparedStatement.executeUpdate();
    }

    /**
     * update data to database
     *
     * @param userInfo
     * @throws SQLException
     */
    public void updateUser(int user_id, String user_name, int user_gender, String user_img, String user_phone, String user_address, String user_username, int status, int role_id) throws SQLException {
        String sqlStr = "UPDATE user SET user_name = ?, user_gender = ?, user_img = ?, user_phone = ?, user_address = ?, user_username = ?, status = ?, role_id = ? WHERE user_id = ?";
        preparedStatement = connection.prepareStatement(sqlStr);
        preparedStatement.setString(1, user_name);
        preparedStatement.setInt(2, user_gender);
        preparedStatement.setString(3, user_img);
        preparedStatement.setString(4, user_phone);
        preparedStatement.setString(5, user_address);
        preparedStatement.setString(6, user_username);
        preparedStatement.setInt(7, status);
        preparedStatement.setInt(8, role_id);
        preparedStatement.setInt(9, user_id);

        //update new data 
        preparedStatement.executeUpdate();
    }

    /**
     * get all user
     *
     * @throws SQLException
     */
    public ArrayList<UserInfo> GetAllUser() throws SQLException {
        userList = new ArrayList<>();
        statement = connection.createStatement();
        String sqlStr = "SELECT * FROM user";
        resultSet = statement.executeQuery(sqlStr);
        while (resultSet.next()) {
            userList.add(new UserInfo(resultSet.getInt("user_id"), resultSet.getString("user_name"), resultSet.getInt("user_gender"), resultSet.getString("user_img"), resultSet.getString("user_phone"), resultSet.getString("user_address"), resultSet.getString("user_username"), resultSet.getString("user_password"), resultSet.getInt("status"), resultSet.getInt("role_id")));
        }
        return userList;
    }

    /**
     * Delete user
     *
     * @param user_id
     * @throws SQLException
     */
    public void deleteUser(int user_id) throws SQLException {
        String sqlStr = " UPDATE user SET status`=0 WHEREuser_id`=? ";
        preparedStatement = connection.prepareStatement(sqlStr);
        preparedStatement.setInt(1, user_id);
        preparedStatement.executeUpdate();
    }

    public UserInfo getUserID(int id) throws SQLException {
        String strSql = "SELECT * FROM user WHERE user_id = " + id;

        statement = connection.createStatement();
        resultSet = statement.executeQuery(strSql);
        resultSet.next();

        int user_id = resultSet.getInt("user_id");
        String user_name = resultSet.getString("user_name");
        int user_gender = resultSet.getInt("user_gender");
        String user_img = resultSet.getString("user_img");
        String user_phone = resultSet.getString("user_phone");
        String user_address = resultSet.getString("user_address");
        String user_userName = resultSet.getString("user_username");
        int user_status = resultSet.getInt("status");
        int role_id = resultSet.getInt("role_id");

        UserInfo userDT = new UserInfo(user_id, user_name, user_gender, user_img, user_phone, user_address, user_userName, user_status, role_id);

        return userDT;
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

    public boolean checkAccount(String userName, String password) throws SQLException {
        userUPList = new ArrayList<>();
        userUPList = getUser();
        for (int i = 0; i < userUPList.size(); i++) {
            UserInfo account = userUPList.get(i);
            if (userName.equals(account.getUser_username())) {
                if (EncodeMD5.getMD5(password).equals(account.getUser_password())) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<UserInfo> getPaging(int page, String search) throws SQLException {

        String sqlStr = " SELECT * FROM user";
        if (search != "") {
            sqlStr += " WHERE (user_name like '%" + search + "%')";
        }

        //Phan Trang
        int tongSoUser = getNumberUser(page, search);
        int tongSoTrang = (int) Math.ceil(tongSoUser / SoDong_Trang) + 1;
        int index = (page - 1) * SoDong_Trang;

        sqlStr += " LIMIT " + index + ", " + SoDong_Trang;

        this.statement = this.connection.createStatement();
        this.resultSet = this.statement.executeQuery(sqlStr);
        userList = new ArrayList<UserInfo>();
        while (resultSet.next()) {
            int user_id = resultSet.getInt("user_id");
            String user_name = resultSet.getString("user_name");
            int user_gender = resultSet.getInt("user_gender");
            String user_img = resultSet.getString("user_img");
            String user_phone = resultSet.getString("user_phone");
            String user_address = resultSet.getString("user_address");
            String user_userName = resultSet.getString("user_username");
            int user_status = resultSet.getInt("status");
            int role_id = resultSet.getInt("role_id");

            userList.add(new UserInfo(user_id, user_name, user_gender, user_img, user_phone, user_address, user_userName, user_status, role_id));
        }
        return userList;
    }

    public int getNumberUser(int page, String search) throws SQLException {
        String sqlStr = " SELECT count(*) as soLuong FROM user ";

        if (search != "") {
            //find
            sqlStr += " WHERE (user_name like '%" + search + "%')";
        }
        this.statement = this.connection.createStatement();
        this.resultSet = this.statement.executeQuery(sqlStr);
        resultSet.next();
        return resultSet.getInt("soLuong");
    }

    public String getPagingString(int currentPage, String search) {
        String strPaging = "<ul class='pagination'>";
        try {
            int tongSoSanPham = getNumberUser(currentPage, search);
            int tongSoTrang = (int) Math.ceil(tongSoSanPham / SoDong_Trang) + 1;
            for (int stt_trang = 1; stt_trang <= tongSoTrang; stt_trang++) {
                if (search == "") {
                    if (stt_trang == currentPage) {
                        strPaging += "<li class='active'><a href='?trang=" + stt_trang + "'>" + stt_trang + "</a></li>";
                    } else {
                        strPaging += "<li><a href='?trang=" + stt_trang + "'>" + stt_trang + "</a></li>";
                    }
                } else if (stt_trang == currentPage) {
                    strPaging += "<li class='active'><a href='?trang=" + stt_trang + "&s=" + search + "'>" + stt_trang + "</a></li>";
                } else {
                    strPaging += "<li><a href='?trang=" + stt_trang + "&s=" + search + "'>" + stt_trang + "</a></li>";
                }
            }
            strPaging += "</ul>";
        } catch (SQLException ex) {
            Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return strPaging;
    }
}
