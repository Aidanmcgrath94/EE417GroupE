<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="CSS/login.css">
    
</head>
<body>

<%
    String path = request.getContextPath();
    String pathServlet = path + "/loginservlet";
%>


<!-- Style as you wish -->
<div class="container">
    <form action="<%=pathServlet%>" method="post" name="loginform">
        <h1>Login to NerdStack</h1>
        <div class="form-group">
        <label>Username : </label>
        <input type="text" placeholder="Enter Username" class="form-control" name="name" required>
        </div>
        <div class="form-group">
        <label>Password : </label>
        <input type="password" placeholder="Enter Password" class="form-control" name="password" required>
        </div>
        <button class="btn" type="submit">Login</button>
    </form><br><br>

    To sign up click here...<br>
    <a class="Signup" href="signup.jsp">Sign Up</a><br>
</div>

</body>
</html>
