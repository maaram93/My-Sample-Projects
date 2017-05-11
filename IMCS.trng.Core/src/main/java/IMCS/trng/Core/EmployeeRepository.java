package IMCS.trng.Core;

import java.sql.SQLException;
import employeeJDBCOperations.Employee;
import java.util.List;
import java.util.Map;



public interface EmployeeRepository {
	
	boolean create(Employee employee) throws SQLException;

	Employee read(int id) throws SQLException;

	boolean update(Employee employee) throws SQLException;

	boolean delete(int id2) throws SQLException;

	List<Employee> displayAll() throws SQLException;
}
