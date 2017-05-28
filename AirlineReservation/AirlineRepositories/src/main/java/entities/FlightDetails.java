package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FlightDetails")
public class FlightDetails {
	@Id
	@OneToOne
	@JoinColumn(name = "flightid")
	private int flightId;
	private String flightDepartureDate;
	private double price;
	private int availableSeats;
	public FlightDetails(int flightId, String flightDepartureDate, double price, int availableSeats) {
		super();
		this.flightId = flightId;
		this.flightDepartureDate = flightDepartureDate;
		this.price = price;
		this.availableSeats = availableSeats;
	}
	public FlightDetails() {
		super();
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFlightDepartureDate() {
		return flightDepartureDate;
	}
	public void setFlightDepartureDate(String flightDepartureDate) {
		this.flightDepartureDate = flightDepartureDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	@Override
	public String toString() {
		return "FlightDetails [flightId=" + flightId + ", flightDepartureDate=" + flightDepartureDate + ", price="
				+ price + ", availableSeats=" + availableSeats + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + availableSeats;
		result = prime * result + ((flightDepartureDate == null) ? 0 : flightDepartureDate.hashCode());
		result = prime * result + flightId;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightDetails other = (FlightDetails) obj;
		if (availableSeats != other.availableSeats)
			return false;
		if (flightDepartureDate == null) {
			if (other.flightDepartureDate != null)
				return false;
		} else if (!flightDepartureDate.equals(other.flightDepartureDate))
			return false;
		if (flightId != other.flightId)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	

}
