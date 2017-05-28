package repository;

import java.sql.SQLException;
import java.util.Date;

import models.FlightInformation;

public interface DAOInterface {
	
	 FlightInformation read(int id, Date departureDate) throws SQLException;
	 
	 boolean update(FlightInformation flightInformation) throws SQLException;
	 
}
