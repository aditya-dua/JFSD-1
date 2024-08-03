package l2_hibernate_mapping.one2many;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="employee-o2m")
public class Employee {

	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy = "employee")
	private Set<Address> addresses;

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		return ("Employee" + this.getAddresses().size());
	}

	public Employee(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
