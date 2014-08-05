package edu.franklin.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.franklin.model.MediaManagerDAO;
import edu.franklin.model.PurchaseInfo;

/**
 * Servlet implementation class AddPurchaseInfoServlet
 */
@WebServlet(urlPatterns = "/admin/addpurchaseinfo.do")
public class AddPurchaseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		HttpServletRequest request = req;
		HttpServletResponse response = res;
		RequestDispatcher rd = 
                request.getRequestDispatcher("/admin/adminpurchloc.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		HttpServletRequest request = req;
		HttpServletResponse response = res;
		MediaManagerDAO dao = (MediaManagerDAO) getServletContext()
				.getAttribute("dao");
		PurchaseInfo info = new PurchaseInfo();
		String purLoc = request.getParameter("purLoc");
		info.setPurLoc(purLoc);
		RequestDispatcher rd;
		try {
			dao.addItem(info);
			rd = request.getRequestDispatcher("/admin/adminsuccess.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			rd = request.getRequestDispatcher("/admin/adminfail.jsp");
		}
		rd.forward(request, response);
	}

}
