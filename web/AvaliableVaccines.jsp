<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@include 
    file="Header.jsp"%>
<%
    Connection con=(Connection)application.getAttribute("mycon");
    Statement ps=con.createStatement();
   ResultSet rs= ps.executeQuery("select * from vaccination ");
    %>
    <html>
        <head>
            
        </head>
        <body>
        <form action="AddDoctorVaccines">
                <table border="2" width="4" cellspacing="2" cellpadding="3">
                    <thead>
                        <tr>
                            <th>Vaccines</th>
                            <th>Select</th>
                            <th>price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        while(rs.next()){
                            String x=rs.getString(2);
                            String y=rs.getString(1);
                        %>
                        <tr>
                            <td><b><%=x%></b></td>
                            <td><input type="checkbox" name="vid" value="<%=y%>"  /></td>
                            <%
                               {
                            %>
                             <td><input type="text" name="price" ></td>
                            <%}%>
                        </tr>
                        <%    
                        }
                        %>
                    </tbody>
                </table>
                <pre>                      
                        <input type="Submit" value="Submit">
                </pre>                     
            </form>
        </body>
    </html>