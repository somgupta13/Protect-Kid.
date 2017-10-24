/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class ProfileDoctor extends HttpServlet {

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
            PrintWriter out = response.getWriter();
        try {
            
            Connection con=(Connection)request.getServletContext().getAttribute("mycon");
            PreparedStatement ps =con.prepareStatement("insert into doctor_info values(?,?,?,?,?)");
            String uid=(String)request.getSession().getAttribute("uid");
            ps.setString(1,uid);
            ps.setString(2,request.getParameter("spy"));
            ps.setString(3,request.getParameter("add"));
            ps.setString(4,request.getParameter("gen"));
            ps.setString(5,request.getParameter("qua"));
            int n=ps.executeUpdate();
            if(n>0)
            {
                out.println("<b>Profile management Successfull</b>");
                out.println("<a href=DoctorHome.jsp>Home</a>");
            }
               else{
                 out.println("<b>Profile management Not Successfull</b>");
                out.println("<a href=ProfileManagmentDoctor.jsp>Home</a>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfileDoctor.class.getName()).log(Level.SEVERE, null, ex);out.println(ex);
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
        processRequest(request, response);
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
