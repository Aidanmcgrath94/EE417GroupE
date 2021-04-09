<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="user.User" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>NS - Home</title>
    <link rel="stylesheet" href="CSS/home.css">
    <link rel="stylesheet" href="CSS/navigation.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Titillium+Web:ital@1&display=swap" rel="stylesheet">


</head>

<body>

	<!-- User object, do with it as you wish
	I have just printed values for now
	You could inlude extra priveleges for admin
	You could create different colour schem based on fvourite... -->
    <div>
      <% 
      User newUser;
      if((User)session.getAttribute("theUser") != null){
    	  // Get firstname attribute
    	  newUser = (User)session.getAttribute("theUser");
    	  out.print("<h1>Welcome, " + newUser.getFname() + ": here are your details</h1><br>");
    	  out.print("First name: " +  newUser.getFname() + "<br>");
    	  out.print("Last name: " +  newUser.getLname() + "<br>");
    	  out.print("Username: " +  newUser.getUsername() + "<br>");
    	  out.print("email: " +  newUser.getEmail() + "<br>");
    	  out.print("Favourite: " +  newUser.getFavourite() + "<br><br>");
    	  if(newUser.isAdmin() == true){
    		  out.print("You are an admin.. here are your access priveleges<br>");
    	  }
    	  else{
    		  out.print("You are just a regular user.. too bad!");
    	  }
      }     
      %>
      <a href="posts.jsp">Go to posts</a><br>
    </div>	
    
    
    <!-- Logout button.. style as you wish -->
    <div>
    <form action = "logoutservlet" method="post">
  		<button type="submit">Click here to logout</button>
	</form>
    </div>
    
    
    <header>

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
                <li><a href="home.html" class="orange"><i class="fa fa-home fa-fw"></i>&nbsp; Home</a></li>
                <li><a href="posts.html" class="yellow"><i class="fa fa-newspaper-o fa-fw"></i>&nbsp; Posts</a></li>
                <li><a href="posts.html" class="green"><i class="fa fa-comments-o fa-fw"></i>&nbsp; Forum</a></li>
                <li><a href="details.html" class="purple"><i class="fa fa-envelope fa-fw"></i>&nbsp; Contact</a></li>
                <li><a href="details.html" class="red"><i class="fa fa-users fa-fw"></i>&nbsp; About</a></li>
            </ul>

            <a href="#" class="closeBtn"><i class="fa fa-close"></i>&nbsp; Close menu</a>

<!--            <div style="height: 250px"></div>-->
            <a href="#"><i id="switchButton" class="fa fa-gg-circle"></i></a>

        </div>

    </div>


    <h3 id="mainTitle">NerdStack</h3>

    <!--SearchBox Section-->
    <div class="search-box">
        <div>
            <select>
                <option value="Everything">Everything</option>
                <option value="Titles">Titles</option>
                <option value="Descriptions">Descriptions</option>
            </select>
            <input type="text" name="q" placeholder="search ...">
            <button><i class="fa fa-search"></i></button>
        </div>
    </div>
    </header>


    <div class="container">
        <!--Navigation-->
        <div class="navigate">
            <span><a href="">NerdStack</a> >> <a href="">random subforum</a> >> <a href="">random topic</a></span>
        </div>

        <!--Topic Section-->
        <div class="topic-container">
            <!--Original thread-->
            <div class="head">
                <div class="authors">Author</div>
                <div class="content">Topic: random topic (Read 1325 Times)</div>
            </div>

            <div class="body">
                <div class="authors">
                    <div class="username"><a href="">Username</a></div>
                    <div>Role</div>
                    <img src="https://cdn.pixabay.com/photo/2015/11/06/13/27/ninja-1027877_960_720.jpg" alt="">
                    <div>Posts: <u>45</u></div>
                    <div>Points: <u>4586</u></div>
                </div>
                <div class="content">
                    Just a random content of a random topic.
                    <br>To see how it looks like.
                    <br><br>
                    Nothing more and nothing less.
                    <br>
                    <hr>
                    Regards username
                    <br>
                    <div class="comment">
                        <button onclick="showComment()">Comment</button>
                    </div>
                </div>
            </div>
        </div>

        <!--Comment Area-->
        <div class="comment-area hide" id="comment-area">
            <textarea name="comment" placeholder="comment here ... "></textarea>
            <input type="submit" value="submit">
        </div>

        <!--Comments Section-->
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
        <!--Reply Area-->
        <div class="comment-area hide">
            <textarea name="reply" placeholder="reply here ... "></textarea>
            <input type="submit" value="submit">
        </div>


        <!--Another Comment With replies-->
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
        <!--Reply Area-->
        <div class="comment-area hide">
            <textarea name="reply" id="" placeholder="reply here ... "></textarea>
            <input type="submit" value="submit">
        </div>

    </div>
        <footer>
            <span>&copy; NerdStack Group</span>
        </footer>

    <script src="js/jquery-3.5.1.js"></script>
    <script src="js/navigation.js"></script>
</body>