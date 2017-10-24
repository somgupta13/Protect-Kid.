<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@include 
    file="Header.jsp"%>


<html>
    <title>
        Protect Kids
    </title>
    <body>
        <form action="CheckUser">
        <pre>
  <b>Username</b>:<input type="text" name="uid"/>
  <b>Password</b>:<input type="password" name="pass"/>
                  <input type="Submit" value="Login"/>
            



 <a href="Register.jsp">Register here!</a>
        </pre>
        </form>
    </body>
</html>
