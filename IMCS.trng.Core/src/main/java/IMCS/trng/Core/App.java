package IMCS.trng.Core;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import employeeJDBCOperations.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	
    	ApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);
    	EmployeeService es = app.getBean(EmployeeService.class);
    	List<Employee> emp = es.displayAllEmployees();
    	emp.forEach(System.out::println);

    	
    }
}
