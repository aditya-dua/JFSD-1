package l3_hibernate_queries;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration c = new Configuration();
		SessionFactory sf = c.configure("hbm.cfg.xml").buildSessionFactory();
		
		System.out.println(sf);
		
		insert(sf);
		
		findAll(sf);
		findById(sf,2);
		paginate(sf);
		sqlFunctionSum(sf);
		findAllOrderBy(sf);
		
		//deleteEmployeeUsingSession(sf,1 );
		//deleteEmployeeUsingSession2(sf,3);
		//deleteUsingHQL(sf,2);
		
		update(sf,3);
		sf.close();	
	}
	
	public static void findAll(SessionFactory sf) {
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		Query query = s.createQuery("from Employee");
		List<Employee> employeeList = query.list();
		
		for (Iterator iterator = employeeList.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println(employee);
		}
		s.flush();
		tx.commit();
		s.close();
	}

	public static void findById(SessionFactory sf,int id) {
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		Employee emp = (Employee) s.get(Employee.class, id);
		
		System.out.println(emp);
		s.flush();
		tx.commit();
		s.close();
		
	}
	
	public static void paginate(SessionFactory sf) {
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		Query query = s.createQuery("from Employee");
		
		query.setFirstResult(2);
		query.setFetchSize(2);
		
		List<Employee> employeeList = query.list();
		
		for (Iterator iterator = employeeList.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println(employee);
		}
		s.flush();
		tx.commit();
		s.close();
		
	}
	
	public static void sqlFunctionSum(SessionFactory sf) {
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		Query query = s.createQuery("select sum(salary) from Employee");
		
		double sumSal = (Double) query.uniqueResult();
		
		System.out.println("Sum of salary of all employees is : "+sumSal);
		
		s.flush();
		tx.commit();
		s.close();
		
	}
	
	public static void findAllOrderBy(SessionFactory sf) {
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		Query query = s.createQuery("from Employee e order by e.name desc");
		List<Employee> employeeList = query.list();
		
		for (Iterator iterator = employeeList.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println(employee);
		}
		s.flush();
		tx.commit();
		s.close();
	}
	
	public static void deleteEmployeeUsingSession(SessionFactory sf, int id) {
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		Employee emp = (Employee) s.get(Employee.class, id);
		
		s.delete(emp);
		
		s.flush();
		tx.commit();
		s.close();
	}
	
	public static void deleteEmployeeUsingSession2(SessionFactory sf, int id) {
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		
		Employee emp = new Employee();
		emp.setId(id);
		
		//Employee emp = (Employee) s.get(Employee.class, id);
		
		s.delete(emp);
		
		s.flush();
		tx.commit();
		s.close();
	}
	
	public static void deleteUsingHQL(SessionFactory sf, int id) {
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		Query query = s.createQuery("delete from Employee where id > :id");
		query.setParameter("id",new Long(id));
		
		int result = query.executeUpdate();
		
		if(result>0) {
			System.out.println(result + "rows have been deleted.");
		}
		s.flush();
		tx.commit();
		s.close();
	}
	
	public static void update(SessionFactory sf, int id) {
		Session s = sf.openSession();
		
		Transaction tx = s.beginTransaction();
		Query query = s.createQuery("update Employee set name = :name where id = :id");
		
		query.setParameter("id",new Long(id));
		query.setParameter("name","Aditya Dua");
		
		int result = query.executeUpdate();
		
		if(result>0) {
			System.out.println(result + "rows have been deleted.");
		}
		
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
