package controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import model.Employee;

public interface EmployeeControllerInterface {

	public ResponseEntity<?> createEmployee(@RequestBody Employee employee);

	public ResponseEntity<?> findEmployee(@PathVariable int id);

	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee);

	public ResponseEntity<?> deleteEmployee(@PathVariable int id);

	public List<Employee> getEmployee();

}
