/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DBLib.ConnectionLib;
import Info.EditorInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Admin
 */
public class EditorModel {

    private ArrayList<EditorInfo> ListEditor;
        ConnectionLib cl = new ConnectionLib();
    /**
     * get ArrayList
     *
     * @return
     */
    public ArrayList<EditorInfo> getListEditor() {
        return ListEditor;
    }

    /**
     * Stores database table Stores connection object Stores Statement object
     * Stores prepared statement object Stores result set object; Stores mysql
     * statement
     */
    private static final String tableName = "Editor";
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
    public EditorModel() throws SQLException {
        try {
            conn = cl.getConnection();
            st = conn.createStatement();
            pst = null;
            rs = null;
            sqlStr = "";
            ListEditor = new ArrayList<>();
            LoadEditor();
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * load data from database
     */
    public void LoadEditor() {
        try {
            sqlStr = "SELECT * FROM " + tableName;
            rs = st.executeQuery(sqlStr);
            if (rs.isBeforeFirst()) {
                ListEditor.clear();
                while (rs.next()) {
                    ListEditor.add(new EditorInfo(rs.getInt("Editor_id"), rs.getString("Editor_name"), rs.getInt("Status")));
                }
            }
        } catch (SQLException e) {
        }
    }

    /**
     * add to data to database
     *
     * @param Editor_id
     * @param Editor_time
     * @param Status
     * @return
     * @throws SQLException
     */
    public boolean addEditor(int Editor_id, String Editor_time, int Status) throws SQLException {
        try {
            sqlStr = "INSERT INTO `Editor`(`Editor_id`,`Editor_time`,`Status`) VALUES (?,?,?)";
            pst = conn.prepareStatement(sqlStr);
            pst.setInt(1, Editor_id);
            pst.setString(2, Editor_time);
            pst.setInt(3, Status);
            pst.executeUpdate();
            ListEditor.add(new EditorInfo(rs.getInt("Editor_id"), rs.getString("Editor_name"), rs.getInt("Status")));
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
     * @param Editor_id
     * @param Editor_time
     * @param Status
     * @return
     * @throws SQLException
     */
    public boolean updateEditor(int Editor_id, String Editor_time, int Status) throws SQLException {
        try {
            sqlStr = "UPDATE `Editor` SET 'Editor_id'=?, 'Editor_time'=?, 'Status'=? WHERE 'Editor_id'=?";
            pst = conn.prepareStatement(sqlStr);
            pst.setInt(1, Editor_id);
            pst.setString(2, Editor_time);
            pst.setInt(3, Status);
            pst.executeUpdate();
            LoadEditor();
            conn.close();
            return true;
        } catch (SQLException e) {
        }
        conn.close();
        return false;
    }

    /**
     * search by id Editor
     *
     * @param Editor_id
     */
    public EditorInfo Search(int Id) {
        for (int i = 0; i < ListEditor.size(); i++) {
            EditorInfo a = ListEditor.get(i);
            if (a.getEditor_id() == Id) {
                return ListEditor.get(i);
            }
        }
        return null;
    }

    /**
     * DeleteEditor
     *
     * @param E
     * @throws SQLException
     */
    public void DeleteEditor(EditorInfo E) throws SQLException {
        try {
            String sql = "UPDATE `Editor` SET `status`=0 WHERE `Editor_id` = ?";
            pst = conn.prepareStatement(sqlStr);
            pst.setInt(0, E.getEditor_id());
            pst.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
