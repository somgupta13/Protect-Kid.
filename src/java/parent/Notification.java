
package parent;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Notification extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String uid=request.getParameter("uid");
        Connection con=(Connection)request.getServletContext().getAttribute("mycon");
        
        try {
 ResultSet rs1=    con.createStatement().executeQuery("select Child_Nmae,Vaccine_name,days,Start_Month,End_Month,uid,vid  from child join vaccination on child.days between Start_Month and End_Month");
 out.println("<body>");
 out.println("<form action=GetAppointment>");
 out.println(" <table border=1 width=5 cellspacing=5 cellpadding=4>");
    out.println("<thead>");
        out.println("<tr>");
            out.println("<th>Child Name</th>");
            out.println("<th>Vaccine Name</th>");
            out.println("<th>No.of days left</th>");
            out.println("<th>Get appointment</th>");
       out.println(" </tr>");
    out.println("</thead>");
            while(rs1.next())
            {
           if(rs1.getString(6).equals(uid))
           {
    out.println(" <tbody>");
         out.println("<tr>");
             out.println("<td>"+rs1.getString(1)+"</td>");
             out.println("<td>"+rs1.getString(2)+"</td>");
             out.println("<td>"+(rs1.getInt(5)-rs1.getInt(3))+"</td>");
             out.println("<td><a href=GetAppoint.jsp?vid="+rs1.getString(7)+">Click here!</td>");
         out.println("</tr>");
     out.println("</tbody>");
           }
            
            }
            out.println("</table>");
            out.println("</form>");
            out.println("</body>");
        } catch (SQLException ex) {
            Logger.getLogger(Notification.class.getName()).log(Level.SEVERE, null, ex);out.println(ex);
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
