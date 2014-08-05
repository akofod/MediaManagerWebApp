package edu.franklin.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.franklin.model.Genre;
import edu.franklin.model.MediaManagerDAO;

/**
 * Servlet implementation class GenresServlet
 */
@WebServlet(urlPatterns = {"/genres.do","/admin/allgenres.do"})
public class GenresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Genre> genres;
		response.setContentType("text/html");
		MediaManagerDAO dao = (MediaManagerDAO) getServletContext().getAttribute("dao");
		
		genres = dao.getGenres();
		
		request.setAttribute("genres", genres);
		RequestDispatcher rd;
		if (request.getServletPath().equals("/genres.do")) {
			rd = request.getRequestDispatcher("/genres.jsp");
		}
		else {
			rd = request.getRequestDispatcher("/admin/adminallgenres.jsp");
		}
        rd.forward(request, response);
	}
}
