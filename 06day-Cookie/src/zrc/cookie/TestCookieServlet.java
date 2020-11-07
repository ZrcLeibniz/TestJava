package zrc.cookie;

/**
 * @author rich
 * Cookieѧϰ��
 * 	���ã�����˲�ͬ������֮������ݹ�������
 * 	ʹ�ã�
 * 		����Cookie����
 * 			Cookie c = new Cookie(String name,String value);
 * 		���Cookie��Ϣ���ͻ���
 * 			resp.addCookie(c);
 * ע�⣺
 * 		һ��Cookie����ֻ�ܴ洢һ�����ݡ��������ݿ��Դ������Cookie������д洢	
 * �洢��ʽ��
 * 		��ʱ�洢���洢��������������ڴ��У�������رռ�ʧЧ
 * 		��ʱ�洢��������Cookie����Ч�ڣ��洢�ڿͻ��˵�Ӳ����
 * 		Ĭ��Cookie��Ϣ�洢�ú������������Ч·����ÿ�����󶼻ḽ��
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
		// ������������ʽ
		req.setCharacterEncoding("utf-8");
		// ������Ӧ�����ʽ
		resp.setContentType("text/html;charset=utf-8");
		// ��ȡ������Ϣ
		// ����������Ϣ
		// ��Ӧ������
		// ʹ��Cookie��������������ݴ洢
		// ����Cookie����
		Cookie c = new Cookie("mouse", "thinkpad");
		Cookie c2 = new Cookie("key", "rich");
		c2.setMaxAge(24 * 60 * 60 * 3);
		c2.setPath("06day-Cookie/GetCookieServlet");
		c.setPath("06day-Cookie/GetCookieServlet");
		// ��ӦCookie��Ϣ
		resp.addCookie(c);
		resp.addCookie(c2);
		// ֱ����Ӧ
		resp.getWriter().write("Cookieѧϰ");
		// �ض���
		// ����ת��
	}

}
