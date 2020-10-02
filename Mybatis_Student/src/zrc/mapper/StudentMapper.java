package zrc.mapper;

import java.util.List;

import zrc.pojo.PageInfo;
import zrc.pojo.Student;

public interface StudentMapper {
	List<Student> selByPage(PageInfo pi);
	long selCountByPageInfo(PageInfo pi);
}
