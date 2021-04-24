

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.engagementDao;
import dao.engagementDaoImpl;
import entity.Post;

/**
 * Servlet implementation class zeroEngagement
 */
@WebServlet("/zeroEngagement")
public class zeroEngagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public zeroEngagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		engagementDao d= new engagementDaoImpl();
		
		List<Post> posts = new ArrayList<Post>();
		
		
			posts=d.searchZeroEngagement();
			
			request.setAttribute("zeroEngagedPosts", posts);
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
