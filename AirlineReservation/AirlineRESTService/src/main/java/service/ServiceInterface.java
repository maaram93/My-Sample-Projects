package service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import models.FlightInformation;

public interface ServiceInterface {
	
	boolean createEmployee( FlightInformation flightInformation);
	
	FlightInformation findEmployee(int id);
	
	boolean updateEmployee(FlightInformation flightInformation);
	
	boolean deleteEmployee(int id);

	List<FlightInformation> findAll();

}
