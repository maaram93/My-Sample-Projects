package IMCS.trng.Core;

import static employeeJDBCOperations.EmployeeUtil.*;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import employeeJDBCOperations.Employee;
import employeeJDBCOperations.EmployeeDAOImplementation;
import employeeJDBCOperations.EmployeeDAOInterface;


@Service
public class EmployeeService {

	@Autowired
	@Qualifier("xyz")
	EmployeeRepository Eap;

	public List<Employee> displayAllEmployees() {
		
		List<Employee> emp=null;
		try {
			emp = Eap.displayAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
		
	}

	public void deleteEmployee(int id2) {
		
		boolean flag;
		try {
			flag = Eap.delete(id2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateEmploy() {
		Employee employee = updateEmployDetails();
		boolean flag;
		try {
			flag = Eap.update(employee);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void readEmploy(int id) {
		Employee employee = null;
		try {
			employee = Eap.read(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void createEmploy() {
		Employee employee = createEmployDetails();
		try {
			Eap.create(employee);
		} catch (NullPointerException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
