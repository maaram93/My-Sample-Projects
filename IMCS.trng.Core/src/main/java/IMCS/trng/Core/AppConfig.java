package IMCS.trng.Core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import employeeJDBCOperations.Employee;

@Configuration
@ComponentScan(basePackages={"IMCS.trng.Core"})
public class AppConfig {
	
	public Employee getEmployee(){
		return new Employee();
	}

}
