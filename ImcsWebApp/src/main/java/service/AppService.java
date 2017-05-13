package service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import model.Employee;
import repository.DAOInterface;

@Service
public class AppService implements ServiceInterface {
	
	@Autowired
	DAOInterface daoInterface;

	public boolean createEmployee(Employee employee) {
		
		try {
			boolean flag = daoInterface.create(employee);
			if(flag==true)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public Employee findEmployee(int id) {
		Employee employee=null;
		try {
			employee = daoInterface.read(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
		
		
	}

	public boolean updateEmployee(Employee employee) {
		try {
			boolean flag = daoInterface.update(employee);
			if(flag==true)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
		
	}

	public boolean deleteEmployee(int id) {
		boolean flag=false;
		try {
			flag = daoInterface.delete(id);
			if(flag==true)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}

	public void displayAllEmployees() {
		// TODO Auto-generated method stub
		
	}

}
