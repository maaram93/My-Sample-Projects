package employeeCollectionOperation;

public class Address {
	
	String city;
	String country;
	int id;
	String postalcode;
	String province;
	String street;
	long version;
	
	public Address() {
		
	}
	
	
	public Address(String city, String country, int id, String postalcode, String province, String street,
			long version) {
		super();
		this.city = city;
		this.country = country;
		this.id = id;
		this.postalcode = postalcode;
		this.province = province;
		this.street = street;
		this.version = version;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", country=" + country + ", id=" + id + ", postalcode=" + postalcode
				+ ", province=" + province + ", street=" + street + ", version=" + version + "]";
	}


	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}

}
