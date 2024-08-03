package l2_hibernate_mapping.many2many;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="employee-m2m")
public class Employee {

	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@ManyToMany(targetEntity = Address.class,cascade = CascadeType.ALL)
	@JoinTable(name="emp_addr_mapping",
		joinColumns = {@JoinColumn(name="address_id")},
		inverseJoinColumns ={@JoinColumn(name="emp_id")}
	)
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
