package l2_hibernate_mapping.one2many;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="address-o2m")
public class Address {
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	@Column(name="houseNumber")
	private String houseNumber;
	@Column(name="streetName")
	private String streetName;
	@Column(name="city")
	private String city;
	
	@ManyToOne
	@JoinColumn(name="employee_id",nullable = false)
	private Employee employee;
	
	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	@Override
	public String toString() {
		return "Address [id=" + id + ", houseNumber=" + houseNumber + ", streetName=" + streetName + ", city=" + city
				+ ", employee=" + employee + "]";
	}

	

	public Address(String houseNumber, String streetName, String city, Employee employee) {
		super();
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.city = city;
		this.employee = employee;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
