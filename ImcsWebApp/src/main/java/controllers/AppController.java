package controllers;

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

import model.Employee;
import service.ServiceInterface;

@Controller
//@RequestMapping("/Employee")
public class AppController implements EmployeeControllerInterface {
	
	@Autowired
	ServiceInterface serviceInterface;
	@Autowired
	EmployeeValidator employeeValidator;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(employeeValidator);
	}
	
	@RequestMapping(value="createEmployee")
	public String createEmployee(Model model){
		model.addAttribute(new Employee());
		return "CreateEmployee";
		
	}

	
	@RequestMapping(value="createEmployee", method=RequestMethod.POST)
	public ModelAndView createEmployee(@ModelAttribute @Valid Employee employee, BindingResult result ) {
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()){
			modelAndView.setViewName("CreateEmployee");
			return modelAndView;
		}
		boolean flag= serviceInterface.createEmployee(employee);
		if(flag==true){
			modelAndView.addObject("message", "Employee Successfully Created");
			modelAndView.setViewName("index");
		}
		
		return modelAndView;	
	}
	@RequestMapping(value="viewEmployee")
	public String getid(Model model){
		model.addAttribute(new Employee());
		return "getId";
		
	}
	@RequestMapping(value="viewEmployee", method=RequestMethod.POST)
	public ModelAndView findEmployee(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		Employee employee = serviceInterface.findEmployee(id);
		if(employee==null){
			modelAndView.addObject("message", "No Employee Found");
		}
		modelAndView.addObject("employee", employee);
		return modelAndView;

		
	}
	
	@RequestMapping(value="updateEmployee")
	public String updateEmployee(Model model){
		model.addAttribute(new Employee());
		return "updateEmployee";
	}
	@RequestMapping(value="updateEmployee", method=RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute @Valid Employee employee, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()){
			modelAndView.setViewName("updateEmployee");
			return modelAndView;
		}
		boolean flag= serviceInterface.updateEmployee(employee);
		if(flag==true){
			modelAndView.addObject("message", "Employee Successfully Updated");
			modelAndView.setViewName("index");
		}
		return modelAndView;

		
	}
	
	@RequestMapping(value="deleteEmployee")
	public String deleteEmployee(Model model){
		model.addAttribute(new Employee());
		return "deleteId";
	}
	@RequestMapping(value="deleteEmployee", method=RequestMethod.POST)
	public ModelAndView deleteEmployee(@RequestParam int id) {
		ModelAndView modelAndView = new ModelAndView();
		boolean flag=serviceInterface.deleteEmployee(id);
		if(flag==true){
			modelAndView.addObject("message", "Employee Successfully deleted");
			modelAndView.setViewName("deleteEmployee");
		}
		return modelAndView;

		
	}

	public ModelAndView displayAllEmployees() {
		ModelAndView modelAndView = new ModelAndView();
		return modelAndView;

		
	}

	
	

}
