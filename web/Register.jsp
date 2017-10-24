<%@include 
    file="Header.jsp"%>
<html>
    <title>Register here</title>
    <body>
        <form action="Register">
            <pre>
    UserId:         <input type="text" name="uid">
    Name:           <input type="text" name="name">
    Mobile No.:     <input type="text" name="mno">
    Password:       <input type="password" name="pass">
    User Type:      <select name="utype">
                             <option>Doctor</option>
                             <option>Parent</option>
                    </select>
                    <input type="Submit">
            </pre>
        </form>
    </body>
</html>