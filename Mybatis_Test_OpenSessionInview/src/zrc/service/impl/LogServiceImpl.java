package zrc.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import zrc.mapper.LogMapper;
import zrc.pojo.Log;
import zrc.service.LogService;
import zrc.util.MybatisUtil;

public class LogServiceImpl implements LogService{

	@Override
	public List<Log> show() throws IOException {
//		InputStream is = Resources.getResourceAsStream("mybatis.xml");
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//		SqlSession session = factory.openSession();
		SqlSession session = MybatisUtil.getSqlSession();
		LogMapper mapper = session.getMapper(LogMapper.class);
		List<Log> list = mapper.selAll();
		return list;
	}

	@Override
	public List<Log> showP(String accIn, String accOut) throws IOException {
		SqlSession session = MybatisUtil.getSqlSession();
		LogMapper mapper = session.getMapper(LogMapper.class);
		return mapper.selLog(accIn, accOut);
	}

}
