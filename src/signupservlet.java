

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
import entity.User;

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
		PrintWriter out = response.getWriter();
		
		String fname=request.getParameter("firstname");
        String lname=request.getParameter("lastname");
        String uname=request.getParameter("username");
        String usermail=request.getParameter("usermail"); 
        String pass=request.getParameter("password");
        String confirm_pass=request.getParameter("confirm_password");
        String admin_pass=request.getParameter("admin_password");
        
        UserDao userDao=new UserDaoImpl();
        User new_user;
        HttpSession session = request.getSession();
        
        if(pass.equals(confirm_pass)) {
        	if(admin_pass.equals("admin123")) {
        		new_user = userDao.addUser(uname,pass,fname,lname,usermail, true);
        	}
        	else {
        		new_user = userDao.addUser(uname,pass,fname,lname,usermail, false);
        	}
        	
			//Add the user
        	session.setAttribute("theUser", new_user);
        	// Set session expiry time
        	session.setAttribute("matched_failed", false);
			session.setMaxInactiveInterval(600);
			request.getRequestDispatcher("home.jsp").include(request, response);
        }
        else {
        	session.setAttribute("matched_failed", true);
			// Set session expiry time
			session.setMaxInactiveInterval(10);
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
