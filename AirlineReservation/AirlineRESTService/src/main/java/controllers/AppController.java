package controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import models.FlightInformation;
import service.ServiceInterface;

@RestController
@RequestMapping("/Employee")
public class AppController implements EmployeeControllerInterface {

	@Autowired
	ServiceInterface serviceInterface;

	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<FlightInformation> getEmployee() {
		return serviceInterface.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { "application/json" })
	public ResponseEntity<?> createEmployee(@RequestBody FlightInformation flightInformation) {
		boolean newInstance = false;
		try {
			newInstance = serviceInterface.createEmployee(flightInformation);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(newInstance, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findEmployee(@PathVariable int id) {
		FlightInformation flightInformation = serviceInterface.findEmployee(id);
		if (flightInformation == null) {
			return ResponseEntity.noContent().build();
		} else {
			return new ResponseEntity<>(flightInformation, HttpStatus.OK);
		}

	}

	@RequestMapping(method = RequestMethod.PUT, consumes = { "application/json" })
	public ResponseEntity<?> updateEmployee(@RequestBody FlightInformation flightInformation) {
		try {
			boolean flag = serviceInterface.updateEmployee(flightInformation);

			if (flag == false) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>(flag, HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
		boolean flag = serviceInterface.deleteEmployee(id);
		if (flag == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}
	}

}
