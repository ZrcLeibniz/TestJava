package zrc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zrc.pojo.Flower;
import zrc.service.FlowerService;
import zrc.service.impl.FlowerServiceImpl;

public class ShowServlet extends HttpServlet{
	private FlowerService flowerservice = new FlowerServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		List<Flower> list = flowerservice.show();
		req.setAttribute("list", list);
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
}
