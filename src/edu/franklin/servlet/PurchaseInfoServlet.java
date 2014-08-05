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
import edu.franklin.model.PurchaseInfo;

/**
 * Servlet implementation class PurchaseInfoServlet
 */
@WebServlet(urlPatterns = {"/purchaseinfo.do","/admin/allpurchlocs.do"})
public class PurchaseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<PurchaseInfo> locations;
		response.setContentType("text/html");
		MediaManagerDAO dao = (MediaManagerDAO) getServletContext().getAttribute("dao");
		
		locations = dao.getPurchaseInfo();
		
		request.setAttribute("locations", locations);
		
		RequestDispatcher rd;
        if(request.getServletPath().equals("/purchaseinfo.do")) {
        	rd = request.getRequestDispatcher("/purchaseInfo.jsp");
        }
        else {
        	rd = request.getRequestDispatcher("/admin/adminalllocs.jsp");
        }
        rd.forward(request, response);
	}
}
