package employeeArrayOperation;

public class PhoneNumber {
	
	String areacode;
	String number;
	Employee owner;
	String type;
	int id;
	
	
	public PhoneNumber() {
		
	}
	
	public PhoneNumber(String areacode, String number, Employee owner, String type, int id) {
		super();
		this.areacode = areacode;
		this.number = number;
		this.owner = owner;
		this.type = type;
		this.id = id;
	}
	public String getAreacode() {
		return areacode;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Employee getOwner() {
		return owner;
	}
	public void setOwner(Employee owner) {
		this.owner = owner;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
