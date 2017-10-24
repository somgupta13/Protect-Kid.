
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import parent.ChildProfile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Web application lifecycle listener.
 *
 * @author HP
 */
public class NewServletListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        try {
            
            Connection con=(Connection)se.getSession().getServletContext().getAttribute("mycon");
            Statement ps=con.createStatement();
            int n=ps.executeUpdate("update child set currentdate(select curdate()) where 1=1");
            
           
        } catch (SQLException ex) {
            Logger.getLogger(ChildProfile.class.getName()).log(Level.SEVERE, null, ex);
        }//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
