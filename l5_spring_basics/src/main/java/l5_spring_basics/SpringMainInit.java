package l5_spring_basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMainInit {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		
		
		Employee emp3 =(Employee) context.getBean("emp2");
		
		System.out.println(emp3);
		
		Employee emp4 =(Employee) context.getBean("emp2");
		
		System.out.println(emp4);
		
		
	
	}
}
