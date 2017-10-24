<%@include 
    file="Header.jsp"%>

<%
    String name=(String)session.getAttribute("name");
    %>
<html>
    
    <body>
        <h1>Hello <%=name%></h1>
        <a href="ProfileManagmentDoctor.jsp">Manage your Profile</a><br>
        <a href="AvaliableVaccines.jsp">Avaliable Vaccines</a><br>
        <a href="DocNotification">Notification</a><br>
        <a href="Logout">LogOut</a>
        
    </body>
</html>
