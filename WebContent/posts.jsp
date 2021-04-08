<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>NS - Posts</title>
    <link rel="stylesheet" href="CSS/posts.css">
    <link rel="stylesheet" href="CSS/navigation.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Titillium+Web:ital@1&display=swap" rel="stylesheet">
</head>

<body>
    Add a post here<br>
    <!--  
   <form action="processpostservlet" method="post" name="loginform">   
     <label>Username : </label>   
     <input type="text" placeholder="Enter Username" name="name" required>  
     <label>Password : </label>   
     <input type="password" placeholder="Enter Password" name="password" required>  
     <button type="submit">Login</button>       
   </form><br><br>-->


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

                <div style="height: 280px"></div>
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
            <span><a href="">NerdStack</a> >> <a href="">random subforum</a></span>
        </div>
        <!--Display posts table-->
        <div class="posts-table">
            <div class="table-head">
                <div class="status">Status</div>
                <div class="subjects">Subjects</div>
                <div class="replies">Replies/Views</div>
                <div class="last-reply">Last Reply</div>
            </div>
            <div class="table-row">
                <div class="status"><i class="fa fa-fire"></i></div>
                <div class="subjects">
                    <a href="">Is Minato stronger than Itachi?</a>
                    <br>
                    <span>Started by <b><a href="">User</a></b> .</span>
                </div>
                <div class="replies">
                    2 replies <br> 125 views
                </div>

                <div class="last-reply">
                    Mar 31 2021
                    <br>By <b><a href="">User</a></b>
                </div>
            </div>
            <!--starts here-->
            <div class="table-row">
                <div class="status"><i class="fa fa-fire"></i></div>
                <div class="subjects">
                    <a href="">Can Kakashi defeat Madara with Susano?</a>
                    <br>
                    <span>Started by <b><a href="">User</a></b> .</span>
                </div>
                <div class="replies">
                    2 replies <br> 125 views
                </div>

                <div class="last-reply">
                    Mar 31 2021
                    <br>By <b><a href="">User</a></b>
                </div>
            </div>

            <div class="table-row">
                <div class="status"><i class="fa fa-fire"></i></div>
                <div class="subjects">
                    <a href="">Can Vegeta beat Beerus in Blue Mode?</a>
                    <br>
                    <span>Started by <b><a href="">User</a></b> .</span>
                </div>
                <div class="replies">
                    2 replies <br> 125 views
                </div>

                <div class="last-reply">
                    Mar 31 2021
                    <br>By <b><a href="">User</a></b>
                </div>
            </div>

            <div class="table-row">
                <div class="status"><i class="fa fa-book"></i></div>
                <div class="subjects">
                    <a href="">Is Goku stronger than Whis?</a>
                    <br>
                    <span>Started by <b><a href="">User</a></b> .</span>
                </div>
                <div class="replies">
                    2 replies <br> 125 views
                </div>

                <div class="last-reply">
                    Mar 31 2021
                    <br>By <b><a href="">User</a></b>
                </div>
            </div>

            <div class="table-row">
                <div class="status"><i class="fa fa-rocket"></i></div>
                <div class="subjects">
                    <a href="">Could Aang be the strongest Avatar?</a>
                    <br>
                    <span>Started by <b><a href="">User</a></b> .</span>
                </div>
                <div class="replies">
                    2 replies <br> 125 views
                </div>

                <div class="last-reply">
                    Mar 31 2021
                    <br>By <b><a href="">User</a></b>
                </div>
            </div>

            <div class="table-row">
                <div class="status"><i class="fa fa-frown-o"></i></div>
                <div class="subjects">
                    <a href="">Why Legend Of Korra Sucks?</a>
                    <br>
                    <span>Started by <b><a href="">User</a></b> .</span>
                </div>
                <div class="replies">
                    2 replies <br> 125 views
                </div>

                <div class="last-reply">
                    Mar 31 2021
                    <br>By <b><a href="">User</a></b>
                </div>
            </div>


            <div class="table-row">
                <div class="status"><i class="fa fa-fire"></i></div>
                <div class="subjects">
                    <a href="">Can Goku beat Jiren without Ultra Instinct?</a>
                    <br>
                    <span>Started by <b><a href="">User</a></b> .</span>
                </div>
                <div class="replies">
                    2 replies <br> 125 views
                </div>

                <div class="last-reply">
                    Mar 31 2021
                    <br>By <b><a href="">User</a></b>
                </div>
            </div>

            
            <!--ends here-->
        </div>
        <!--Pagination starts-->
        <div class="pagination">
            pages: <a href="">1</a><a href="">2</a><a href="">3</a>
        </div>
        <!--pagination ends-->
    </div>

    <div class="note">
        <span><i class="fa fa-frown-o"></i>&nbsp; 0 Engagement Topic</span>&nbsp;&nbsp;&nbsp;<a href=""><i
                class="fa fa-share-square"></i></a><br>
        <span><i class="fa fa-book"></i>&nbsp; Low Engagement Topic</span>&nbsp;&nbsp;&nbsp;<a href=""><i
                class="fa fa-share-square"></i></a><br>
        <span><i class="fa fa-fire"></i>&nbsp; Popular Topic</span>&nbsp;&nbsp;&nbsp;<a href=""><i
                class="fa fa-share-square"></i></a><br>
        <span><i class="fa fa-rocket"></i>&nbsp; High Engagement Topic</span>&nbsp;&nbsp;&nbsp;<a href=""><i
                class="fa fa-share-square"></i></a><br>
        <span><i class="fa fa-lock"></i>&nbsp; Closed Topic</span>&nbsp;&nbsp;&nbsp;<a href=""><i
                class="fa fa-share-square"></i></a><br>
    </div>

    <footer>
        <span>&copy; NerdStack Group</span>
    </footer>

    <script src="js/jquery-3.5.1.js"></script>
    <script src="js/navigation.js"></script>


</body>
