package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Flight")
public class Flight {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int flightId;
	private int airlineId;
	private String origin;
	private String destination;
	private String departureTime;
	private String arrivaltime;
	private int duation;
	private int totalseats;
	public Flight(int flightId, int airlineId, String origin, String destination, String departureTime,
			String arrivaltime, int duation, int totalseats) {
		super();
		this.flightId = flightId;
		this.airlineId = airlineId;
		this.origin = origin;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivaltime = arrivaltime;
		this.duation = duation;
		this.totalseats = totalseats;
	}
	public Flight() {
		super();
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public int getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivaltime() {
		return arrivaltime;
	}
	public void setArrivaltime(String arrivaltime) {
		this.arrivaltime = arrivaltime;
	}
	public int getDuation() {
		return duation;
	}
	public void setDuation(int duation) {
		this.duation = duation;
	}
	public int getTotalseats() {
		return totalseats;
	}
	public void setTotalseats(int totalseats) {
		this.totalseats = totalseats;
	}
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", airlineId=" + airlineId + ", origin=" + origin + ", destination="
				+ destination + ", departureTime=" + departureTime + ", arrivaltime=" + arrivaltime + ", duation="
				+ duation + ", totalseats=" + totalseats + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + airlineId;
		result = prime * result + ((arrivaltime == null) ? 0 : arrivaltime.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + duation;
		result = prime * result + flightId;
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + totalseats;
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
		Flight other = (Flight) obj;
		if (airlineId != other.airlineId)
			return false;
		if (arrivaltime == null) {
			if (other.arrivaltime != null)
				return false;
		} else if (!arrivaltime.equals(other.arrivaltime))
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (duation != other.duation)
			return false;
		if (flightId != other.flightId)
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (totalseats != other.totalseats)
			return false;
		return true;
	}

}
