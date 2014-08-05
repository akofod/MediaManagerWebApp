package edu.franklin.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.franklin.model.MediaManagerDAO;
import edu.franklin.model.MediaType;

/**
 * Servlet implementation class MediaTypeServlet
 */
@WebServlet(urlPatterns = {"/mediatypes.do","/admin/alltypes.do"})
public class MediaTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MediaType> types;
		response.setContentType("text/html");
		MediaManagerDAO dao = (MediaManagerDAO) getServletContext().getAttribute("dao");
		
		types = dao.getMediaTypes();
		
		request.setAttribute("types", types);
		
		RequestDispatcher rd;
		if (request.getServletPath().equals("/mediatypes.do")) {
			rd = request.getRequestDispatcher("/mediaTypes.jsp");
		}
		else {
			rd = request.getRequestDispatcher("/admin/adminalltypes.jsp");
		}
        rd.forward(request, response);
	}
}
