package zrc.cookie;

/**
 * @author rich
 * Cookie的获取
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookieServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// 获取Cookie信息
		Cookie[] cks = req.getCookies();
		for (Cookie c : cks) {
			String name = c.getName();
			String value = c.getValue();
			System.out.println(name + ":" + value);
		}
	}

}
