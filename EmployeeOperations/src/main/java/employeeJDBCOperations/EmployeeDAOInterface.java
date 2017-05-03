package employeeJDBCOperations;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface EmployeeDAOInterface {
	
	void create(Employee employee) throws SQLException;

	Employee read(int id) throws SQLException;

	boolean update(Employee employee) throws SQLException;

	boolean delete(int id2) throws SQLException;
	
	double hra(int id3) throws SQLException;

	double grossSalary(int id4) throws SQLException;
	
	List<Employee> displayAll() throws SQLException;

	Map<Double,Integer> DisplayEmployeeSalaryWiseCount();
	
	List<Employee> displayUniqueEmployeeNames();
	
	List<Employee> sortEmployeeByLastname();
	
	List<Employee> sortEmployeeBySalary();
}
