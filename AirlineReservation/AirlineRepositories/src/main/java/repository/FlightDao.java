package repository;

import java.sql.SQLException;
import entities.Flight;
public interface FlightDao {
	
	boolean create(Flight flight) throws SQLException;

	Flight read(int id) throws SQLException;

	boolean update(Flight flight) throws SQLException;

	boolean delete(int id2) throws SQLException;

}
