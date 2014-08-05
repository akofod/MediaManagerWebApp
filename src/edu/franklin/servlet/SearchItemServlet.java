package edu.franklin.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.franklin.model.ItemDetail;
import edu.franklin.model.MediaManagerDAO;

/**
 * Servlet implementation class SearchItem
 */
@WebServlet(urlPatterns = "/SearchForItems.do")
public class SearchItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchType = request.getParameter("searchType");
		ArrayList<ItemDetail> items; 
		MediaManagerDAO dao = (MediaManagerDAO) getServletContext().getAttribute("dao");
		
		if (searchType.equals("name")) {
			String term = request.getParameter("itemName");
			items = dao.searchItem(term);
		}
		else if (searchType.equals("genre")) {
			String term = request.getParameter("genre");
			items = dao.getItemsByGenre(term);
		}
		else if (searchType.equals("type")) {
			String term = request.getParameter("type");
			items = dao.getItemsByType(term);
		}
		else {
			String term = request.getParameter("location");
			items = dao.getItemsByLocation(term);
		}
		
		RequestDispatcher rd;
		if (items.size() != 0) {
			request.setAttribute("items", items);
			rd = request.getRequestDispatcher("/itemDetail.jsp");
		}
		else {
			rd = request.getRequestDispatcher("/noitems.jsp");
		}
        rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ItemDetail> items; 
		MediaManagerDAO dao = (MediaManagerDAO) getServletContext().getAttribute("dao");
		
		String term = request.getParameter("itemName");
		items = dao.searchItem(term);
		
		RequestDispatcher rd;
		if (items.size() != 0) {
			request.setAttribute("items", items);
			rd = request.getRequestDispatcher("/itemDetail.jsp");
		}
		else {
			rd = request.getRequestDispatcher("/noitems.jsp");
		}
        rd.forward(request, response);
	}
}
