package zrc.serviceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.tools.ant.types.resources.selectors.ResourceSelector;

import zrc.pojo.PageInfo;
import zrc.service.PeopleService;

public class PeopleServiceImpl implements PeopleService{

	@Override
	public PageInfo showPage(int pageSize, int pageNumber) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		PageInfo pi = new PageInfo();
		pi.setPageNumber(pageNumber);
		Map<String, Object> map = new HashMap<>();
		map.put("pageSize", pageSize);
		map.put("pageStart",pageSize*(pageNumber-1));
		pi.setPageSize(pageSize);
		pi.setList(session.selectList("zrc.mapper.PeopleMapper.selByPage", map));
		long count = session.selectOne("zrc.mapper.PeopleMapper.selCount");
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		return pi;
	}
}
