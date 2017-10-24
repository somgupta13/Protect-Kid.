<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@include 
    file="Header.jsp"%>
<html>
    <body>
        <%
            PreparedStatement ps1;ResultSet rs1;String name1="";
            String vid=request.getParameter("vid");
            String name="";
            Connection con=(Connection)this.getServletContext().getAttribute("mycon");
            PreparedStatement ps= con.prepareStatement("select uid,price,name from add_doctor_vaccines where vid=?");
            ps.setString(1,request.getParameter("vid"));
            ResultSet rs=ps.executeQuery();
            %>
            <table border="4" width="4" cellspacing="4" cellpadding="5">
                    <thead>
                        <tr>
                            <th>Doctor name</th>
                            <th>Vaccine name</th>
                            <th>Price</th>
                            <th>Doctor Profile</th>
                        </tr>
                    </thead>
                    <tbody>
            <%
            while(rs.next())
            {
                String uid=rs.getString(1);
                String price=rs.getString(2);
                name=rs.getString(3);
                ps1=con.prepareStatement("select Vaccine_name from vaccination  where vid=?");
                ps1.setString(1,vid);
                rs1=ps1.executeQuery();
                if(rs1.next())
                name1=rs1.getString(1);
                %>
                
                    
                        <tr>
                            <td><%=name%></td>
                            <td><%=name1%></td>
                            <td><%=price%></td>
                            <td><a href="gotodocotorprofile.jsp?uid=<%=uid%>&vid=<%=vid%>">Click here</a></td>
                        </tr>
                  

                <%
                    
                }
            
            %>
                   </tbody>
            </table>            
    </body>
</html>