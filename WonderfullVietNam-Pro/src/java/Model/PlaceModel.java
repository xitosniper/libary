/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Info.PlaceInfo;
import java.sql.Connection;
import java.sql.Date;
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
public class PlaceModel {

    /*Declare variables*/
    private Connection connection;
    private Statement statement;
    private PreparedStatement preStatement;
    private ResultSet resultSet;
    public static ArrayList<PlaceInfo> placeInfos;
    public static int SoDong_Trang = 4;
    private ArrayList<PlaceInfo> list;

    /**
     * Constructor TypeModel
     *
     * @param connection
     */
    public PlaceModel(Connection connection) {
        try {
            this.connection = connection;
            statement = connection.createStatement();
        } catch (SQLException e) {
            //Error SQLException
            System.out.println("SQL Exception in TypeModel");
        }
    }

    /**
     * Method get data from mysql into list places
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<PlaceInfo> getPlace() throws SQLException {
        ArrayList<PlaceInfo> places = new ArrayList<>();
        String sql = "SELECT * FROM `place` WHERE `status` = 1";
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            places.add(new PlaceInfo(resultSet.getInt("place_id"), resultSet.getString("place_name"), resultSet.getString("place_description"), resultSet.getInt("status"), resultSet.getInt("location_id")));
        }
        return places;
    }

        /**
     * Method get data from mysql into list places
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<PlaceInfo> getPlaceByLocation(int location_id) throws SQLException {
        ArrayList<PlaceInfo> places = new ArrayList<>();
        String sql = "SELECT * FROM `place` WHERE `status` = 1 AND `location_id` = " + location_id;
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            places.add(new PlaceInfo(resultSet.getInt("place_id"), resultSet.getString("place_name"), resultSet.getString("place_description"), resultSet.getInt("status"), resultSet.getInt("location_id")));
        }
        return places;
    }
    /**
     * Method get all data from mysql into list places
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<PlaceInfo> getAllPlace() throws SQLException {
        ArrayList<PlaceInfo> places = new ArrayList<>();
        String sql = "SELECT * FROM `place`";
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            places.add(new PlaceInfo(resultSet.getInt("place_id"), resultSet.getString("place_name"), resultSet.getString("place_description"), resultSet.getInt("status"), resultSet.getInt("location_id")));
        }
        return places;
    }

    /**
     * @param placeInfo
     * @throws SQLException
     */
    public void insertPlace(PlaceInfo placeInfo) throws SQLException {
        try {
            String sqlStr = "INSERT INTO `place`(`place_id`,`place_name`, `place_description`, `status`, `location_id`) VALUES (?,?,?,?,?)";
            preStatement = connection.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
            preStatement.setInt(1, getAllPlace().size());
            preStatement.setString(2, placeInfo.getPlace_name());
            preStatement.setString(3, placeInfo.getPlace_description());
            preStatement.setInt(4, 1);
            preStatement.setInt(5, placeInfo.getLocation_id());
            //Update server
            preStatement.executeUpdate();
            System.out.println("Insert place successfull!");
        } catch (SQLException ex) {
            System.out.println("Insert place failure!");
        }
    }

    /**
     * Method update place into database
     *
     * @param place_id
     * @param placeInfo
     * @throws SQLException
     */
    public void updatePlace(int place_id, PlaceInfo placeInfo) throws SQLException {
        ArrayList<PlaceInfo> placeInfos = getPlace();
        try {
            String sqlStr = "UPDATE `place` SET `place_name`=?,`place_description`=?,`status`=?,`location_id`=? WHERE `place_id` = ?";
            preStatement = connection.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < placeInfos.size(); i++) {
                if (place_id == placeInfos.get(i).getPlace_id()) {
                    preStatement.setString(1, placeInfo.getPlace_name());
                    preStatement.setString(2, placeInfo.getPlace_description());
                    preStatement.setInt(3, 1);
                    preStatement.setInt(4, placeInfo.getLocation_id());
                    preStatement.setInt(5, place_id);
                }
            }
            //Update server
            preStatement.executeUpdate();
            System.out.println("Update place successfull!");
        } catch (SQLException ex) {
            System.out.println("Update place failure! " + ex);
        }
    }

    /**
     * Method delete place in database
     *
     * @param place_id
     * @param placeInfo
     * @throws SQLException
     */
    public void deletePlace(int place_id, PlaceInfo placeInfo) throws SQLException {
        ArrayList<PlaceInfo> placeInfos = getPlace();
        try {
            String sqlStr = "UPDATE `place` SET `status`=? WHERE `place_id`=?";
            preStatement = connection.prepareStatement(sqlStr, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < placeInfos.size(); i++) {
                if (place_id == placeInfos.get(i).getPlace_id()) {
                    preStatement.setInt(1, 0);
                    preStatement.setInt(2, place_id);
                }
            }
            //Update server
            preStatement.executeUpdate();
            System.out.println("Delete place successfull!");
        } catch (SQLException ex) {
            System.out.println("Delete place failure!");
        }
    }

    public ArrayList<PlaceInfo> getPaging(int page, String search, String sortColumn) {
        try {
            String sqlStr = "";
            sqlStr += " SELECT *";
            sqlStr += " FROM `place`";

            if (search != "") {
                sqlStr += " WHERE (`place_name` like '%" + search + "%')";
            }

            if (sortColumn != "") {
                //thuc hien sap xep
            }

            //phan trang
            int tongSoSanPham = getNumberOfProduct(page, search, sortColumn);
            int tongSoTrang = (int) Math.ceil(tongSoSanPham / SoDong_Trang);
            int index = (page - 1) * SoDong_Trang;

            sqlStr += " LIMIT " + index + ", " + SoDong_Trang;

            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(sqlStr);
            list = new ArrayList<PlaceInfo>();
            while (resultSet.next()) {
                list.add(new PlaceInfo(resultSet.getInt("place_id"), resultSet.getString("place_name"), resultSet.getString("place_description"), resultSet.getInt("status"), resultSet.getInt("location_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaceModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.list;
    }

    public int getNumberOfProduct(int page, String search, String sortColumn) throws SQLException {
        String sqlStr = "";
        sqlStr += " SELECT count(*) as soLuong ";
        sqlStr += " FROM `place`";

        if (search != "") {
            sqlStr += " WHERE (`place_name` like '%" + search + "%')";
        }

        this.statement = this.connection.createStatement();
        this.resultSet = this.statement.executeQuery(sqlStr);
        resultSet.next();
        return resultSet.getInt("soLuong");
    }

    public String getPagingString(int currentPage, String search, String sortColumn) {
        String strPaging = "<ul class='pagination'>";
        try {
            int tongSoSanPham = getNumberOfProduct(currentPage, search, sortColumn);
            int tongSoTrang = (int) Math.ceil(tongSoSanPham / SoDong_Trang);
            for (int stt_trang = 1; stt_trang <= tongSoTrang; stt_trang++) {
                if (search == "") {
                    if (stt_trang == currentPage) {
                        strPaging += "<li class='active'><a href='?placeNo=" + stt_trang + "'>" + stt_trang + "</a></li>";
                    } else {
                        strPaging += "<li><a href='?placeNo=" + stt_trang + "'>" + stt_trang + "</a></li>";
                    }
                } else {
                    if (stt_trang == currentPage) {
                        strPaging += "<li class='active'><a href='?placeNo=" + stt_trang + "&s=" + search + "'>" + stt_trang + "</a></li>";
                    } else {
                        strPaging += "<li><a href='?placeNo=" + stt_trang + "&s=" + search + "'>" + stt_trang + "</a></li>";
                    }
                }
            }

            strPaging += "</ul>";
        } catch (SQLException ex) {
            Logger.getLogger(PlaceModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return strPaging;
    }

    /**
     * Create printWord to split the paragraph to sort content 
     * @param words
     * @param number
     * @return 
     */
    public String printWord(String words, int number) {
        String AllWord = "";
        String[] getsaveWord = words.split("\\s+");
        int i = 0;
        do {
            AllWord += " " + getsaveWord[i];
            i++;
            if (AllWord.length() >= number) {
                AllWord += " ...";
            }
        } while (AllWord.length() < 100 && i < getsaveWord.length);

        return AllWord;
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
