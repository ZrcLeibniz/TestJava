package zrc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zrc.service.LogService;
import zrc.service.impl.LogServiceImpl;

public class ShowServlet extends HttpServlet{
	private LogService ls = new LogServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		int pageSize = 2;
		String pageSizeStr = req.getParameter("pageSize");
		if(pageSizeStr!=null&&!pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		int pageNumber = 1;
		String pageNumberStr = req.getParameter("pageNumber");
		if(pageNumberStr!=null&&!pageNumberStr.equals("")) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		req.setAttribute("pageinfo", ls.showPage(pageSize, pageNumber));
		req.getRequestDispatcher("log.jsp").forward(req, resp);
	}
}
