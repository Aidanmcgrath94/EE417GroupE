<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form name="signUp" action="signupservlet" method="post">
  <label for="fname">First name (*):    </label>
  <input type="text" name="firstname" placeholder="Your first name.."><br> 
  
  <label for="lname">Last name (*):    </label>
  <input type="text" name="lastname" placeholder="Your last name.."><br> 
  
  <label>Username (*):    </label>
  <input type="text" name="username" placeholder="Username.."><br>
  
  <label>email (*):    </label>
  <input type="email" name="usermail" placeholder="email.."><br>
  
  <!-- use this to select your favourite...whatever .. and change the colour scheme 
   accordingly using javascript -->
  <label for="favourite">Favourite ...: </label>
	<select name="county" class="select">
	  <option value="" disabled selected>Select your favourite..</option>
      <option value="one">Option one</option>
      <option value="two">Option two</option>
      <option value="three">Option three</option>
	  <option value="four">Option four</option>
	  <option value="five">Option five</option>
    </select><br>
    
  <label for="pass">New Password (*): (8 chars min)</label>
	<input type="password" name="password"
           minlength="8" required placeholder="new password.."><br>

	<label for="pass">Confirm Password (*): </label>
	<input type="password" name="confirm_password"
           minlength="8" required placeholder="confirm password.."><br>

	<!-- enter a special admin password for admin rights?
	will hardcode as admin123 -->
	<label for="pass">Admin Password: </label>
	<input type="password" id="admin_pass" name="admin_password"
           placeholder="admin password.."><br>
            
  <button type="submit">Login</button>       
</form>
</body>
</html>