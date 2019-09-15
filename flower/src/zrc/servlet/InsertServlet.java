package zrc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zrc.pojo.Flower;
import zrc.service.FlowerService;
import zrc.service.impl.FlowerServiceImpl;

public class InsertServlet extends HttpServlet{
	private FlowerService flowerservice= new FlowerServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset='utf-8'");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String production = req.getParameter("production");
		Flower flower = new Flower();
		flower.setName(name);
		flower.setPrice(Double.parseDouble(price));
		flower.setProduction(production);
		int index = flowerservice.add(flower);
		if(index>0) {
			resp.sendRedirect("ShowServlet");
		}else {
			resp.sendRedirect("add.jsp");
		}
	}
}
