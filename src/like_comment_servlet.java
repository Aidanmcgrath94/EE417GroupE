

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

import dao.UserDao;
import dao.UserDaoImpl;
import dao.PostDao;
import dao.PostDaoImpl;
import dao.CommentDao;
import dao.CommentDaoImpl;
import entity.User;

/**
 * Servlet implementation class like_comment_servlet
 */
@WebServlet("/like_comment_servlet")
public class like_comment_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public like_comment_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// Get parameters
		String action=request.getParameter("action");
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String comment = request.getParameter("user_comment");
		
		PostDao postDao=new PostDaoImpl();
		UserDao userDao = new UserDaoImpl();
		CommentDao commentDao = new CommentDaoImpl();
		
		if(action.equals("like")) {
			postDao.incrementLikes(post_id);
		}
		else if(action.equals("comment")) {
			String author = userDao.getUsername(user_id);
			commentDao.addComment(post_id, author, comment);
		}
		
		request.getRequestDispatcher("home.jsp").include(request, response);
		
		/*
		response.setContentType("text/html");
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
	
		
		// Get parameters
		String action=request.getParameter("action");
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String comment = request.getParameter("user_comment");
		
		System.out.println(user_id);
		
		if(action.equals("like")) {
			try {
		   	     System.out.println("\nConnection Successful..... creating statement....");
		         stmt = con.createStatement();
		         
		         int likes = 0;
		         
		         rs = stmt.executeQuery("SELECT * FROM mydata.post where _ID=\"" + post_id + "\";");
		         if (rs.next()) {   // 
		 		    	likes = rs.getInt("likes");
		 		    	likes++;
		         }
		         
		         String sql = "UPDATE mydata.post SET likes=?";
		         sql += " WHERE _ID = ?";
		 		 PreparedStatement pstmt = con.prepareStatement(sql);
		 		  
		 		 // Add values to the prepared statement
		         pstmt.setInt(1, likes);
		         pstmt.setInt(2, post_id);
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
	           }

	           finally {
	   	     try {    
	   	         if (rs != null) rs.close();
	   		 if (stmt != null) stmt.close();
	   		 if (con != null) con.close();
	   	     }
	   	     catch (Exception ex) {
	   	         System.out.println("An error occurred while closing down connection/statement"); 
	               }
	           }	
		}
		
		if(action.equals("comment")) {
			try {
			     System.out.println("\nConnection Successful..... creating statement....");
		     	     stmt = con.createStatement();
		     	     
		     	    String author = "";
			         
			         rs = stmt.executeQuery("SELECT * FROM mydata.user where _ID=\"" + user_id + "\";");
			         if (rs.next()) {   // 
			 		    	author = rs.getString("username");
			         }
		     	     
		     	     // Create a prepared statement for insert
		     	    PreparedStatement pstmt = con.prepareStatement("INSERT INTO mydata.comments(comment_id, post_id, author, comment) VALUES (?,?,?,?)");
					  pstmt.clearParameters();       // Clears any previous parameters
					  // Add values
					  int comment_id = (int)(Math.random() * 1000000);
					  pstmt.setInt(1, post_id);
					  
				      pstmt.setInt(1, comment_id);
					  pstmt.setInt(2, post_id);
					  pstmt.setString(3,author );
					  pstmt.setString(4, comment);

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
