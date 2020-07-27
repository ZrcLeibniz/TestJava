package zrc.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import zrc.service.AirportService;
import zrc.service.impl.AirportServiceImpl;

public class AirportServlet extends HttpServlet{
	private AirportService airportService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		WebApplicationContext ac =  WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		airportService = ac.getBean("airportServiceImpl", AirportServiceImpl.class);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setAttribute("list", airportService.show());
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
}
