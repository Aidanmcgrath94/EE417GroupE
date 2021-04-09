<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- Style as you wish -->

<form action="loginservlet" method="post" name="loginform">   
  <label>Username : </label>   
  <input type="text" placeholder="Enter Username" name="name" required>  
  <label>Password : </label>   
  <input type="password" placeholder="Enter Password" name="password" required>  
  <button type="submit">Login</button>       
</form><br><br>

To sign up click here...<br>
<a href="signup.jsp">Sign Up</a><br>

</body>
</html>