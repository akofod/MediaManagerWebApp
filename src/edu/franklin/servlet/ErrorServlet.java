package edu.franklin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AllItemsServlet
 */
@WebServlet(urlPatterns = "/error.do")
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int badNumber = 5/0;
		request.setAttribute("number", badNumber);
        RequestDispatcher rd = 
                request.getRequestDispatcher("/itemDetail.jsp");
        rd.forward(request, response);
	}
}
