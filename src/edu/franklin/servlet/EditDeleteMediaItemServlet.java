package edu.franklin.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.franklin.model.MediaItem;
import edu.franklin.model.MediaManagerDAO;
import edu.franklin.model.PurchaseInfoMediaItem;

/**
 * Servlet implementation class EditDeleteMediaItemServlet
 */
@WebServlet(urlPatterns = {"/admin/editmediaitem.do","/admin/deletemediaitem.do","/admin/performeditmediaitem.do"})
public class EditDeleteMediaItemServlet extends HttpServlet {
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
		MediaManagerDAO dao = (MediaManagerDAO) getServletContext().getAttribute("dao");
		RequestDispatcher rd;
		int itemId = Integer.parseInt(request.getParameter("id"));
		int genreId = Integer.parseInt(request.getParameter("genreId"));
		int mediaTypeId = Integer.parseInt(request.getParameter("mediaTypeId"));
		String name = request.getParameter("name");
		int year = Integer.parseInt(request.getParameter("year"));
		String comments = request.getParameter("comments");
		double curVal = Double.parseDouble(request.getParameter("curVal"));
		MediaItem item = new MediaItem();
		item.setId(itemId);
		item.setGenreId(genreId);
		item.setMediaTypeId(mediaTypeId);
		item.setName(name);
		item.setYear(year);
		item.setComments(comments);
		item.setCurVal(curVal);
		
		int purId = Integer.parseInt(request.getParameter("purId"));
		double purInfoPurPrice = Double.parseDouble(request.getParameter("purInfoPurPrice"));
		Date purInfoPurDate = Calendar.getInstance().getTime();
		String pDateStr = request.getParameter("purInfoPurDate");
		System.out.println(pDateStr);
		String modDateStr = request.getParameter("purInfoPurDate");
		String[] dateParts = pDateStr.split("-");
		
		if (dateParts.length == 3) {
			modDateStr = dateParts[1] + "/" + dateParts[2] + "/" + dateParts[0];
		}
		
		DateFormat df = new SimpleDateFormat("M/d/yyyy", Locale.US);
		try {
			purInfoPurDate = df.parse(modDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		int purInfoId = Integer.parseInt(request.getParameter("purInfoId"));
		int purInfoMediaItemId = Integer.parseInt(request.getParameter("id"));
		PurchaseInfoMediaItem purInfo = new PurchaseInfoMediaItem();
		purInfo.setId(purId);
		purInfo.setPurPrice(purInfoPurPrice);
		purInfo.setPurDate(purInfoPurDate);
		purInfo.setPurInfoId(purInfoId);
		purInfo.setMediaItemId(purInfoMediaItemId);
		
		item.setPurInfo(purInfo);
			
		if (request.getServletPath().equals("/admin/editmediaitem.do")) {
			request.setAttribute("allgenres", dao.getGenres());
			request.setAttribute("alltypes", dao.getMediaTypes());
			request.setAttribute("alllocations", dao.getPurchaseInfo());
			request.setAttribute("modDateStr", modDateStr);
			request.setAttribute("item", item);
			rd = request.getRequestDispatcher("/admin/admineditem.jsp");
			rd.forward(request, response);
		}
		else if (request.getServletPath().equals("/admin/performeditmediaitem.do")){
			try {
				System.out.println("In perform edit function.");
				dao.updateItem(purInfo);				
				dao.updateItem(item);
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
				dao.deleteItem(purInfo);
				dao.deleteItem(item);
				rd = request.getRequestDispatcher("/admin/adminsuccess.jsp");
				rd.forward(request, response);
			}
			catch (Exception e) {
				
				String message = "Delete failed: " + e.getMessage();
				request.setAttribute("message", message);
				rd = request.getRequestDispatcher("/admin/adminfail.jsp");
				rd.forward(request, response);
				
			}
		}
	}

}
