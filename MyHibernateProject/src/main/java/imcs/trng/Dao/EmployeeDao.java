package imcs.trng.Dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import imcs.trng.beans.SalaryCount;
import trng.imcs.hibernate.pojo.Employee;
public interface EmployeeDao {
	
	boolean create(Employee employee) throws SQLException;

	Employee read(int id) throws SQLException;

	boolean update(Employee employee) throws SQLException;

	boolean delete(int id2) throws SQLException;
	
	double hra(int id3) throws SQLException;

	double grossSalary(int id4) throws SQLException;
	
	List<Employee> displayAll() throws SQLException;

	List<SalaryCount> DisplayEmployeeSalaryWiseCount();
	
	List<Employee> displayUniqueEmployeeNames();
	
	List<Employee> sortEmployeeByLastname();
	
	List<Employee> sortEmployeeBySalary();

	

}
