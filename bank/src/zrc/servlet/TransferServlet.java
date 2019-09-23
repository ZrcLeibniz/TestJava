package zrc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import zrc.pojo.Account;
import zrc.service.AccountService;
import zrc.service.impl.AccountServiceImpl;

public class TransferServlet extends HttpServlet{
	private AccountService accService = new AccountServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Account accOut = new Account();
		accOut.setAccno(req.getParameter("accOutAccNo"));
		accOut.setPassword(Integer.parseInt(req.getParameter("accOutPassword")));
		accOut.setBalance(Double.parseDouble(req.getParameter("accOutBalance")));
		Account accIn = new Account();
		accIn.setAccno(req.getParameter("accInAccNo"));
		accIn.setName(req.getParameter("accInName"));
		int index2 = accService.transfer(accIn, accOut);
		if(index2==AccountService.SUCCESS) {
			resp.sendRedirect("log.jsp");
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("code",index2);
			resp.sendRedirect("error.jsp");
		}
	}
}
