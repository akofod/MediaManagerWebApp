package edu.franklin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.franklin.model.MediaManagerDAO;
import edu.franklin.model.PurchaseInfo;

/**
 * Servlet implementation class EditDeletePurchaseInfoServlet
 */
@WebServlet(urlPatterns = {"/admin/editpurchaseinfo.do","/admin/deletepurchaseinfo.do","/admin/performeditpurchaseinfo.do"})
public class EditDeletePurchaseInfoServlet extends HttpServlet {
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
		int purLocId = Integer.parseInt(request.getParameter("id"));
		String purLoc = request.getParameter("desc");
		int itemCount = Integer.parseInt(request.getParameter("count"));
		PurchaseInfo info = new PurchaseInfo();
		info.setId(purLocId);
		info.setPurLoc(purLoc);
		info.setItemCount(itemCount);
		MediaManagerDAO dao = (MediaManagerDAO) getServletContext().getAttribute("dao");
		RequestDispatcher rd;
		if (request.getServletPath().equals("/admin/editpurchaseinfo.do")) {
			request.setAttribute("info", info);
			rd = request.getRequestDispatcher("/admin/adminedpurchloc.jsp");
			rd.forward(request, response);
		}
		else if (request.getServletPath().equals("/admin/performeditpurchaseinfo.do")){
			try {
				info.setPurLoc(request.getParameter("purLoc"));
				dao.updateItem(info);
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
				dao.deleteItem(info);
				rd = request.getRequestDispatcher("/admin/adminsuccess.jsp");
				rd.forward(request, response);
			}
			catch (Exception e) {
				if (itemCount != 0) {
					String message = "Delete failed: " + purLoc + " is assigned to " + itemCount + " item(s) and cannot be deleted.";
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
