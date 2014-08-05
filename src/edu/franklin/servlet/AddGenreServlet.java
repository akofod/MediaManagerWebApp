package edu.franklin.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.franklin.model.Genre;
import edu.franklin.model.MediaManagerDAO;

/**
 * Servlet implementation class AddGenreServlet
 */
@WebServlet(urlPatterns = "/admin/addGenre.do")
public class AddGenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpServletRequest request = req;
		HttpServletResponse response = res;
        RequestDispatcher rd = 
                request.getRequestDispatcher("/admin/admingenre.jsp");
        rd.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpServletRequest request = req;
		HttpServletResponse response = res;
		MediaManagerDAO dao = (MediaManagerDAO) getServletContext().getAttribute("dao"); //May need to create new connection.
		Genre genre = new Genre();
		String desc = request.getParameter("genre");
		genre.setGenreDesc(desc);
		RequestDispatcher rd;
		try {
			dao.addItem(genre);
			rd = request.getRequestDispatcher("/admin/adminsuccess.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			rd = request.getRequestDispatcher("/admin/adminfail.jsp");
		}
        rd.forward(request, response);
	}

}
