package zrc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zrc.pojo.PageInfo;
import zrc.service.LogService;
import zrc.serviceImpl.LogServiceImpl;

public class ShowServlet extends HttpServlet{
	LogService logservice = new LogServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String pageSizeStr = req.getParameter("pageSize");
		int pageSize = 2;
		if(pageSizeStr!=null&&!pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		String pageNumberStr = req.getParameter("pageNumber");
		int pageNumber = 1;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")) {
			pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
		}
		PageInfo pi = logservice.showPage(pageSize, pageNumber);
		req.setAttribute("PageInfo", pi);
		req.getRequestDispatcher("log.jsp").forward(req, resp);
	}
	
}
