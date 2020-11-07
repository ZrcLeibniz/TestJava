package zrc.servlet;

/**
 * @author rich
 * 请求乱码问题的解决：
 * 	1.使用String进行重新编码
 * 		String uname = req.getParameter("uname");
 *		uname = new String(uname.getBytes("iso8859-1"),"utf-8"); 	
 *	2.Get方式请求：
 *		在Service方法中使用：req.setCharacterEncoding("utf-8");
 *		在tomcat服务器目录下的conf文件下找到sever.xml文件，打开进行如下配置
 *		useBodyEncodeingForURI="true" 在8843后面写这串东西
 *	3.Post方式：
 *		在Service方法中使用req.setCharacterEncoding("utf-8");
 * 请求转发：
 * 	作用：实现多个Servlet联动操作请求，这样避免代码冗余，让Servlet的职责更加明确。
 *  使用：req.getRequestDispatcher("要转发的Servlet的url-pattern").forward(req,resp);
 *  特点：一次请求，浏览器地址栏信息不改变
 *  注意：请求转发后直接return结束即可
 * request的作用域：一次请求中的所有Servlet共享
 * 重定向：使用请求转发会造成表单数据重复提交，所以需要使用重定向
 * 	注意：如果使用重定向那么就是两个请求，就无法使用request作用域来进行不同Servlet的数据流转
 * 	使用：resp.sendRedirect(Location);
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
		// 设置请求编码格式
		req.setCharacterEncoding("utf-8");
		// 设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		// 获取请求信息
		String uname = req.getParameter("uname");
		// uname = new String(uname.getBytes("iso8859-1"),"utf-8");
		String pwd = req.getParameter("pwd");
		// System.out.println(uname+pwd);
		// 处理请求信息
		// 获取业务层对象
		LoginService ls = new LoginServiceImpl();
		User u = ls.checkLoginService(uname, pwd);
		// System.out.println(u);
		// 响应处理结果
		if (u != null) {
			// resp.getWriter().write("登录成功");
			// req.setAttribute("name", u.getUname());
			// req.getRequestDispatcher("MyServlet").forward(req, resp);
			Cookie c = new Cookie("uid",u.getUid()+"");
			c.setMaxAge(3*24*60*60);
			c.setPath("/06day-Cookie/CookieServlet");
			resp.addCookie(c);
			resp.sendRedirect("MyServlet");
			// return;
		} else {
			// resp.getWriter().write("登录失败");
			// 使用request对象实现不同Servlet的数据流转
			req.setAttribute("str", "用户名或密码错误");
			req.getRequestDispatcher("PageServlet").forward(req, resp);
			return;
			// 在写需要转发的Servlet时，应该写在xml中给该Servlet所配置的url-pattern
		}
	}

}
