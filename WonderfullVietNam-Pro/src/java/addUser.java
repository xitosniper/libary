/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DBLib.ConnectionLib;
import Info.UserInfo;
import Model.UserModel;
import static Model.UserModel.SoDong_Trang;
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
 * @author DELL
 */
public class addUser extends HttpServlet {

    private final String UPLOAD_DIRECTORY = "C:\\Users\\ASUS\\Documents\\GitHub\\libary\\WonderfullVietNam-Pro\\web\\img";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addUser</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addUser at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
        String user_name = "";
        int user_gender = 0;
        String user_img = "";
        String user_phone = "";
        String user_address = "";
        String user_username = "";
        String user_password = "";
        String username = "";
        int status = 1;
        int role_id = 1;

        int pageNumber = 0;
        Connection connection = ConnectionLib.getConnection();

        //process only if its multipart content
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);

                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        user_img = new File(item.getName()).getName();
                        item.write(new File(UPLOAD_DIRECTORY + File.separator + user_img));
                    } else {
                        String fieldName = item.getFieldName();
                        String fieldValue = item.getString();

                        switch (fieldName) {
                            case "userName":
                                // beforeStep = 1;
                                user_name = fieldValue;
                                // afterStep = 1;
                                break;
                            case "gender":
                                //beforeStep = 4;
                                user_gender = Integer.parseInt(fieldValue);
                                // afterStep = 5;
                                break;
                            case "phone":
                                // beforeStep = 1;
                                user_phone = fieldValue;
                                // afterStep = 1;
                                break;
                            case "address":
                                // beforeStep = 1;
                                user_address = fieldValue;
                                // afterStep = 1;
                                break;
                            case "user_username":
                                // beforeStep = 4;
                                user_username = fieldValue;
                                // afterStep = 4;
                                break;
                            case "password":
                                // beforeStep = 4;
                                user_password = fieldValue;
                                // afterStep = 4;
                                break;
                            case "status":
                                //beforeStep = 4;
                                status = Integer.parseInt(fieldValue);
                                // afterStep = 5;
                                break;
                            case "role":
                                // beforeStep = 6;
                                role_id = Integer.parseInt(fieldValue);
                                // afterStep = 6;
                                break;
                            case "username":
                                // beforeStep = 4;
                                username = fieldValue;
                                // afterStep = 4;
                                break;
                        }
                    }
                }
                //insert new product
                UserModel um = new UserModel(connection);
                um.insertUser(new UserInfo(user_name, user_gender, user_img, user_phone, user_address, user_username, user_password, status, role_id));
                //NOTE: search and sort column always empty
                pageNumber = (int) Math.ceil(um.getNumberUser(0, "") / SoDong_Trang);

                //File uploaded successfully
                request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }

        } else {
            request.setAttribute("message",
                    "Sorry this Servlet only handles file upload request");
        }

        request.getRequestDispatcher("/user-new-save.jsp?username=" + username + "&trang=" + pageNumber).forward(request, response);
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
