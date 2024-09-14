package l5_spring_basics;

public class Employee {
	
	private int id;
	private String name;
	private String phone;
	private Address address;
	
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Employee() {
		super();
		System.out.println("Constuctor Called");
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}
	public void init() {
		System.out.println("INIT Called");
	}
	public Employee(String name, String phone, Address address) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	

}
