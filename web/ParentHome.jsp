<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@include 
    file="Header.jsp"%>
<%
    String name=(String)session.getAttribute("name");
%>
<%
  Connection con;Statement ps;
  
    
            try {
            
             con=(Connection)this.getServletContext().getAttribute("mycon");
            Statement stmt=con.createStatement();
            
            int h=stmt.executeUpdate("update child set currentdate=(select curdate()) where 1=1");
            
           
        } catch (Exception ex) {
            
        }
    

  con=(Connection)this.getServletContext().getAttribute("mycon");
  ps=con.createStatement();
  ps.executeUpdate("update child set days=(select datediff(currentdate,Date_Of_Birth))");
  String uid=(String)session.getAttribute("uid");
%>
<html>
    <body>
        <h1>Hello <%=name%></h1>
        <a href="ProfileManagmentParent.jsp">Manage your Profile</a><br>
        <a href="AddChild.jsp">Add Child</a><br>
        <a href="Notification?uid=<%=uid%>">Notifications</a><br>
        <a href="Logout">LogOut</a>
    </body>
</html>
