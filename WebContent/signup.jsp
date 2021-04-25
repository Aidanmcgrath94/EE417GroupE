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
<title>Sign Up</title>
<link rel="stylesheet" href="CSS/Signup.css">
</head>
<body>


<div class="split-screen">
    <div class="left">
        <section class="copy"> 
            <h1>Sign Up for NerdStack, Home of Nerds</h1>
            <p>Show us how much you love Anime</p>
        </section>
    </div>
    <div class="right">
        <form name="signUp" action="signupservlet" method="post">
            <section class="copy">
                <h2>Sign Up</h2>
                <div class="login-container">
                    <p>Already have an Account? <a href="login.jsp" ><Strong>Log In</Strong></a></p>
                </div>
            </section>
            <div class="input-container name">
                <label for="fname">First name (*): </label>
                <input type="text" name="firstname" placeholder="Your first name.."><br>
            </div>
            <div class="input-container name">
                    <label for="lname">Last name (*): </label>
                    <input type="text" name="lastname" placeholder="Your last name.."><br>
            </div>
            <div class="input-container name">
                <label>Username (*): </label>
                <input type="text" name="username" placeholder="Username.."><br>
            </div>
            <div class="input-container name">
                <label>email (*): </label>
                <input type="email" name="usermail" placeholder="email.."><br>
            </div>
            <div class="input-container name">
                <label for="pass">New Password (*): (8 chars min)</label>
                <input type="password" name="password" minlength="8" required placeholder="new password.."><br>
            </div>
            
            <%		
				boolean matched_failed = false;
				System.out.println(matched_failed);
				if(session.getAttribute("matched_failed") != null){
			  	  	matched_failed = (boolean)session.getAttribute("matched_failed");
				}
				System.out.println(matched_failed);
			    pageContext.setAttribute("matched_failed",matched_failed);
			%>
			<c:if test="${matched_failed == true}">  
   				<p>Passwords do not match<br>
   				Please try again!<br><br></p>
			</c:if>
			
            <div class="input-container name">
                <label for="pass">Confirm Password (*): </label>
                <input type="password" name="confirm_password" minlength="8" required placeholder="confirm password.."><br>

            </div>
		<!-- enter a special admin password for admin rights?
	will hardcode as admin123 -->
            <div class="input-container name">
                <label for="pass">Admin Password: </label>
                <input type="password" id="admin_pass" name="admin_password" placeholder="admin password.."><br>
            </div>
            <button class="signup-btn" type="submit">Sign up!</button>

        </form>
    </div>
</div>
</form>
</body>
</html>
