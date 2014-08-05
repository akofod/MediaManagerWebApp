package edu.franklin.model;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import edu.franklin.dataaccess.MediaManagerAdminDAO;

public class MediaManagerContextListener implements ServletContextListener {
	
	private MediaManagerDAO data;
	private MediaManagerAdminDAO admindao;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext sc = event.getServletContext();
		String url = sc.getInitParameter("url");
		String userid = sc.getInitParameter("userid");
		String password = sc.getInitParameter("password");
		
		data = new MediaManagerDAO(url, userid, password);
		admindao = new MediaManagerAdminDAO(url, userid, password);
		
		sc.setAttribute("dao", data);
		sc.setAttribute("admindao", admindao);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		data.close();
	}

}
