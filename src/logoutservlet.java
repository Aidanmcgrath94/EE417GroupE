

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logoutservlet
 */
@WebServlet("/logoutservlet")
public class logoutservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logoutservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				
				// Display index.jsp
				request.getRequestDispatcher("login.jsp").include(request, response);
				
				// Get session
				HttpSession session=request.getSession();
				
				// invalidate session
				session.invalidate();
				
				// Invalidate cookies
				Cookie[] cookies = request.getCookies();
			    if (cookies != null)
			        for (Cookie cookie : cookies) {
			            cookie.setValue("");
			            cookie.setPath("/");
			            cookie.setMaxAge(0);
			            response.addCookie(cookie);
			        }
				
				out.print("You are successfully logged out!");
				
				out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
