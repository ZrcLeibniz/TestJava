package zrc.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
//		Scanner input = new Scanner(System.in);
//		System.out.println("«Î ‰»Î◊™’À’À∫≈");
//		String accin = input.nextLine();
//		System.out.println("«Î ‰»Î ’øÓ’À∫≈");
//		String accout = input.nextLine();
		LogMapper logmapper = session.getMapper(LogMapper.class);
//		Log log = new Log();
//		log.setId(10);
//		log.setAccIn(accin);
//		log.setAccOut(accout);
//		int index = logmapper.upd(log);
//		System.out.println(index);
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<10000; i++) {
			list.add(i);
		}
		logmapper.ins(list);
//		list.add(1);
//		list.add(2);
//		logmapper.selIn(list);
		session.commit();
//		List<Log> list = logmapper.selByAccInAccOut(accin, accout);
//		for(Log log:list) {
//			System.out.println(list);
//		}
		session.close();
	}
}
