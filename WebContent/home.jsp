<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.DateFormat" %>
<%@ page import = "java.text.SimpleDateFormat" %>
    
<%@ page import="entity.User" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>NS - Home</title>
    <link rel="stylesheet" href="CSS/home.css">
    <link rel="stylesheet" href="CSS/navigation.css">
    <link rel="stylesheet" href="CSS/popup.css">
    <script src="https://kit.fontawesome.com/0006047be0.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Titillium+Web:ital@1&display=swap" rel="stylesheet">


</head>

<body>
	<sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306"
         user = "root"  password = "test"/>
         
	<!-- User object, do with it as you wish
	I have just printed values for now
	You could inlude extra priveleges for admin
	You could create different colour schem based on fvourite... -->
    <div>
      <% 
 
      User newUser;
	int user_id = -1;
	String firstname ="";
	String lastname = "";
	String username = "";
	String email="";
	String strDate="";
	Date dateCreated = new Date();
	boolean isAdmin = false;
   
      if((User)session.getAttribute("theUser") != null){
    	  // Get firstname attribute
    	  newUser = (User)session.getAttribute("theUser");
    	  user_id = newUser.get_id();
    	  firstname = newUser.getFirstName();
    	  lastname = newUser.getLastName();
    	  username = newUser.getUsername();
    	  email = newUser.getEmail();   	  
    	  dateCreated = newUser.getCreatedDate();
    	  isAdmin = newUser.isAdmin();
      }
      
	  	String area = "";
	  	String area1 = "";
	  	String area2 = "";
      String searchString = "";
      String sortBy = "";
      String orderBy = "likes DESC";
      int lim = 1000;
      
      if(request.getParameter("sort_by") != null){
      	sortBy = request.getParameter("sort_by");
      	if(sortBy.equals("Likes_high")){
      		orderBy = "likes DESC";
      	}
      	else if(sortBy.equals("Likes_low")){
      		orderBy = "likes ASC";
      	}
      	else if(sortBy.equals("Old")){
      		orderBy = "createdDate ASC";
      	}
      	else if(sortBy.equals("New")){
      		orderBy = "createdDate DESC";
      	}
      	else if(sortBy.equals("Author")){
      		orderBy = "author DESC";
      	}
      	
      }
      
      if(request.getParameter("numberOfPosts") != null){
    	  String numberOfPosts = request.getParameter("numberOfPosts");
        	if(numberOfPosts.equals("five")){
        		lim = 5;
        	}
        	else if(numberOfPosts.equals("ten")){
        		lim = 10;
        	}
        	else if(numberOfPosts.equals("twenty")){
        		lim = 20;
        	}
        	else if(sortBy.equals("all")){
        		lim = 1000;
        	}

      }
      
      if(request.getParameter("search") != null){
    	if(!request.getParameter("search").equals("")){
      	area = request.getParameter("area");
      	if(area.equals("Subject")){
      		area1 = "subject";
      		area2 = "subject";
      	}
      	else if(area.equals("Body")){
      		area1 = "body";
      		area2 = "body";
      	}
      	else{
      		area1 = "subject";
      		area2 = "body";
      	}
      	searchString = request.getParameter("search");
    	}
      }
      boolean toSearch = false;
      if(!searchString.equals("")){
      	toSearch = true;
      }
      pageContext.setAttribute("isAdmin",isAdmin);
      pageContext.setAttribute("orderBy",orderBy);
      pageContext.setAttribute("toSearch",toSearch);
      
      %>    
      
    <header>
	<!--
    <div class="slideNav">

        <div class="menuFold">
            <div class="menuBtn"><i class="fa fa-bars"></i></div>
        </div>

        <div class="menuUnfold">

            <div class="menuQuote">
                <h2 id="quoteSentence">"Weakness Disgusts Me"</h2>
                <h3 id="quoteCharacter">- Madara, Naruto</h3>
            </div>

            <ul class="menuNav">
                <li><a href="home.jsp" class="orange"><i class="fa fa-home fa-fw"></i>&nbsp; Home</a></li>
                <li><a href="posts.jsp" class="yellow"><i class="fa fa-newspaper-o fa-fw"></i>&nbsp; Posts</a></li>
                <li><a href="posts.jsp" class="green"><i class="fa fa-comments-o fa-fw"></i>&nbsp; Forum</a></li>
                <li><a href="details.jsp" class="purple"><i class="fa fa-envelope fa-fw"></i>&nbsp; Contact</a></li>
                <li><a href="details.jsp" class="red"><i class="fa fa-users fa-fw"></i>&nbsp; About</a></li>
            </ul>

            <a href="#" class="closeBtn"><i class="fa fa-close"></i>&nbsp; Close menu</a>
-->
            <!--<div style="height: 250px"></div>-->
   <!--  
            <a href="#"><i id="switchButton" class="fa fa-gg-circle"></i></a>

            <a href="#"><i id="accountButton" class="fa fa-user-circle"></i></a>

        </div>

    </div>-->


    <h3 id="mainTitle">NerdStack</h3>

	Welcome, <c:out value="<%=firstname %>"></c:out>, here are you details:<br>
	<table style="margin:20px;">
	<tr style="margin:20px;">
	<td style="padding:20px;">First name:</td><td style="padding:20px;"><c:out value="<%=firstname %>"></c:out></td>
	</tr>
	<tr style="margin:20px;">
	<td style="padding:20px;">Last name:</td><td style="padding:20px;"><c:out value="<%=lastname %>"></c:out></td>
	</tr>
	<tr style="margin:20px;">
	<td style="padding:20px;">Username:</td><td style="padding:20px;"><c:out value="<%=username %>"></c:out></td>
	</tr>
	<tr style="margin:20px;">
	<td style="padding:20px;">email:</td><td style="padding:20px;"><c:out value="<%=email %>"></c:out></td>
	</tr>
	<tr style="margin:20px;">
	<td style="padding:20px;">Date Joined:</td><td style="padding:20px;"><c:out value="<%=dateCreated %>"></c:out></td>
	</tr>
	
	<tr style="margin:20px;">
	<td style="padding:20px;">Is Admin:</td><td style="padding:20px;"><c:out value="<%=isAdmin %>"></c:out></td>
	</tr>
	</table>
	
	 <!-- Logout button.. style as you wish -->
    <div>
    <form action = "logoutservlet" method="post">
  		<button type="submit">Click here to logout</button>
	</form>
    </div><br><br><br>
    
    <div>
	Enter your post here..
   <form action="processpostservlet" method="post" name="processpost">      
     <input type="text" placeholder="Enter subject.." name="subject" required style="width:500px;"> <br> 
     <input type="text" placeholder="Enter body.." name="body" required style="width:500px; height:100px;">  <br>
     <button type="submit">Post!</button>       
   </form>
	</div>
	
    <!--SearchBox Section-->
    <div class="search-box">
        <div>
          
  	 		<form action="home.jsp">
  	 		<select name="area">
                <option value="Everything">Everything</option>
                <option value="Subject">Subject</option>
                <option value="Body">Body</option>
            </select>
            <input type="text" placeholder="search ..." name="search" required>
            <button type="submit"><i class="fa fa-search"></i></button>
            </form><br>
            <form action="home.jsp">
            	<button name="search" value="" type="submit">Clear Search</button>
            </form>
        </div>
    </div>
    </header>
	
    <div class="container">
        <!--Navigation-->
        <div class="navigate">
            <span><a href="">NerdStack</a> >> <a href="">random subforum</a> >> <a href="">random topic</a></span>
        </div>
        
     

        <!--Topic Section-->
        <form action="home.jsp">
  	 		<label>Sort by :</label>
     		<select name="sort_by">
                <option value="Likes_high">Likes High-Low</option>
                <option value="Likes_low">Likes Low-High</option>
                <option value="Old">Oldest-Newest</option>
                <option value="New">Newest-Oldest</option>
                <option value="Authors">Authors</option>
            </select><br>
            <label>Number of posts :</label>
            <select name="numberOfPosts">
                <option value="five">5</option>
                <option value="ten">10</option>
                <option value="twenty">20</option>
                <option value="all">All</option>
            </select>
            <button type="submit"><i class="fa fa-search"></i></button>
            </form>
        
        <c:if test = "${isAdmin}">
         <br><br> You have special admin priveleges <br>
         Click here to clear all posts :<br>
         <form action = "clearpostsservlet" method="post">
  		<button type="submit">Clear all posts</button><br>
		</form>
      	</c:if>
        
        <c:choose>
  		<c:when test="${toSearch}">
  		<sql:query dataSource = "${snapshot}" var = "result">
	SELECT * FROM mydata.post WHERE <%=area1%> LIKE '%<%=searchString%>%' OR <%=area2 %> LIKE '%<%=searchString%>%' ORDER BY <%=orderBy%>   </sql:query>
	
			<c:choose>
	        <c:when test="${result.rowCount == 0}">
	            No results found, try again! 
	        </c:when>
	        <c:otherwise>
	        	<!--Original thread-->
	        Searched For : "<c:out value="<%=searchString%>"></c:out>"	<br>
	        Searched in <c:out value="<%=area %>"></c:out><br>	
	        Results Found: <c:out value = "${result.rowCount}"/>
            <c:forEach var = "row" items = "${result.rows}">
            <form action = "like_comment_servlet" method="post">
    		<input type='hidden' name='post_id' value="${row._id}">    
    		<input type='hidden' name='user_id' value= "<%=user_id%>">
            <div class="head">
            
                <div class="authors">Author: <c:out value = "${row.author}"/></div>
                <c:set var = "string" value = "${row.subject}"/>
                <c:set var = "searchString" value = "<%=searchString%>"/>
                <c:set var = "searchString2" value ="(<u>${searchString })</u>" />
                <div class="content">Topic: <c:out value = "${fn:replace(row.subject,searchString, searchString2)}" escapeXml="false"/></div>
            
            </div>
            <div class="body">
                <div class="authors">
                    <div class="username"><a href="">Username</a> <c:out value = "${row.author}"/></div>
                    
                    <img src="https://cdn.pixabay.com/photo/2015/11/06/13/27/ninja-1027877_960_720.jpg" alt="">
                    <div>Posts: <u>
                    <sql:query dataSource = "${snapshot}" var = "result3">
					SELECT COUNT(author) AS author FROM mydata.post WHERE author = "${row.author}"</sql:query>
					<c:forEach var = "row3" items = "${result3.rows}">
                    	<c:out value = "${row3.author}"/>
                    </c:forEach>
                    </u></div>
                    
                </div>
                <div class="content">
                	<c:set var = "string" value = "${row.body}"/>
                <c:set var = "searchString" value = "<%=searchString%>"/>
                <c:set var = "orderBy" value = "<%=orderBy%>"/>

                <c:set var = "searchString2" value ="(<u>${searchString })</u>" />
                <div class="content">Topic: <c:out value = "${fn:replace(row.body,searchString, searchString2)}" escapeXml="false"/></div>
                    <c:out value = "${row.body}"/>
                    <br>
                    Posted on: <c:out value = "${row.createdDate}"/>
                    <br>
                    Likes: <c:out value = "${row.likes}"/>
                    <sql:query dataSource = "${snapshot}" var = "result2">
					SELECT * FROM mydata.comments where post_id = ${row._id}</sql:query>
					
                    <div class="comment">
                    	<input type="submit" name="action" value="like">
                    	<input type="text" name="user_comment" placeholder="comment..">
                    	<input type="submit" name="action" value="comment">
                        <button onclick="showComment()">Comment</button>
                        <br><br>Comments.. <br>
                        
                        <table >    				
                        <c:forEach var = "row2" items = "${result2.rows}">
           				<tr style="padding: 20px;" >
           				
          				<td style="padding: 10px;"><c:out value = "${row2.author}"/></td>
          				<td style="padding: 10px;"><c:out value = "${row2.createdDate}"/></td>
          				<td style="padding: 10px;"><c:out value = "${row2.comment}"/></td>
          				</tr>
                        </c:forEach>
                        </table>
                    </div>
                    
                </div>
            </div>
            </form>
        	</c:forEach>
	        
	        </c:otherwise>
        	</c:choose>
  		</c:when>
  		<c:otherwise>
        <sql:query dataSource = "${snapshot}" var = "result">
		SELECT * FROM mydata.post ORDER BY <%=orderBy%> LIMIT <%=lim%></sql:query>
		
            <!--Original thread-->
            <c:forEach var = "row" items = "${result.rows}">
            <form action = "like_comment_servlet" method="post">
    		<input type='hidden' name='post_id' value="${row._id}">    
    		<input type='hidden' name='user_id' value= "<%=user_id%>">
            <div class="head">
            
                <div class="authors">Author: <c:out value = "${row.author}"/></div>
                <div class="content">Topic: <c:out value = "${row.subject}"/></div>
            
            </div>
            <div class="body">
                <div class="authors">
                    <div class="username"><a href="">Username</a> <c:out value = "${row.author}"/></div>
                    
                    <img src="https://cdn.pixabay.com/photo/2015/11/06/13/27/ninja-1027877_960_720.jpg" alt="">
                    <div>Posts: <u>
                    <sql:query dataSource = "${snapshot}" var = "result3">
					SELECT COUNT(author) AS author FROM mydata.post WHERE author = "${row.author}"</sql:query>
					<c:forEach var = "row3" items = "${result3.rows}">
                    	<c:out value = "${row3.author}"/>
                    </c:forEach>
                    </u></div>
                    
                </div>
                <div class="content">
                    <c:out value = "${row.body}"/>
                    <br>
                    Posted on: <c:out value = "${row.createdDate}"/>
                    <br>
                    Likes: <c:out value = "${row.likes}"/>
                    <sql:query dataSource = "${snapshot}" var = "result2">
					SELECT * FROM mydata.comments where post_id = ${row._id}</sql:query>
					
                    <div class="comment">
                    	<input type="submit" name="action" value="like">
                    	<input type="text" name="user_comment" placeholder="comment..">
                    	<input type="submit" name="action" value="comment">
                        <button onclick="showComment()">Comment</button>
                        <br><br>Comments.. <br>
                        
                        <table >    				
                        <c:forEach var = "row2" items = "${result2.rows}">
           				<tr style="padding: 20px;" >
           				
          				<td style="padding: 10px;"><c:out value = "${row2.author}"/></td>
          				<td style="padding: 10px;"><c:out value = "${row2.createdDate}"/></td>
          				<td style="padding: 10px;"><c:out value = "${row2.comment}"/></td>
          				</tr>
                        </c:forEach>
                        </table>
                    </div>
                    
                </div>
            </div>
            </form>
        	</c:forEach>  
        	</c:otherwise>
        	</c:choose>        
        </div>
        

        <!--Comment Area-->
        
        <div class="comment-area hide" id="comment-area">
            <textarea name="comment" placeholder="comment here ... "></textarea>
            <input type="submit" value="submit">
        </div>

        <!--Comments Section
        <div class="comments-container">
            <div class="body">
                <div class="authors">
                    <div class="username"><a href="">AnotherUser</a></div>
                    
                    <img src="https://cdn.pixabay.com/photo/2015/11/06/13/27/ninja-1027877_960_720.jpg" alt="">
                    <div>Posts: <u>
                    100
                    </u></div>
                    <div>Points: <u>4586</u></div>
                </div>
                <div class="content">
                    Just a comment of the above random topic.
                    <br>To see how it looks like.
                    <br><br>
                    Nothing more and nothing less.
                    <br>
                    <br>
                    <div class="comment">
                        <button onclick="showReply()">Reply</button>
                    </div>
                </div>
            </div>
        </div> -->
        
        <!--Reply Area
        <div class="comment-area hide">
            <textarea name="reply" placeholder="reply here ... "></textarea>
            <input type="submit" value="submit">
        </div>
		-->

        <!--Another Comment With replies
        <div class="comments-container">
            <div class="body">
                <div class="authors">
                    <div class="username"><a href="">AnotherUser</a></div>
                    <div>Role</div>
                    <img src="https://cdn.pixabay.com/photo/2015/11/06/13/27/ninja-1027877_960_720.jpg" alt="">
                    <div>Posts: <u>455</u></div>
                    <div>Points: <u>4586</u></div>
                </div>
                <div class="content">
                    Just a comment of the above random topic.
                    <br>To see how it looks like.
                    <br><br>
                    Nothing more and nothing less.
                    <br>
                    <br>
                    <div class="comment">
                        <button onclick="showReply()">Reply</button>
                    </div>
                </div>
            </div>
        </div>
        -->
        <!--Reply Area
        <div class="comment-area hide">
            <textarea name="reply" id="" placeholder="reply here ... "></textarea>
            <input type="submit" value="submit">
        </div>
        -->

    <!-- Pop Up Box -->
    <div id="popupBox" class="popup">
        <div class="popup-content">
            <div class="popup-header">
                <span class="close" onclick="closePopUp()">&times;</span>
                <h2>&#11088; Success &#11088;</h2>
            </div>
            <div class="popup-body">
                <br>
                <p>You are now registered <strong>Nerdstack</strong> !</p>
                <br>
            </div>
        </div>
    </div>


        <footer>
            <span>&copy; NerdStack Group</span>
        </footer>

    <script src="js/jquery-3.5.1.js"></script>
    <script src="js/navigation.js"></script>
    <script src="js/popup.js"></script>
    <script src="js/common.js"></script>
</body>