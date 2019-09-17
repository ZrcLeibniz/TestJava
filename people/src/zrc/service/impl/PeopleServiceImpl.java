package zrc.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import zrc.pojo.People;
import zrc.service.PeopleService;

public class PeopleServiceImpl implements PeopleService{

	@Override
	public List<People> show() throws Exception {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		List<People> list = session.selectList("zrc.mapper.PeopleMapper.selAll");
		session.close();
		return list;
	}

}
