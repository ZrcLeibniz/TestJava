package zrc.cookie;

/**
 * @author rich
 * Cookie学习：
 * 	作用：解决了不同的请求之间的数据共享问题
 * 	使用：
 * 		创建Cookie对象
 * 			Cookie c = new Cookie(String name,String value);
 * 		添加Cookie信息给客户端
 * 			resp.addCookie(c);
 * 注意：
 * 		一个Cookie对象只能存储一条数据。多条数据可以创建多个Cookie对象进行存储	
 * 存储方式：
 * 		临时存储：存储在浏览器的运行内存中，浏览器关闭即失效
 * 		定时存储：设置了Cookie的有效期，存储在客户端的硬盘中
 * 		默认Cookie信息存储好后，如果不设置有效路径，每次请求都会附带
 * 
 * 	
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestCookieServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置请求编码格式
		req.setCharacterEncoding("utf-8");
		// 设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		// 获取请求信息
		// 处理请求信息
		// 响应处理结果
		// 使用Cookie进行浏览器的数据存储
		// 创建Cookie对象
		Cookie c = new Cookie("mouse", "thinkpad");
		Cookie c2 = new Cookie("key", "rich");
		c2.setMaxAge(24 * 60 * 60 * 3);
		c2.setPath("06day-Cookie/GetCookieServlet");
		c.setPath("06day-Cookie/GetCookieServlet");
		// 响应Cookie信息
		resp.addCookie(c);
		resp.addCookie(c2);
		// 直接响应
		resp.getWriter().write("Cookie学习");
		// 重定向
		// 请求转发
	}

}
