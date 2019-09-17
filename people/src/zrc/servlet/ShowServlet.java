package zrc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zrc.pojo.People;
import zrc.service.PeopleService;
import zrc.service.impl.PeopleServiceImpl;

public class ShowServlet extends HttpServlet{
	private PeopleService peopleService = new PeopleServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		try {
			List<People> list = peopleService.show();
			req.setAttribute("list", list);
			req.getRequestDispatcher("show.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
