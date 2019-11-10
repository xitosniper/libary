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
import Info.RoleInfo;

/**
 *
 * @author DELL
 */
public class RoleModel {
    //call Class
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    //crete userinfo list
    private ArrayList<RoleInfo> roleList;
    
    /**
     * Constructor of user model
     */
    public RoleModel(Connection con) throws SQLException {
        this.connection = con;
        preparedStatement = null;
        statement = null;
        roleList = new ArrayList<>();
    }
    /**
     * create role list
     * @return
     * @throws SQLException 
     */
    public ArrayList<RoleInfo> getRole() throws SQLException {
        roleList = new ArrayList<>();
        statement = connection.createStatement();
        String sqlStr = "SELECT * FROM `role` WHERE status = 1";
        resultSet = statement.executeQuery(sqlStr);
        while(resultSet.next()) {
            roleList.add(new RoleInfo(resultSet.getInt("role_id"),resultSet.getString("role_name"),resultSet.getString("role_description"), resultSet.getInt("status")));
        }
        return roleList;
    }
    
    /**
     * insert new role
     * @param roleInfo
     * @throws SQLException 
     */
    public void insertRole(RoleInfo roleInfo) throws SQLException {
        
        String sqlStr = "INSERT INTO `role`(`role_name`, `role_description`, `status`) VALUES (?,?,?)";
        preparedStatement = connection.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, roleInfo.getRole_name());
        preparedStatement.setString(2, roleInfo.getRole_description());
        preparedStatement.setInt(3, roleInfo.getStatus());
        preparedStatement.executeUpdate();
    }
    
    /**
     * update role
     * @param roleInfo
     * @throws SQLException 
     */
    public void updateRole(RoleInfo roleInfo) throws SQLException{
        String sqlStr = "UPDATE `role` SET `role_name`=?,`role_description`=?,`status`=? WHERE `role_id`=?";
        preparedStatement = connection.prepareStatement(sqlStr);
        preparedStatement.setString(1, roleInfo.getRole_name());
        preparedStatement.setString(2, roleInfo.getRole_description());
        preparedStatement.setInt(3, roleInfo.getStatus());
        preparedStatement.setInt(4, roleInfo.getRole_id());
        
        //update new data 
        preparedStatement.executeUpdate();
    }
    
    /**
     * get all role
     * @throws SQLException 
     */
    public void GetAllRole() throws SQLException{
        String sqlStr = "SELECT * FROM role";
        preparedStatement = connection.prepareStatement(sqlStr);
        
        //show all user new data 
        preparedStatement.execute();
    }
    
}
