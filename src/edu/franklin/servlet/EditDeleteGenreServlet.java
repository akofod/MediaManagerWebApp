package edu.franklin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.franklin.model.Genre;
import edu.franklin.model.MediaManagerDAO;

/**
 * Servlet implementation class EditDeleteGenre
 */
@WebServlet(urlPatterns = {"/admin/editgenre.do","/admin/deletegenre.do","/admin/performeditgenre.do"})
public class EditDeleteGenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int genreId = Integer.parseInt(request.getParameter("id"));
		String genreDesc = request.getParameter("desc");
		int itemCount = Integer.parseInt(request.getParameter("count"));
		Genre genre = new Genre();
		genre.setId(genreId);
		genre.setGenreDesc(genreDesc);
		genre.setItemCount(itemCount);
		MediaManagerDAO dao = (MediaManagerDAO) getServletContext().getAttribute("dao");
		RequestDispatcher rd;
		if (request.getServletPath().equals("/admin/editgenre.do")) {
			request.setAttribute("genre", genre);
			rd = request.getRequestDispatcher("/admin/adminedgenre.jsp");
			rd.forward(request, response);
		}
		else if (request.getServletPath().equals("/admin/performeditgenre.do")){
			try {
				genre.setGenreDesc(request.getParameter("genre"));
				dao.updateItem(genre);
				rd = request.getRequestDispatcher("/admin/adminsuccess.jsp");
				rd.forward(request, response);
			}
			catch (Exception e) {
				String message = "Edit failed: " + e.getMessage();
				request.setAttribute("message", message);
				rd = request.getRequestDispatcher("/admin/adminfail.jsp");
				rd.forward(request, response);
			}
		}
		else {
			try {
				dao.deleteItem(genre);
				rd = request.getRequestDispatcher("/admin/adminsuccess.jsp");
				rd.forward(request, response);
			}
			catch (Exception e) {
				if (itemCount != 0) {
					String message = "Delete failed: " + genreDesc + " is assigned to " + itemCount + " item(s) and cannot be deleted.";
					request.setAttribute("message", message);
					rd = request.getRequestDispatcher("/admin/adminfail.jsp");
					rd.forward(request, response);
				}
				else {
					String message = "Delete failed: " + e.getMessage();
					request.setAttribute("message", message);
					rd = request.getRequestDispatcher("/admin/adminfail.jsp");
					rd.forward(request, response);
				}
			}
		}
	}

}
