<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

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
     
			
	boolean login_failed = false;

	if(session.getAttribute("login_failed") != null){
  	  	login_failed = (boolean)session.getAttribute("login_failed");
	}
    pageContext.setAttribute("login_failed",login_failed);
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

	<c:if test="${login_failed == true}">  
   		<p>Username or password incorrect<br>
   		Please try again!<br><br>
	</c:if>  
    To sign up click here...<br>
    <a class="Signup" href="signup.jsp">Sign Up</a><br>
</div>

</body>
</html>
