/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DBLib.ConnectionLib;
import Info.Type_of_placeInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author haumqce130436@fpt.edu.vn
 */
public class Type_of_placeModel {
        /*Declare variables*/
    private Connection connection;
    private Statement statement;
    private PreparedStatement preStatement;
    private ResultSet resultSet;
    public static ArrayList<Type_of_placeInfo> type_of_placeInfos;
    ConnectionLib cl = new ConnectionLib();
    /**
     * Constructor TypeModel
     */
    public Type_of_placeModel() {
        try {
            connection = cl.getConnection();
            statement = connection.createStatement();
        } catch (SQLException e) {
            //Error SQLException
            System.out.println("SQL Exception in Type_of_placeModel");
        }
    }
    /**
     * Method get data from mysql into list types
     * @return
     * @throws SQLException 
     */
    public ArrayList<Type_of_placeInfo> getType_of_place() throws SQLException{
        ArrayList<Type_of_placeInfo> type_of_places =  new ArrayList<>();
        connection = cl.getConnection();
        String sql = "SELECT * FROM `type`";
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {            
            type_of_places.add(new Type_of_placeInfo(resultSet.getInt("type_of_place_id"), resultSet.getInt("type_id"), resultSet.getInt("place_id")));
        }
        return type_of_places;
    }
    /**
     * Method insert type into database 
     * @throws SQLException 
     */
    public void insertType_of_place(Type_of_placeInfo type_of_placeInfo) throws SQLException {
        try {
            String sqlStr = "INSERT INTO `type`(`type_of_place_id`,`type_id`, `place_id`) VALUES (?,?,?)";
            preStatement = connection.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
            preStatement.setInt(1, getType_of_place().size());
            preStatement.setInt(2, type_of_placeInfo.getType_id());
            preStatement.setInt(3, type_of_placeInfo.getPlace_id());
            //Update server
            preStatement.executeUpdate();
            System.out.println("Insert type_of_place successfull!");
        } catch (SQLException ex) {
            System.out.println("Insert type_of_place failure! " + ex);
        }
    }
    /**
     * Method update type into database
     * @param type_id
     * @param typeInfo
     * @throws SQLException 
     */
    public void updateType_of_place(int type_of_place_id, Type_of_placeInfo type_of_placeInfo) throws SQLException {
        ArrayList<Type_of_placeInfo> type_of_placeInfos = getType_of_place();
        try {
            String sqlStr = "UPDATE `type` SET `type_id`=?,`place_id`=? WHERE `type_of_place_id`=?";
            preStatement = connection.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < type_of_placeInfos.size(); i++) {
                if (type_of_place_id == type_of_placeInfos.get(i).getType_of_place_id()) {
                    preStatement.setInt(1, type_of_placeInfos.get(i).getType_id());
                    preStatement.setInt(2, type_of_placeInfos.get(i).getPlace_id());
                    preStatement.setInt(3, type_of_place_id);
                }
            }
            //Update server
            preStatement.executeUpdate();
            System.out.println("Update type_of_place successfull!");
        } catch (SQLException ex) {
            System.out.println("Update type_of_place failure!");
        }
    }
    /**
     * Method delete type in database
     * @param type_id
     * @param typeInfo
     * @throws SQLException 
     */
    public void deleteType_of_place(int type_of_place_id, Type_of_placeInfo type_of_placeInfo) throws SQLException {
        ArrayList<Type_of_placeInfo> type_of_placeInfos = getType_of_place();
        try {
            String sqlStr = "DELETE FROM `type_of_place` WHERE `type_of_place_id` = ?";
            preStatement = connection.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < type_of_placeInfos.size(); i++) {
                if (type_of_place_id == type_of_placeInfos.get(i).getType_of_place_id()) {
                    preStatement.setInt(1, type_of_place_id);
                }
            }
            //Update server
            preStatement.executeUpdate();
            System.out.println("Delete type_of_place successfull!");
        } catch (SQLException ex) {
            System.out.println("Delete type_of_place failure!");
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
