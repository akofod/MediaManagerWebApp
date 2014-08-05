package edu.franklin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.franklin.model.MediaManagerDAO;
import edu.franklin.model.MediaType;

/**
 * Servlet implementation class EditDeleteMediaTypeServlet
 */
@WebServlet(urlPatterns = {"/admin/edittype.do","/admin/deletetype.do","/admin/performedittype.do"})
public class EditDeleteMediaTypeServlet extends HttpServlet {
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
		int typeId = Integer.parseInt(request.getParameter("id"));
		String mediaType = request.getParameter("desc");
		int itemCount = Integer.parseInt(request.getParameter("count"));
		MediaType type = new MediaType();
		type.setId(typeId);
		type.setMediaType(mediaType);
		type.setItemCount(itemCount);
		MediaManagerDAO dao = (MediaManagerDAO) getServletContext().getAttribute("dao");
		RequestDispatcher rd;
		if (request.getServletPath().equals("/admin/edittype.do")) {
			request.setAttribute("type", type);
			rd = request.getRequestDispatcher("/admin/adminedtype.jsp");
			rd.forward(request, response);
		}
		else if (request.getServletPath().equals("/admin/performedittype.do")){
			try {
				type.setMediaType(request.getParameter("type"));
				dao.updateItem(type);
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
				dao.deleteItem(type);
				rd = request.getRequestDispatcher("/admin/adminsuccess.jsp");
				rd.forward(request, response);
			}
			catch (Exception e) {
				if (itemCount != 0) {
					String message = "Delete failed: " + mediaType + " is assigned to " + itemCount + " item(s) and cannot be deleted.";
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
