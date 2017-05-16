package imcs.JSON.POJOS;

import java.util.List;

public class Student {
	
	protected int id;
    protected String name;
    protected List<Address> address;
    protected Marks marks;
    
    
	public Student() {
		super();
	}


	public Student(int id, String name, List<Address> address, Marks marks) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.marks = marks;
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


	public List<Address> getAddress() {
		return address;
	}


	public void setAddress(List<Address> address) {
		this.address = address;
	}


	public Marks getMarks() {
		return marks;
	}


	public void setMarks(Marks marks) {
		this.marks = marks;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", marks=" + marks + "]";
	}
    
    

}
