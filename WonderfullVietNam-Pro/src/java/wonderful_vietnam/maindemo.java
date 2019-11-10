/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wonderful_vietnam;

import DBLib.ConnectionLib;
import Info.EditorInfo;
import Model.EditorModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author haumqce130436@fpt.edu.vn
 */
public class maindemo {

    public static void main(String[] args) throws SQLException {
        Connection con = ConnectionLib.getConnection();
        EditorModel em = new EditorModel(con);
        ArrayList<EditorInfo> list = em.getListEditor();
        for (EditorInfo editorInfo : list) {
            System.out.println(editorInfo.getEditor_time());
        }
        if (list.isEmpty()) {
            System.out.println("1");
        }
    }
}
