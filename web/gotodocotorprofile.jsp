<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@include 
    file="Header.jsp"%>
<%
    String uid=request.getParameter("uid");
    String vid=request.getParameter("vid");
    %>
<html>
    <body>
        <center>
            <h1><b>Doctor Profile</b></h1>
           
        </center>
        <%
            Connection con=(Connection)this.getServletContext().getAttribute("mycon");
            PreparedStatement ps=con.prepareStatement("select Specialist,Address,gender,qualification,name,Mobile_No from user_info join doctor_info on user_info.uid=doctor_info.uid where user_info.uid=?");
            ps.setString(1,request.getParameter("uid"));
            ResultSet rs=ps.executeQuery();
           String spec="",add="",gen="",qua="",name="",mob="";
            if(rs.next())
            {
                 spec=rs.getString(1);
                 add=rs.getString(2);
                 gen=rs.getString(3);
                 qua=rs.getString(4);
                 name=rs.getString(5);
                 mob=rs.getString(6);
            }
            
                    %>
                    <form action="NotifyDoctor">
                    <pre>
                    
                         Name           =<%=name%>
                         Mobile No.     =<%=mob%>
                         Specialist     =<%=spec%>
                         Address        =<%=add%>
                         Gender         =<%=gen%>
                         Qualification  =<%=qua%>
                            <input type="submit" value="Get Appointment" />
                    </pre>
                         <%
                             PreparedStatement s=con.prepareStatement("select Vaccine_name from vaccination where vid=?");
                             s.setString(1,vid);
                             ResultSet r=s.executeQuery();
                             String vname="";
                             if(r.next()) vname=r.getString(1);
                             if(1==1)
                             {
                             %>
                             <input type="hidden" name="uid" value=<%=uid%>>
                             <input type="hidden" name="vid" value=<%=vname%>>
                             <%}
                                 %>
                             
        </form>
</body>
</html>
