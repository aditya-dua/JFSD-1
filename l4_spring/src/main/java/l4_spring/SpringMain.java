package l4_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Message msg = (Message) context.getBean("bean1");
		
		msg.setText("My new Message");
		
		System.out.println(msg.getText());
	}
}
