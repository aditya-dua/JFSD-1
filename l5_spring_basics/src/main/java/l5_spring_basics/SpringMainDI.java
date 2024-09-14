package l5_spring_basics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMainDI {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-di.xml");
		
		Employee emp =(Employee) context.getBean("emp");
		
		System.out.println(emp);
		
		Employee emp2 =(Employee) context.getBean("emp");
		
		System.out.println(emp2);
		
		Employee emp3 =(Employee) context.getBean("emp2");
		
		System.out.println(emp3);
		
		Employee emp4 =(Employee) context.getBean("emp2");
		
		System.out.println(emp4);
		
		
		
	
	}
}
