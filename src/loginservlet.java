

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

import entity.User;
import dao.*;

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
		PrintWriter out = response.getWriter();
		
		String username=request.getParameter("name");
		String password=request.getParameter("password");
		
		UserDao userDao=new UserDaoImpl();
		User new_user;
		HttpSession session = request.getSession();
		if(userDao.usernameExist(username) == true) {
			if(userDao.verifyUsername(username,password) != null) {
				new_user = userDao.verifyUsername(username,password);
				
				
				//Add the user to the sessions
				session.setAttribute("theUser", new_user);
				session.setAttribute("login_failed", false);
				// Set session expiry time
				session.setMaxInactiveInterval(600);
				request.getRequestDispatcher("home.jsp").include(request, response);
			}
			else {	// Login unsuccessful
		    	// Display index.jsp with appropriate message
				session.setAttribute("login_failed", true);
				// Set session expiry time
				session.setMaxInactiveInterval(10);
				request.getRequestDispatcher("login.jsp").include(request, response);
		     }
		}
		else {	// Login unsuccessful
	    	
			session.setAttribute("login_failed", true);
			// Set session expiry time
			session.setMaxInactiveInterval(10);
			request.getRequestDispatcher("login.jsp").include(request, response);
			
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
