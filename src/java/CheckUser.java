/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
/**
 *
 * @author HP
 */
public class CheckUser extends HttpServlet {

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
        try{
             
            Connection con=(Connection)this.getServletContext().getAttribute("mycon");
            PreparedStatement ps=con.prepareStatement("select * from user_info where uid=? and password=?");
            ps.setString(1, (String) request.getParameter("uid"));
            ps.setString(2, (String) request.getParameter("pass"));
            ResultSet rs=ps.executeQuery();
            boolean found=rs.next();
            
            String uid=(String)request.getParameter("uid");
            String pass=(String)request.getParameter("pass");
            if(found){
                request.getSession().setAttribute("uid", uid);
                String utype=rs.getString(5);
                String name=rs.getString(2);
                request.getSession().setAttribute("name", name);
                request.getSession().setAttribute("pass", pass);
                
                if(utype.equals("Parent")){
                    response.sendRedirect("ParentHome.jsp");}
            
                else
                    response.sendRedirect("DoctorHome.jsp");
                   
            }
            else {
                if(uid.equals("8085")&&pass.equals("8085")){
            response.sendRedirect("AdminHome.jsp"); }
            
            else 
            {out.println("<h1>invalid user</h1>");
            out.println("<a href=Login.jsp>Try again</a>");
            }}
        } catch (SQLException ex) {
            Logger.getLogger(CheckUser.class.getName()).log(Level.SEVERE, null, ex);out.println(ex);
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
