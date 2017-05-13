package repository;

import java.sql.SQLException;
import java.util.List;

import model.Employee;

public interface DAOInterface {
	
	 boolean create(Employee employee) throws SQLException;
	 
	 Employee read(int id) throws SQLException;
	 
	 boolean update(Employee employee) throws SQLException;
	 
	 boolean delete(int id2) throws SQLException;
	 
	 List<Employee> displayAll() throws SQLException;

}
