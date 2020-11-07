package zrc.servlet;
/**
 * @author rich
 * Cookie信息的校验：
 * 	判断请求中是否携带正确的Cookie信息。
 * 	如果有则校验Cookie信息是否正确。
 *  没有则请求转发给登录页面
 *  如果校验正确响应主页面给用户
 *  如果不正确则响应登录页面给用户
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
