package controllers;

import java.sql.SQLException;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import models.FlightInformation;
import repository.DAOInterface;

@Controller
public class AppController implements EmployeeControllerInterface {
	@Autowired
	DAOInterface daoInterface;
	
	@RequestMapping(value="viewEmployee")
	public String getid(Model model){
		model.addAttribute(new FlightInformation());
		return "findFlights";
		
	}

	@RequestMapping(value = "viewEmployee", method = RequestMethod.POST)
	public ModelAndView findFlights(@RequestParam int id, Date departureDate) {
		ModelAndView modelAndView = new ModelAndView();
		FlightInformation flightInformation = null;
		try {
			flightInformation = daoInterface.read(id,departureDate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flightInformation == null) {
			modelAndView.addObject("message", "No Employee Found");
		}
		modelAndView.addObject("flightInformation", flightInformation);
		return modelAndView;

	}

	@RequestMapping(value = "updateEmployee")
	public String updateEmployee(Model model) {
		model.addAttribute(new FlightInformation());
		return "findFlights2";
	}

	@RequestMapping(value = "updateEmployee", method = RequestMethod.POST)
	public ModelAndView updateFlight(@ModelAttribute  FlightInformation flightInformation, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.setViewName("updateEmployee");
			return modelAndView;
		}
		boolean flag = false;
		try {
			flag = daoInterface.update(flightInformation);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag == true) {
			modelAndView.addObject("message", "Employee Successfully Updated");
			modelAndView.setViewName("index");
		}
		return modelAndView;

	}

}
