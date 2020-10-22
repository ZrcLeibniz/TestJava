package zrc.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import zrc.mapper.StudentMapper;
import zrc.mapper.TeacherMapper;
import zrc.pojo.Student;

public class test {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		TeacherMapper teachermapper = session.getMapper(TeacherMapper.class);
//		List<Teacher> list = teachermapper.selAll();
//		Teacher teacher1 = new Teacher();
//		teacher1.setId(4);
//		teacher1.setName("≤‚ ‘1");
//		teachermapper.insTeacher(teacher1);
//		teachermapper.delTeacher(teacher1);
//		session.commit();
//		for(Teacher teacher:list) {
//			System.out.println(teacher);
//		}
		StudentMapper studentmapper = session.getMapper(StudentMapper.class);
		List<Student> list = studentmapper.selAll();
		for(Student student:list) {
			System.out.println(student);
		}
	}
}
