/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DBLib.ConnectionLib;
import Info.ImageInfo;
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
public class ImageModel {

    private ArrayList<ImageInfo> ListImage;
    ConnectionLib cl = new ConnectionLib();

    /**
     * get ArrayList
     *
     * @return
     */
    public ArrayList<ImageInfo> getListImage() {
        return ListImage;
    }

    /**
     * Stores database table Stores connection object Stores Statement object
     * Stores prepared statement object Stores result set object; Stores mysql
     * statement
     */
    private static final String tableName = "Image";
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
    public ImageModel(Connection connection) throws SQLException {
        this.conn = connection;
        st = conn.createStatement();
        pst = null;
        rs = null;
        sqlStr = "";
        ListImage = new ArrayList<>();
        LoadImage();
    }

    /**
     * load data from database
     */
    public void LoadImage() throws SQLException {
        sqlStr = "SELECT * FROM `image`";
        rs = st.executeQuery(sqlStr);
        while (rs.next()) {
            ListImage.add(new ImageInfo(rs.getInt("image_id"), rs.getString("image_name"), rs.getInt("status"), rs.getInt("place_id")));
        }

    }

    /**
     * add to data to database
     *
     * @param image_id
     * @param image_name
     * @param status
     * @param place_id
     * @return
     * @throws SQLException
     */
    public boolean addImage(int image_id, String image_name, int status, int place_id) throws SQLException {
        try {
            sqlStr = "INSERT INTO `image`(`image_id`,`image_name`,`status`) VALUES (?,?,?,?)";
            pst = conn.prepareStatement(sqlStr);
            pst.setInt(1, image_id);
            pst.setString(2, image_name);
            pst.setInt(3, status);
            pst.setInt(4, place_id);
            pst.executeUpdate();
            ListImage.add(new ImageInfo(rs.getInt("image_id"), rs.getString("image_name"), rs.getInt("status"), rs.getInt("place_id")));
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
     * @param Image_id
     * @param Image_time
     * @param Status
     * @return
     * @throws SQLException
     */
    public boolean updateImage(int image_id, String image_name, int status, int place_id) throws SQLException {
        try {
            sqlStr = "UPDATE `image` SET 'image_id'=?, 'image_name'=?, 'status'=? WHERE 'image_id'=?";
            pst = conn.prepareStatement(sqlStr);
            pst.setInt(1, image_id);
            pst.setString(2, image_name);
            pst.setInt(3, status);
            pst.setInt(4, place_id);
            pst.executeUpdate();
            LoadImage();
            conn.close();
            return true;
        } catch (SQLException e) {
        }
        conn.close();
        return false;
    }
    /**
     * DeleteImage
     *
     * @param I
     * @throws SQLException
     */
    public void DeleteImage(ImageInfo I) throws SQLException {
        try {
            String sql = "UPDATE `image` SET `status`=0 WHERE `editor_id` = ?";
            pst = conn.prepareStatement(sqlStr);
            pst.setInt(0, I.getImage_id());
            pst.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
