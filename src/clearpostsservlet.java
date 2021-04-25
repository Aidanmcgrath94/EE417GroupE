

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import dao.CommentDaoImpl;
import dao.PostDao;
import dao.PostDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;

/**
 * Servlet implementation class clearpostsservlet
 */
@WebServlet("/clearpostsservlet")
public class clearpostsservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public clearpostsservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PostDao postDao=new PostDaoImpl();
		CommentDao commentDao = new CommentDaoImpl();
		
		System.out.println("here");
		postDao.clearPosts();
		commentDao.clearComments();
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
