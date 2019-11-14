/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DBLib.ConnectionLib;
import Model.PostModel;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author haumqce130436@fpt.edu.vn
 */
public class addPost extends HttpServlet {

    private final String UPLOAD_DIRECTORY = "C:\\Users\\ASUS\\Documents\\GitHub\\libary\\WonderfullVietNam-Pro\\web\\img";

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int place_id = -1;
        int user_id = -1;
        int editor_id = -1;
        String post_text = "";
        String post_img = "";
        String username = "";

        String post_time = "";
        Connection connection = ConnectionLib.getConnection();
        PostModel um = new PostModel(connection);

        //process only if its multipart content
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);

                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        if (item.getString().equals("")) {
                            post_img = null;
                        } else {
                            String name = new File(item.getName()).getName();
                            post_img = name;
                            item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
                        }
                    } else {
                        String fieldName = item.getFieldName();
                        String fieldValue = item.getString();
                        switch (fieldName) {
                            case "txtPlace_id":
                                place_id = Integer.parseInt(fieldValue);
                                break;
                            case "txtUser_id":
                                user_id = Integer.parseInt(fieldValue);
                                break;
                            case "txtEditor_id":
                                editor_id = Integer.parseInt(fieldValue);
                                break;
                            case "txtPost_text":
                                post_text = fieldValue;
                                break;
                            case "txtUsername":
                                username = fieldValue;
                                break;
                        }
                    }
                }
                //Insert new producst
                um.insertPost(place_id, post_text, 1, user_id, editor_id);
                //File uploaded successfully
                request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }

        } else {
            request.setAttribute("message",
                    "Sorry this Servlet only handles file upload request");
        }

        request.getRequestDispatcher("/form-new-save.jsp?username=" + username).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
