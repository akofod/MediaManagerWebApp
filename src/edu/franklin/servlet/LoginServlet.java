package edu.franklin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.franklin.dataaccess.MediaManagerAdminDAO;
import edu.franklin.model.UserDetail;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("logout")!=null){
			request.getSession().removeAttribute("authorized");
			response.sendRedirect("adminhome.jsp");
		}else{
			response.sendRedirect("admin/adminwel.jsp");
//			RequestDispatcher rd = 
//	                request.getRequestDispatcher("admin/adminwel.jsp");
//	        rd.forward(request, response);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		MediaManagerAdminDAO dao = (MediaManagerAdminDAO) getServletContext().getAttribute("admindao");;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		RequestDispatcher rd;
		UserDetail ud = dao.authenticateUser(username, password);
		if (null != ud && ud.getAuthLevel()==1) {
			HttpSession session = request.getSession();
			session.setAttribute("authorized", true);
			System.out.println("Session authorized attribute is: " + session.getAttribute("authorized"));
			rd = request.getRequestDispatcher("admin/adminwel.jsp");
		}
		else {
			rd = request.getRequestDispatcher("/adminhome.jsp");
		}
		
        rd.forward(request, response);
	}

}
