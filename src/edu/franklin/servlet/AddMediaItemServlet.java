package edu.franklin.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.franklin.model.Genre;
import edu.franklin.model.MediaItem;
import edu.franklin.model.MediaManagerDAO;
import edu.franklin.model.MediaType;
import edu.franklin.model.PurchaseInfo;
import edu.franklin.model.PurchaseInfoMediaItem;

/**
 * Servlet implementation class AddMediaItemServlet
 */
@WebServlet(urlPatterns = "/admin/additem.do")
public class AddMediaItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
		HttpServletRequest request = req;
		HttpServletResponse response = res;
		MediaManagerDAO dao = (MediaManagerDAO) getServletContext().getAttribute("dao");
		ArrayList<Genre> genres = dao.getGenres();
		ArrayList<MediaType> types = dao.getMediaTypes();
		ArrayList<PurchaseInfo> purInfo = dao.getPurchaseInfo();
		request.setAttribute("genres", genres);
		request.setAttribute("types", types);
		request.setAttribute("purInfo", purInfo);
        RequestDispatcher rd = 
                request.getRequestDispatcher("/admin/adminitem.jsp");
        rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpServletRequest request = req;
		HttpServletResponse response = res;
		RequestDispatcher rd;
		MediaManagerDAO dao = (MediaManagerDAO) getServletContext().getAttribute("dao");
		MediaItem item = new MediaItem();
		int genreId = Integer.parseInt(request.getParameter("genre"));
		int mediaTypeId = Integer.parseInt(request.getParameter("type"));
		
		String name = request.getParameter("title");
		if (name.equals("")) {
			String message = "Add Item Failed: Title of item must be entered.";
			request.setAttribute("message", message);
			rd = request.getRequestDispatcher("/admin/adminfail.jsp");
			rd.forward(request, response);
		}
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		try {
			year = Integer.parseInt(request.getParameter("year"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		String comments = request.getParameter("comments");
		
		double curVal = 0.0;
		try {
			curVal = Double.parseDouble(request.getParameter("currval"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		item.setGenreId(genreId);
		item.setMediaTypeId(mediaTypeId);
		item.setName(name);
		item.setYear(year);
		item.setComments(comments);
		item.setCurVal(curVal);
		int itemId = 0;
		try {
			itemId = dao.addItem(item);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if (itemId == 0) {
			System.out.println("Adding item failed.");
			rd = request.getRequestDispatcher("/admin/adminfail.jsp");
			rd.forward(request, response);
		}
		PurchaseInfoMediaItem pur = new PurchaseInfoMediaItem();
		
		double purPrice = 0.0;
		try {
			purPrice = Double.parseDouble(request.getParameter("price"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		String pDateStr = request.getParameter("date");
		DateFormat df = new SimpleDateFormat("M/d/yyyy", Locale.US);
	    Date purDate = Calendar.getInstance().getTime();
		try {
			purDate = df.parse(pDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		int purInfoId = Integer.parseInt(request.getParameter("purchloc"));
		pur.setMediaItemId(itemId);
		pur.setPurPrice(purPrice);
		pur.setPurDate(purDate);
		pur.setPurInfoId(purInfoId);
		
		try {
			if (dao.addItem(pur) == 0) {
				rd = request.getRequestDispatcher("/admin/adminfail.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Adding item success.");
		HttpSession session = request.getSession();
		session.setAttribute("items", null);
		rd = request.getRequestDispatcher("/admin/adminsuccess.jsp");
		rd.forward(request, response);
	}

}
