/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBLib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author haumqce130436@fpt.edu.vn
 */
public class ConnectionLib {
    static Statement statement;
    static PreparedStatement preparedStatement;
    Connection connection;
    ResultSet resultSet;
    /**
     * Method connection
     * @return 
     */
    public Connection getConnection(){
        try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wonderful_vietnam","root","");
                return connection;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Connection false!","Error", JOptionPane.ERROR_MESSAGE);
//                Logger.getLogger(DEMO.class.getName()).log(Level.SEVERE, null, e);
                return null;
            } 
    }
}
