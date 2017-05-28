package models;

import java.util.Date;

public class FlightInformation {
	
	private int flightId;
	private int airlineId;
	private String airlineName;
	private String origin;
	private String destination;
	private String departureTime;
	private String arrivaltime;
	private int duation;
	private int totalseats;
	private int price;
	private int availableseats;
	private String departureDate;
	public FlightInformation(int flightId, int airlineId, String airlineName, String origin, String destination,
			String departureTime, String arrivaltime, int duation, int totalseats, int price, int availableseats,
			String departureDate) {
		super();
		this.flightId = flightId;
		this.airlineId = airlineId;
		this.airlineName = airlineName;
		this.origin = origin;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivaltime = arrivaltime;
		this.duation = duation;
		this.totalseats = totalseats;
		this.price = price;
		this.availableseats = availableseats;
		this.departureDate = departureDate;
	}
	public FlightInformation() {
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
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAvailableseats() {
		return availableseats;
	}
	public void setAvailableseats(int availableseats) {
		this.availableseats = availableseats;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	@Override
	public String toString() {
		return "FlightInformation [flightId=" + flightId + ", airlineId=" + airlineId + ", airlineName=" + airlineName
				+ ", origin=" + origin + ", destination=" + destination + ", departureTime=" + departureTime
				+ ", arrivaltime=" + arrivaltime + ", duation=" + duation + ", totalseats=" + totalseats + ", price="
				+ price + ", availableseats=" + availableseats + ", departureDate=" + departureDate + "]";
	}
	
	
}
