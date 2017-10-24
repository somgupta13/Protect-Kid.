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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "AddDoctorVaccines", urlPatterns = {"/AddDoctorVaccines"})
public class AddDoctorVaccines extends HttpServlet {

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
        String name=(String)request.getSession().getAttribute("name");
            String price[]=request.getParameterValues("price");
        String vid[]=request.getParameterValues("vid");
        String uid=(String)request.getSession().getAttribute("uid");
        int i=0,m=0;
        try {
            
            Connection con= (Connection)request.getServletContext().getAttribute("mycon");
            PreparedStatement ps=con.prepareStatement("insert into add_doctor_vaccines values(?,?,?,?)");
            for(i=0;i<vid.length;i++)
            {
                
                while(price[m].isEmpty())
                {
                    m++;
                }
                ps.setString(1, uid);
                ps.setString(2, vid[i]);
                ps.setString(3, price[m]);
                ps.setString(4, name);
                ps.executeUpdate();m++;
            }
            out.println("<b>Vaccines Registered</b><br>");
                out.println("<a href=DoctorHome.jsp>Home</a>");
            
        } catch (SQLException ex) {
            Logger.getLogger(AddDoctorVaccines.class.getName()).log(Level.SEVERE, null, ex);out.println(ex);
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
