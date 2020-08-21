package zrc.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import zrc.mapper.LogMapper;
import zrc.pojo.Log;

public class Test {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
//		LogMapper mapper = session.getMapper(LogMapper.class);
		session.selectList("zrc.mapper.LogMapper.selLog");
		session.close();
		SqlSession session1 = factory.openSession();
		session1.selectList("zrc.mapper.LogMapper.selLog");
		session1.close();
	}
}
