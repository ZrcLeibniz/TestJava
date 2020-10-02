package zrc.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import zrc.mapper.StudentMapper;
import zrc.mapper.TeacherMapper;
import zrc.pojo.PageInfo;
import zrc.pojo.Student;
import zrc.service.StudentService;
import zrc.util.MybatisUtil;

public class StudentServiceImpl implements StudentService{

	@Override
	public PageInfo showPage(String sname, String tname, String pageSizeStr, String pageNumberStr) {
		int pageSize = 2;
		if(pageSizeStr!=null&&!pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		int pageNumber = 1;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		SqlSession session = MybatisUtil.getSqlSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		PageInfo pi = new PageInfo();
		pi.setPageSize(pageSize);
		pi.setPageNumber(pageNumber);
		pi.setPageStart(pageSize*(pageNumber-1));
		pi.setSname(sname);
		pi.setTname(tname);
		List<Student> list = studentMapper.selByPage(pi);
		TeacherMapper teachermapper = session.getMapper(TeacherMapper.class);
		for(Student student:list) {
			student.setTeacher(teachermapper.selById(student.getTid()));
		}
		pi.setList(list);
		long count = studentMapper.selCountByPageInfo(pi);
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		return pi;
	}

}
