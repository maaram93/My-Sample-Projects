package service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import model.Employee;

public interface ServiceInterface {
	
	boolean createEmployee( Employee employee);
	
	Employee findEmployee(int id);
	
	boolean updateEmployee(Employee employee);
	
	boolean deleteEmployee(int id);

	List<Employee> findAll();

}
