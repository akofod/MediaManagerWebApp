package edu.franklin.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.franklin.model.*;

/**
 * Servlet implementation class AllItemsServlet
 */
@WebServlet(urlPatterns = {"/items.do","/admin/allitems.do"})
public class AllItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ItemView> items;
		ArrayList<MediaItem> adminItems = null;
		response.setContentType("text/html");
		MediaManagerDAO dao = (MediaManagerDAO) getServletContext().getAttribute("dao");
		HttpSession session = request.getSession();
		System.out.println("Session created at: " + session.getCreationTime());
		RequestDispatcher rd;
		
		if (request.getServletPath().equals("/items.do")) {
			items = (ArrayList<ItemView>) session.getAttribute("items");
		
			if (items == null || items.size() == 0) {
				items = dao.getAllItems();
				System.out.println("Previous session not found. New session created");
				session.setAttribute("items", items);
				System.out.println("Session attribute set.");
			}
			else {
				System.out.println("Previous session found. Using items from session attribute.");
			}
		
			request.setAttribute("items", items);
			rd = request.getRequestDispatcher("/items.jsp");
		}
		else {
			try {
				adminItems = dao.getMediaItems();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("items", adminItems);
			rd = request.getRequestDispatcher("/admin/adminallitems.jsp");
		}
        
        rd.forward(request, response);
	}
}
