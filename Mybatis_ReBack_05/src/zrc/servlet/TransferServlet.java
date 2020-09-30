package zrc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import zrc.pojo.Account;
import zrc.service.AccountService;
import zrc.serviceImpl.AccountServiceImpl;

public class TransferServlet extends HttpServlet{
	private AccountService service = new AccountServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Account accOut = new Account();
		accOut.setAccNo(req.getParameter("accOutAccNo")); 
		accOut.setPassword(Integer.parseInt(req.getParameter("accOutPassword")));
		accOut.setBalance(Double.parseDouble(req.getParameter("accOutBalance")));
		Account accIn = new Account();
		accIn.setAccNo(req.getParameter("accInAccNo"));
		accIn.setName(req.getParameter("accInName"));
		int index =  service.transfer(accIn, accOut);
		if(index==AccountService.SUCCESS) {
			resp.sendRedirect("/Mybatis_ReBack_05/show");
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("code", index);
			resp.sendRedirect("/Mybatis_ReBack_05/error.jsp");
		}
	}
}
