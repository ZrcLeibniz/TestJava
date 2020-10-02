package zrc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zrc.pojo.PageInfo;
import zrc.service.StudentService;
import zrc.service.impl.StudentServiceImpl;

public class ShowServlet extends HttpServlet{
	private StudentService stuService = new StudentServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String sname = req.getParameter("sname");
		String tname  =req.getParameter("tname");
		String pageSize = req.getParameter("pageSize");
		String pageNumber = req.getParameter("pageNumber");
		PageInfo pi = stuService.showPage(sname, tname, pageSize, pageNumber);
		req.setAttribute("page", pi);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
