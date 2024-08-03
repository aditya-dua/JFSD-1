package l2_hibernate_mapping.one2one;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="address-o2o")
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
	
	@OneToOne(mappedBy = "address")
	@Cascade(value=CascadeType.SAVE_UPDATE)
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
