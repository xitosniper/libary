/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DBLib.ConnectionLib;
import Info.TypeInfo;
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
 * @author haumqce130436@fpt.edu.vn
 */
public class TypeModel {
    /*Declare variables*/
    private Connection connection;
    private Statement statement;
    private PreparedStatement preStatement;
    private ResultSet resultSet;
    public static ArrayList<TypeInfo> typeInfos;
    ConnectionLib cl = new ConnectionLib();
    /**
     * Constructor TypeModel
     */
    public TypeModel() {
        try {
            connection = cl.getConnection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            //Error SQLException
            System.out.println("SQL Exception in TypeModel");
        }
    }
    /**
     * Method get data from mysql into list types
     * @return
     * @throws SQLException 
     */
    public ArrayList<TypeInfo> getType() throws SQLException{
        ArrayList<TypeInfo> types =  new ArrayList<>();
        connection = cl.getConnection();
        String sql = "SELECT * FROM `type` WHERE `status` = 1";
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {            
            types.add(new TypeInfo(resultSet.getInt("type_id"), resultSet.getString("type_name"), resultSet.getInt("status")));
        }
        return types;
    }
        /**
     * Method get all data from mysql into list types
     * @return
     * @throws SQLException 
     */
    public ArrayList<TypeInfo> getAllType() throws SQLException{
        ArrayList<TypeInfo> types =  new ArrayList<>();
        connection = cl.getConnection();
        String sql = "SELECT * FROM `type`";
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {            
            types.add(new TypeInfo(resultSet.getInt("type_id"), resultSet.getString("type_name"), resultSet.getInt("status")));
        }
        return types;
    }
    /**
     * Method insert type into database 
     * @throws SQLException 
     */
    public void insertType(TypeInfo typeInfo) throws SQLException {
        try {
            String sqlStr = "INSERT INTO `type`(`type_id`,`type_name`, `status`) VALUES (?,?,?)";
            preStatement = connection.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
            preStatement.setInt(1, getAllType().size());
            preStatement.setString(2, typeInfo.getType_name());
            preStatement.setInt(3, 1);
            //Update server
            preStatement.executeUpdate();
            System.out.println("Insert type successfull!");
        } catch (SQLException ex) {
            System.out.println("Insert type failure!");
        }
    }
    /**
     * Method update type into database
     * @param type_id
     * @param typeInfo
     * @throws SQLException 
     */
    public void updateType(int type_id, TypeInfo typeInfo) throws SQLException {
        ArrayList<TypeInfo> typeInfos = getType();
        try {
            String sqlStr = "UPDATE `type` SET `type_name`=?,`status`=? WHERE `type_id`=?";
            preStatement = connection.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < typeInfos.size(); i++) {
                if (type_id == typeInfos.get(i).getType_id()) {
                    preStatement.setString(1, typeInfo.getType_name());
                    preStatement.setInt(2, typeInfo.getStatus());
                    preStatement.setInt(3, type_id);
                }
            }
            //Update server
            preStatement.executeUpdate();
            System.out.println("Update type successfull!");
        } catch (SQLException ex) {
            System.out.println("Update type failure!");
        }
    }
    /**
     * Method delete type in database
     * @param type_id
     * @param typeInfo
     * @throws SQLException 
     */
    public void deleteType(int type_id, TypeInfo typeInfo) throws SQLException {
        ArrayList<TypeInfo> typeInfos = getType();
        try {
            String sqlStr = "UPDATE `type` SET `status`=? WHERE `type_id`=?";
            preStatement = connection.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < typeInfos.size(); i++) {
                if (type_id == typeInfos.get(i).getType_id()) {
                    preStatement.setInt(1, 0);
                    preStatement.setInt(2, type_id);
                }
            }
            //Update server
            preStatement.executeUpdate();
            System.out.println("Delete type successfull!");
        } catch (SQLException ex) {
            System.out.println("Delete type failure!");
        }
    }
    /**
     * Close connection
     *
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        connection.close();
    }
}
