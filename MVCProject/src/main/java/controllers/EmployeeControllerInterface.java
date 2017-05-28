package controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import models.FlightInformation;

public interface EmployeeControllerInterface {
	

	
	ModelAndView findFlights(@RequestParam int id, Date departureDate);
	
	 ModelAndView updateFlight(@ModelAttribute  FlightInformation flightInformation, BindingResult result);
	
	

}
