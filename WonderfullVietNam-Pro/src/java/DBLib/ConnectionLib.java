/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBLib;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author haumqce130436@fpt.edu.vn
 */
public class ConnectionLib {
    static com.mysql.jdbc.Connection con = null;
    public static com.mysql.jdbc.Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/wonderful_vietnam";
            String username = "root";
            String password = "";

            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionLib.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return con;
        }
    }
}
