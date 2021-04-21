

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PostDao;
import dao.PostDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import entity.Post;
import entity.User;

/**
 * Servlet implementation class processpostservlet
 */
@WebServlet("/processpostservlet")
public class processpostservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public processpostservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Get parameters from form
        String subject=request.getParameter("subject");
        String body=request.getParameter("body");
        
        HttpSession session=request.getSession(false);
		User newUser;
		String author = "";
		
	    if((User)session.getAttribute("theUser") != null){
	    	newUser = (User)session.getAttribute("theUser");
	    	author = newUser.getUsername();
	    }
	    
	    PostDao postDao=new PostDaoImpl();
        Post new_post;
        
        new_post = postDao.addPost(author,subject,body);

	    request.getRequestDispatcher("home.jsp").include(request, response);
		
		/*response.setContentType("text/html");
		Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        
         
        String JDBCUrl = "jdbc:mysql://localhost:3306";
        String username = "root";
        String password = "test";
        PrintWriter out = response.getWriter();
        try {
            System.out.println("\nConnecting to the SSD Database......");
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(JDBCUrl, username, password);
        }
        catch (Exception e) {
            System.out.println("\nAn error has occurred during the connection phase!  This is most likely due to your CLASSPATH being set wrong and the"
                    + "  classes unable to be found.  Otherwise the database itself may be down.  Try telneting to port 3306 and see if it is up!");
            e.printStackTrace();
            System.exit(0);
        }   
		
        // Get parameters from form
        String subject=request.getParameter("subject");
        String body=request.getParameter("body");
        
        System.out.println(subject+body);
        
        try {
		     System.out.println("\nConnection Successful..... creating statement....");
	     	     stmt = con.createStatement();
	     	     
	     	     // Create a prepared statement for insert
	     	    PreparedStatement pstmt = con.prepareStatement("INSERT INTO mydata.posts(Post_id, author, subject, body, likes) VALUES (?,?,?,?, ?)");
				  pstmt.clearParameters();       // Clears any previous parameters
				  // Add values
				  int post_id = (int)(Math.random() * 1000000);
				  pstmt.setInt(1, post_id);
				  
				  HttpSession session=request.getSession(false);
				  User newUser;
				  String author = "";
			      if((User)session.getAttribute("theUser") != null){
			    	  newUser = (User)session.getAttribute("theUser");
			    	  author = newUser.getUsername();
			      }
				  
			      pstmt.setInt(1, post_id);
				  pstmt.setString(2, author);
				  pstmt.setString(3, subject);
				  pstmt.setString(4, body);
				  pstmt.setInt(5, 0);
				  // Execute the insert
				  pstmt.executeUpdate();

				request.getRequestDispatcher("posts.jsp").include(request, response);
       }
       catch (SQLException e) {
       	System.out.println("\nAn error has occurred during the Statement/ResultSet phase.  Please check the syntax and study the Exception details!");
           while (e != null) {
           	System.out.println(e.getMessage());
               e = e.getNextException();
           }
           System.exit(0);
       }finally {
          	 try {    
          	     if (rs != null) rs.close();
          		 if (stmt != null) stmt.close();
          		 if (con != null) con.close();
          	  }
          	  catch (Exception ex) {
          	  System.out.println("An error occurred while closing down connection/statement"); 
             }
       
        }*/
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
