package zrc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import zrc.pojo.Student;

public interface StudentMapper {
	@Select("select s.id, s.name, s.tid, t.id, t.name from student s left join teacher t on s.tid=t.id")
	List<Student> selAll();
}
