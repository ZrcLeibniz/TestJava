package zrc.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zrc.pojo.Airport;
import zrc.service.impl.AirportServiceImpl;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		String[] names = ac.getBeanDefinitionNames(); 
//		for(String string:names) {
//			System.out.println(string);
//		}
		AirportServiceImpl bean = ac.getBean("airportService", AirportServiceImpl.class);
		List<Airport> list = bean.show();
		System.out.println(list);
	}
}
