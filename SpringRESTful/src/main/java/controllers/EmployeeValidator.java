package controllers;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import model.Employee;

@Component
public class EmployeeValidator implements Validator {

	public boolean supports(Class<?> claz) {
		return Employee.class.equals(claz);
	}

	public void validate(Object arg0, Errors errors) {
		Employee employee = (Employee) arg0;
		
		ValidationUtils.rejectIfEmpty(errors, "id", "Employee.id.error");
		ValidationUtils.rejectIfEmpty(errors, "firstname", "Employee.firstname.error");
		ValidationUtils.rejectIfEmpty(errors, "lastname", "Employee.lastname.error");
		ValidationUtils.rejectIfEmpty(errors, "gender", "Employee.gender.error");
		ValidationUtils.rejectIfEmpty(errors, "salary", "Employee.salary.error");
	}

	
}
