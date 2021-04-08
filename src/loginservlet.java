

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.*;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
              
        /*
         * *****************************************
         * NEED TO FIGURE OUT THESE
         * ****************************************
         * 
         */
			
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
		String name=request.getParameter("name");
		String user_password=request.getParameter("password");
				 
		try {
		     System.out.println("\nConnection Successful..... creating statement....");
	     	     stmt = con.createStatement();
	     	     
	     	 // Create select statement
		     rs = stmt.executeQuery("SELECT * FROM mydata.profiles where Username=\"" + name  + "\"and Passwrd = \""+ user_password+ "\";");
		
		     /// Get the users details from the returned row
		    if (rs.next()) {   // login succeeded  	
		    	int id = rs.getInt("USER_ID");
		    	String fname=rs.getString("firstname");
		        String lname=rs.getString("lastname");
		        String uname=rs.getString("username");
		        String usermail=rs.getString("email");
		        String favourite = rs.getString("favourite");
		        String pass=rs.getString("passwrd");
		        
		    	boolean admin = true;
		    	admin = rs.getBoolean("is_admin");
		    	
		    	// Create a User object
		    	User newUser = new User(id, uname, pass, fname, lname, usermail, favourite, admin);
				  
				HttpSession session = request.getSession();
				
				//Add the user to the sessions
				session.setAttribute("theUser", newUser);
				// Set session expiry time
				session.setMaxInactiveInterval(600);
				request.getRequestDispatcher("home.jsp").include(request, response);
		    	
		    }
	    
		    else {	// Login unsuccessful
		    	// Display index.jsp with appropriate message
				request.getRequestDispatcher("login.jsp").include(request, response);
				out.print("Sorry, username or password error! Try again");
		     }
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
