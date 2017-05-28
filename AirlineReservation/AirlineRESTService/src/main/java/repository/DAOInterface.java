package repository;

import java.sql.SQLException;
import java.util.List;
import models.FlightInformation;

public interface DAOInterface {
	
	 boolean create(FlightInformation flightInformation) throws SQLException;
	 
	 FlightInformation read(int id) throws SQLException;
	 
	 boolean update(FlightInformation flightInformation) throws SQLException;
	 
	 boolean delete(int id2) throws SQLException;
	 
	 List<FlightInformation> findAll() throws SQLException;

}
