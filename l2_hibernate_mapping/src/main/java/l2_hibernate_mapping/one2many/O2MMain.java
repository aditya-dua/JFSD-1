package l2_hibernate_mapping.one2many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class O2MMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration c = new Configuration();
		
		SessionFactory sf = c.configure("hbm-o2m.cfg.xml").buildSessionFactory();
		
		System.out.println(sf);
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		Employee e = new Employee("ABC","abc@emp.com");
		
		Address add1 = new Address("1", "Street", "City",e);
		Address add2 = new Address("2", "Street", "City",e);
		
		
		Set<Address> addressSet = new HashSet<>();
		addressSet.add(add1);
		addressSet.add(add2);
		
		e.setAddresses(addressSet);
				
		
		System.out.println(e);
	
		s.save(e);
		s.save(add1);
		s.save(add2);
		
		
		s.flush();
		tx.commit();
		s.close();
		sf.close();
		
		
	}
	/*
	 * 
	 * To Do:
	 * Add a logic to update the employee details
	 * Delete an employee
	 * update an employee by adding address to it.
	 */

}
