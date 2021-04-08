

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

import user.User;

/**
 * Servlet implementation class signupservlet
 */
@WebServlet("/signupservlet")
public class signupservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupservlet() {
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
		
        // Get parameters from form
        String fname=request.getParameter("firstname");
        String lname=request.getParameter("lastname");
        String uname=request.getParameter("username");
        String usermail=request.getParameter("usermail");
        String favourite = request.getParameter("favourite"); 
        String pass=request.getParameter("password");
        String confirm_pass=request.getParameter("confirm_password");
        String admin_pass=request.getParameter("admin_password");
		int id;
		boolean admin;
		
		// If the two supplied passwords match
        if(pass.equals(confirm_pass)) {
	        try {
			     System.out.println("\nConnection Successful..... creating statement....");
		     	     stmt = con.createStatement();
		     	     
		     	     // Create a prepared statement for insert
		     	    PreparedStatement pstmt = con.prepareStatement("INSERT INTO mydata.profiles(USER_id,username,Passwrd,Firstname,Lastname,email,favourite, is_admin) VALUES (?,?,?,?,?,?,?,?)");
					  pstmt.clearParameters();       // Clears any previous parameters
					  // Add values
					  id = (int)(Math.random() * 1000000);
					  pstmt.setInt(1, id);
					  pstmt.setString(2, uname);
					  pstmt.setString(3, pass);
					  pstmt.setString(4, fname);
					  pstmt.setString(5, lname);
					  pstmt.setString(6, usermail);
					  pstmt.setString(7, favourite);;
					  if(admin_pass.equals("admin123")) {
						  admin = true;
						  pstmt.setInt(8, 1);
					  }
					  else {
						  admin = false;
						  pstmt.setInt(8, 0);
					  }
					  
					  // Execute the insert
					  pstmt.executeUpdate();
					  
					  // Create a new User object
					  User newUser = new User(id, uname, pass, fname, lname, usermail, favourite, admin);
					  
					  HttpSession session = request.getSession();
						 //Add the user
					  session.setAttribute("theUser", newUser);
					// Set session expiry time
						session.setMaxInactiveInterval(600);
						request.getRequestDispatcher("home.jsp").include(request, response);
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
        else {
        	out.print("Please enter matching passwords<br><br><br>");
        	request.getRequestDispatcher("signup.jsp").include(request, response);
    		
    		out.close();
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
