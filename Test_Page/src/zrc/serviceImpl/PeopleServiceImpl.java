package zrc.serviceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import zrc.pojo.PageInfo;
import zrc.service.PeopleService;

public class PeopleServiceImpl implements PeopleService{
	@Override
	public PageInfo show(int pageNumber, int pageSize) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		PageInfo page = new PageInfo();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSize", pageSize);
		map.put("pageStart", pageSize*(pageNumber-1));
		page.setPageNumber(pageNumber);
		page.setPageSize(pageSize);
		long count = session.selectOne("zrc.mapper.PeopleMapper.selCount");
		page.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		page.setPeopleList(session.selectList("zrc.mapper.PeopleMapper.selByPage", map));
		return page;
	}

}
