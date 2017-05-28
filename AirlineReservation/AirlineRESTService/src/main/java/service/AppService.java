package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import models.FlightInformation;
import repository.DAOInterface;

@Service
public class AppService implements ServiceInterface {

	@Autowired
	DAOInterface daoInterface;

	public boolean createEmployee(FlightInformation flightInformation) {

		try {
			boolean flag = daoInterface.create(flightInformation);
			if (flag == true)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public FlightInformation findEmployee(int id) {
		FlightInformation flightInformation = null;
		try {
			flightInformation = daoInterface.read(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flightInformation;

	}

	public boolean updateEmployee(FlightInformation flightInformation) {
		try {
			boolean flag = daoInterface.update(flightInformation);
			if (flag == true)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	public boolean deleteEmployee(int id) {
		boolean flag = false;
		try {
			flag = daoInterface.delete(id);
			if (flag == true)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}

	//@Override
	public List<FlightInformation> findAll() {

		List<FlightInformation> employee = null;
		try {
			employee = daoInterface.findAll();
			if (employee == null)
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employee;
	}

}
