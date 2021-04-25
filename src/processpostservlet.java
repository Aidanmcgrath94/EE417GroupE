

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
	    
	    String sort_by = "";
	    if((String)session.getAttribute("sort_by") != null){
	    	sort_by = (String) session.getAttribute("sort_by");
	    }
	    System.out.println(sort_by);
	    
	    PostDao postDao=new PostDaoImpl();
        Post new_post;
        
        new_post = postDao.addPost(author,subject,body);

	    request.getRequestDispatcher("home.jsp").include(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
