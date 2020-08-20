package zrc.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import zrc.Mapper.LogMapper;
import zrc.pojo.Log;

public class Test {
	public static void main(String[] args) throws IOException {
		
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		LogMapper logMapper = session.getMapper(LogMapper.class);
		List<Log> list = logMapper.selAll();
		List<Log> list2 = logMapper.selByAccInAccOut("111", "222");
		for(Log log:list2) {
			System.out.println(list2);
		}
		for(Log log:list) {
			System.out.println(log);
		}
		session.close();
	}
}
