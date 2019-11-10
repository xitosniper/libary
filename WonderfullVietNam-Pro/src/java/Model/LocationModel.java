/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DBLib.ConnectionLib;
import Info.LocationInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class LocationModel {

    private ArrayList<LocationInfo> ListLocation;

    /**
     * get ArrayList
     *
     * @return
     */
    public ArrayList<LocationInfo> getListLocation() {
        return ListLocation;
    }

    /**
     * Stores database table Stores connection object Stores Statement object
     * Stores prepared statement object Stores result set object; Stores mysql
     * statement
     */
    private static Connection conn;
    private static Statement st;
    private static PreparedStatement pst;
    private static ResultSet rs;
    private static String sqlStr;

    /**
     * connect to mysql
     *
     * @throws SQLException
     */
    public LocationModel(Connection connection) throws SQLException {
        try {
            this.conn = connection;
            st = conn.createStatement();
            pst = null;
            rs = null;
            sqlStr = "";
            ListLocation = new ArrayList<>();
            LoadLocation();
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * load data from database
     */
    public void LoadLocation() throws SQLException {

        sqlStr = "SELECT * FROM `location`";
        rs = st.executeQuery(sqlStr);

        while (rs.next()) {
            ListLocation.add(new LocationInfo(rs.getInt("location_id"), rs.getString("location_name"), rs.getString("location_description"), rs.getInt("status")));
        }

    }

    /**
     * add to data to database
     *
     * @param Location_id
     * @param Location_name
     * @param Location_description
     * @param Status
     * @return
     * @throws SQLException
     */
    public boolean addLocation(int Location_id, String Location_name, String Location_description, int Status) throws SQLException {
        try {
            sqlStr = "INSERT INTO `Location`(`Location_id`,`Location_name`,`Location_description`,`Status`) VALUES (?,?,?,?)";
            pst = conn.prepareStatement(sqlStr);
            pst.setInt(1, Location_id);
            pst.setString(2, Location_name);
            pst.setString(3, Location_description);
            pst.setInt(4, Status);
            pst.executeUpdate();
            ListLocation.add(new LocationInfo(rs.getInt("Location_id"), rs.getString("Location_name"), rs.getString("Location_description"), rs.getInt("Status")));
            System.out.println("TRUE");
            return true;
        } catch (SQLException e) {
            System.out.println("WRONG");
            throw e;
        } catch (Exception e) {
            System.out.println("WRONG");
            throw e;
        }
    }

    /**
     * update to database
     *
     * @param Location_id
     * @param Location_name
     * @param Location_description
     * @param Status
     * @return
     * @throws SQLException
     */
    public boolean updateLocation(int Location_id, String Location_name, String Location_description, int Status) throws SQLException {
        try {
            sqlStr = "UPDATE `Location` SET 'Location_id'=?, 'Location_name'=?, 'Location_description'=?, 'Status'=? WHERE 'Location_id'=?";
            pst = conn.prepareStatement(sqlStr);
            pst.setInt(1, Location_id);
            pst.setString(2, Location_name);
            pst.setString(3, Location_description);
            pst.setInt(4, Status);
            pst.executeUpdate();
            LoadLocation();
            conn.close();
            return true;
        } catch (SQLException e) {
        }
        conn.close();
        return false;
    }

    /**
     * search by Location_id
     *
     * @param Location_id return Location
     *
     */
    public LocationInfo Search(int Id) {
        for (int i = 0; i < ListLocation.size(); i++) {
            LocationInfo a = ListLocation.get(i);
            if (a.getLocation_id() == Id) {
                return ListLocation.get(i);
            }
        }
        return null;
    }

    public void DeleteEditor(LocationInfo L) throws SQLException {
        try {
            String sql = "UPDATE `Location` SET `status`=0 WHERE `Location_id` = ?";
            pst = conn.prepareStatement(sqlStr);
            pst.setInt(0, L.getLocation_id());
            pst.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
