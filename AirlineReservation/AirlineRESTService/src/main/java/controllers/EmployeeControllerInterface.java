package controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import models.FlightInformation;

public interface EmployeeControllerInterface {

	public ResponseEntity<?> createEmployee(@RequestBody FlightInformation flightInformation);

	public ResponseEntity<?> findEmployee(@PathVariable int flightId);

	public ResponseEntity<?> updateEmployee(@RequestBody FlightInformation flightInformation);

	public ResponseEntity<?> deleteEmployee(@PathVariable int flightId);

	public List<FlightInformation> getEmployee();

}
