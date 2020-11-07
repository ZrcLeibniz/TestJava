package zrc.servlet;

/**
 * @author rich
 * ������������Ľ����
 * 	1.ʹ��String�������±���
 * 		String uname = req.getParameter("uname");
 *		uname = new String(uname.getBytes("iso8859-1"),"utf-8"); 	
 *	2.Get��ʽ����
 *		��Service������ʹ�ã�req.setCharacterEncoding("utf-8");
 *		��tomcat������Ŀ¼�µ�conf�ļ����ҵ�sever.xml�ļ����򿪽�����������
 *		useBodyEncodeingForURI="true" ��8843����д�⴮����
 *	3.Post��ʽ��
 *		��Service������ʹ��req.setCharacterEncoding("utf-8");
 * ����ת����
 * 	���ã�ʵ�ֶ��Servlet��������������������������࣬��Servlet��ְ�������ȷ��
 *  ʹ�ã�req.getRequestDispatcher("Ҫת����Servlet��url-pattern").forward(req,resp);
 *  �ص㣺һ�������������ַ����Ϣ���ı�
 *  ע�⣺����ת����ֱ��return��������
 * request��������һ�������е�����Servlet����
 * �ض���ʹ������ת������ɱ������ظ��ύ��������Ҫʹ���ض���
 * 	ע�⣺���ʹ���ض�����ô�����������󣬾��޷�ʹ��request�����������в�ͬServlet��������ת
 * 	ʹ�ã�resp.sendRedirect(Location);
 * 
 *			
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zrc.pojo.User;
import zrc.service.LoginService;
import zrc.service.impl.LoginServiceImpl;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ������������ʽ
		req.setCharacterEncoding("utf-8");
		// ������Ӧ�����ʽ
		resp.setContentType("text/html;charset=utf-8");
		// ��ȡ������Ϣ
		String uname = req.getParameter("uname");
		// uname = new String(uname.getBytes("iso8859-1"),"utf-8");
		String pwd = req.getParameter("pwd");
		// System.out.println(uname+pwd);
		// ����������Ϣ
		// ��ȡҵ������
		LoginService ls = new LoginServiceImpl();
		User u = ls.checkLoginService(uname, pwd);
		// System.out.println(u);
		// ��Ӧ������
		if (u != null) {
			// resp.getWriter().write("��¼�ɹ�");
			// req.setAttribute("name", u.getUname());
			// req.getRequestDispatcher("MyServlet").forward(req, resp);
			Cookie c = new Cookie("uid",u.getUid()+"");
			c.setMaxAge(3*24*60*60);
			c.setPath("/06day-Cookie/CookieServlet");
			resp.addCookie(c);
			resp.sendRedirect("MyServlet");
			// return;
		} else {
			// resp.getWriter().write("��¼ʧ��");
			// ʹ��request����ʵ�ֲ�ͬServlet��������ת
			req.setAttribute("str", "�û������������");
			req.getRequestDispatcher("PageServlet").forward(req, resp);
			return;
			// ��д��Ҫת����Servletʱ��Ӧ��д��xml�и���Servlet�����õ�url-pattern
		}
	}

}
