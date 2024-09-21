package l6_spring_basics_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaCollectionDIMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		JavaCollectionsDI coll = (JavaCollectionsDI)context.getBean("bean1");
		
		System.out.println(coll.getAddressList());
		System.out.println(coll.getCitySet());
		System.out.println(coll.getProductMap());
	}

}
