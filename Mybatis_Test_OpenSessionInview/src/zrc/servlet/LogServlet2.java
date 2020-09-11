package zrc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zrc.pojo.Log;
import zrc.service.LogService;
import zrc.service.impl.LogServiceImpl;

public class LogServlet2 extends HttpServlet{
		LogService service = new LogServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String accIn = req.getParameter("accIn");
		String accOut = req.getParameter("accOut");
		List<Log> list = service.showP(accIn, accOut);
		req.setAttribute("list", list);
		req.getRequestDispatcher("show.jsp").forward(req, resp);
	}
	
}
