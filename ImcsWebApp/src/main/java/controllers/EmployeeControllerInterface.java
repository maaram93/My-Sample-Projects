package controllers;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.Employee;

public interface EmployeeControllerInterface {
	

	ModelAndView createEmployee(@ModelAttribute @Valid Employee employee, BindingResult result);
	
	ModelAndView findEmployee(@ModelAttribute int id);
	
	ModelAndView updateEmployee(@ModelAttribute @Valid Employee employee, BindingResult result);
	
	 ModelAndView deleteEmployee(@RequestParam int id);
	
	ModelAndView displayAllEmployees();

}
