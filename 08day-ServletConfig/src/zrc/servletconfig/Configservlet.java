package zrc.servletconfig;
/**
 * @author rich
 * servletconfig�����ѧϰ
 * ���⣺����û�ȡ��web.xml�и�ÿ��servlet�������õ�����
 * �����servletconfig����
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
		//��ȡservletconfig����
		ServletConfig sc = this.getServletConfig(); 
		//��ȡweb.xml�е���������
		String str = sc.getInitParameter("config");
		System.out.println("Configservlet.service()"+str);
	}
}
