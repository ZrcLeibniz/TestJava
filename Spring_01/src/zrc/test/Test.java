package zrc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zrc.pojo.People;
import zrc.pojo.PeopleFactory;

public class Test {
	public static void main(String[] args) {
//		People peo = new People();
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		People people = ac.getBean("peo1", People.class);
		System.out.println(people);
//		PeopleFactory factory = new PeopleFactory();
//		People people = factory.newInstance();
		
	}
}
