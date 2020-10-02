package zrc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.ibatis.session.SqlSession;

import zrc.util.MybatisUtil;

public class OpenSessionInview implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain filterchain)
			throws IOException, ServletException {
			SqlSession session = MybatisUtil.getSqlSession();
			try {
				filterchain.doFilter(servletrequest, servletresponse);
				session.commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				session.rollback();
				e.printStackTrace();
			}finally {
				MybatisUtil.closeSession();
			}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
