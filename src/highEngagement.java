

import java.io.IOException;

import entity.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import dao.engagementDao;
import dao.engagementDaoImpl;

/**
 * Servlet implementation class highEngagement
 */
@WebServlet("/highEngagement")
public class highEngagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public highEngagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	engagementDao d= new engagementDaoImpl();
	
	List<Post> posts = new ArrayList<Post>();
	
	
		posts=d.searchHighEngagement();
		
		request.setAttribute("highEngagedPosts", posts);
		  RequestDispatcher rd = request.getRequestDispatcher("");
	        rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
