package l2_hibernate_mapping.one2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class O2OMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration c = new Configuration();
		SessionFactory sf = c.configure("hbm-o2o.cfg.xml").buildSessionFactory();
		
		System.out.println(sf);
		
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		Address add = new Address("1", "Street", "City", null);
		
		Employee e = new Employee("ABC","abc@emp.com",add);
		
		add.setEmployee(e);
		e.setAddress(add);
		
		s.save(add);
		
		s.flush();
		tx.commit();
		s.close();
		sf.close();
		
		
	}

}
