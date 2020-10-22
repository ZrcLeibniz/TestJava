package zrc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import zrc.pojo.Teacher;

public interface TeacherMapper {
	@Select("select * from teacher")
	List<Teacher> selAll();
	
	@Insert("insert into teacher values(default, #{name})")
	int insTeacher(Teacher teacher);
	
	@Update("update teacher set name=#{name} where id=#{id}")
	int updTeacher(Teacher teacher);
	
	@Delete("delete from teacher where id=#{id}")
	int delTeacher(Teacher teacher);
}
