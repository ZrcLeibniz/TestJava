package zrc.servletconfig;
/**
 * @author rich
 * servletconfig对象的学习
 * 问题：如何让获取在web.xml中给每个servlet单独配置的数据
 * 解决：servletconfig对象
 */
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Configservlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		//获取servletconfig对象
		ServletConfig sc = this.getServletConfig(); 
		//获取web.xml中的配置数据
		String str = sc.getInitParameter("config");
		System.out.println("Configservlet.service()"+str);
	}
}
