package l3_hibernate_queries;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class HibernateCriteriaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration c = new Configuration();
		SessionFactory sf = c.configure("hbm.cfg.xml").buildSessionFactory();
		
		System.out.println(sf);
		
		insert(sf);
		
		findAll(sf);
		count(sf);
		
		sf.close();	
	}
	/*
	 * 
	 * 
	 * 	Create an instance of Session from the SessionFactory object
		Create an instance of CriteriaBuilder by calling the getCriteriaBuilder() method
		Create an instance of CriteriaQuery by calling the CriteriaBuilder createQuery() method
		Create an instance of Query by calling the Session createQuery() method
		Call the getResultList() method of the query object, which gives us the results
	 */
	
	public static void findAll(SessionFactory sf) {
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
		Root<Employee> root = cr.from(Employee.class);
		
		cr.select(root);
		
		Query<Employee> query = s.createQuery(cr);
		
		List<Employee> employeeList = query.getResultList();
		
		for (Iterator iterator = employeeList.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println(employee);
		}
		s.flush();
		tx.commit();
		s.close();
	}
	
	public static void count(SessionFactory sf) {
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Long> cr = cb.createQuery(Long.class);
		Root<Employee> root = cr.from(Employee.class);
		
		cr.select(cb.count(root));
		
		Query<Long> query = s.createQuery(cr);
		
		List<Long> count = query.getResultList();
		
		System.out.println(count);
		
		s.flush();
		tx.commit();
		s.close();
	}

	
	
	public static void insert(SessionFactory sf) {
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		for (int i = 0; i < 5; i++) {
			
			Address add = new Address("Line"+i, "Line2"+i,"Street"+i, "City");
			
			Employee e = new Employee("Name"+i,1000,add);
			add.setEmployee(e);
			e.setAddress(add);
			s.save(add);
			
		}	
		
		s.flush();
		tx.commit();
		s.close();
	}

}
