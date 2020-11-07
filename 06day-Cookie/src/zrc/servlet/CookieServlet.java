package zrc.servlet;
/**
 * @author rich
 * Cookie��Ϣ��У�飺
 * 	�ж��������Ƿ�Я����ȷ��Cookie��Ϣ��
 * 	�������У��Cookie��Ϣ�Ƿ���ȷ��
 *  û��������ת������¼ҳ��
 *  ���У����ȷ��Ӧ��ҳ����û�
 *  �������ȷ����Ӧ��¼ҳ����û�
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

public class CookieServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Cookie[] cks = req.getCookies();
		if(cks!=null) {
			String uid = "";
			for(Cookie c : cks) {
				if("uid".equals(c.getName())) {
					uid = c.getValue();
				}
			}
			if("".equals(uid)) {
				req.getRequestDispatcher("PageServlet").forward(req, resp);
				return;
			}else {
				LoginService ls = new LoginServiceImpl();
				User u = ls.CheckLoginservice(uid);
				if(u!=null) {
					resp.sendRedirect("MyServlet");
					return;
				}else {
					req.getRequestDispatcher("PageServlet").forward(req, resp);
					return;
				}
			}
		}else {
			req.getRequestDispatcher("PageServlet").forward(req, resp);
			return;
		}
	}

}
