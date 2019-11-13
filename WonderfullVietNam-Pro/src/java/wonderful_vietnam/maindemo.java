/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wonderful_vietnam;

import DBLib.ConnectionLib;
import Info.EditorInfo;
import Info.PostInfo;
import Model.EditorModel;
import Model.PostModel;
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
        PostModel pm = new PostModel(con);
        pm.insertPost(0, "test", "2019-11-10 10:00:00", 1, 2, 1);
        ArrayList<PostInfo> list = pm.getPost();
        for (PostInfo postInfo : list) {
            System.out.println(postInfo.getPost_text());
        }
    }
}
