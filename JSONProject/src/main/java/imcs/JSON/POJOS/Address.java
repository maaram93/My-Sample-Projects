package imcs.JSON.POJOS;

public class Address {

	private AddressType addressType;
	private String street;
	private int aptno;

	public Address() {
		super();
	}

	public Address(AddressType addressType, String street, int aptno) {
		super();
		this.addressType = addressType;
		this.street = street;
		this.aptno = aptno;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getAptno() {
		return aptno;
	}

	public void setAptno(int aptno) {
		this.aptno = aptno;
	}

	@Override
	public String toString() {
		return "Address [addressType=" + addressType + ", street=" + street + ", aptno=" + aptno + "]";
	}

}
