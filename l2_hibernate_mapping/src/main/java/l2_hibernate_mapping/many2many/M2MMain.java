package l2_hibernate_mapping.many2many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class M2MMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration c = new Configuration();
		
		SessionFactory sf = c.configure("hbm-m2m.cfg.xml").buildSessionFactory();
		
		System.out.println(sf);
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		Employee e = new Employee("ABC","abc@emp.com");
		Employee e1 = new Employee("ABC - 2","abc@emp.com");
		
		Address add1 = new Address("1", "Street", "City");
		Address add2 = new Address("2", "Street", "City");
		Address add3 = new Address("3", "Street", "City");
		Address add4 = new Address("4", "Street", "City");
		
		
		Set<Address> addressSet = new HashSet<>();
		addressSet.add(add1);
		addressSet.add(add2);
		
		Set<Address> addressSet2 = new HashSet<>();
		addressSet.add(add3);
		addressSet.add(add4);
		
		e.setAddresses(addressSet);
		e1.setAddresses(addressSet2);
		
				
		

		s.save(e);
		s.save(e1);
		s.save(add1);
		s.save(add2);
		s.save(add3);
		s.save(add4);
		
		
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
