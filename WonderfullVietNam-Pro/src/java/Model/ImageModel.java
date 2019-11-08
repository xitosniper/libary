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
    public ImageModel() throws SQLException {
        try {
            conn = cl.getConnection();
            st = conn.createStatement();
            pst = null;
            rs = null;
            sqlStr = "";
            ListImage = new ArrayList<>();
            LoadImage();
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * load data from database
     */
    public void LoadImage() {
        try {
            sqlStr = "SELECT * FROM " + tableName;
            rs = st.executeQuery(sqlStr);
            if (rs.isBeforeFirst()) {
                ListImage.clear();
                while (rs.next()) {
                    ListImage.add(new ImageInfo(rs.getInt("Image_id"), rs.getString("Image_name"), rs.getInt("Status")));
                }
            }
        } catch (SQLException e) {
        }
    }

    /**
     * add to data to database
     *
     * @param Image_id
     * @param Image_time
     * @param Status
     * @return
     * @throws SQLException
     */
    public boolean addImage(int Image_id, String Image_time, int Status) throws SQLException {
        try {
            sqlStr = "INSERT INTO `Image`(`Image_id`,`Image_time`,`Status`) VALUES (?,?,?)";
            pst = conn.prepareStatement(sqlStr);
            pst.setInt(1, Image_id);
            pst.setString(2, Image_time);
            pst.setInt(3, Status);
            pst.executeUpdate();
            ListImage.add(new ImageInfo(rs.getInt("Image_id"), rs.getString("Image_name"), rs.getInt("Status")));
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
    public boolean updateImage(int Image_id, String Image_time, int Status) throws SQLException {
        try {
            sqlStr = "UPDATE `Image` SET 'Image_id'=?, 'Image_time'=?, 'Status'=? WHERE 'Editor_id'=?";
            pst = conn.prepareStatement(sqlStr);
            pst.setInt(1, Image_id);
            pst.setString(2, Image_time);
            pst.setInt(3, Status);
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
     * search by Image_id
     *
     * @param Image_id return Image
     *
     */
    public ImageInfo Search(int Id) {
        for (int i = 0; i < ListImage.size(); i++) {
            ImageInfo a = ListImage.get(i);
            if (a.getImage_id() == Id) {
                return ListImage.get(i);
            }
        }
        return null;
    }

    /**
     * DeleteImage
     *
     * @param I
     * @throws SQLException
     */
    public void DeleteImage(ImageInfo I) throws SQLException {
        try {
            String sql = "UPDATE `Image` SET `status`=0 WHERE `Editor_id` = ?";
            pst = conn.prepareStatement(sqlStr);
            pst.setInt(0, I.getImage_id());
            pst.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
