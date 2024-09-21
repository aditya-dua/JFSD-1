package l6_aop_example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMainDI {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Student stu = (Student) context.getBean("student");
		
		stu.getName();
		stu.getAge();
		
		stu.printThrowException();
		
		
	
	}
}
