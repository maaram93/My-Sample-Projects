package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import model.Employee;
import model.Gender;
import models.FlightInformation;

@Repository()
public class DAOImplementation implements DAOInterface {

	PreparedStatement pst;
	Connection con;

	public Connection connectionCon() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?useSSL=false", "root", "root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public boolean create(FlightInformation flightInformation) throws SQLException {
		con = connectionCon();
		pst = con.prepareStatement(" insert into employee (flightId,airlineId,airlineName,salary) values(?,?,?,?)");
		pst.setInt(1, flightInformation.getFlightId());
		pst.setLong(2, flightInformation.getAirlineId());
		pst.setString(3, flightInformation.getAirlineName());
		pst.setString(4, flightInformation.getOrigin());
		pst.setInt(5, flightInformation.getFlightId());

		int flag = pst.executeUpdate();

		if (flag > 0) {
			System.out.println("Employee created Successfully");
			return true;

		}
		return false;
	}

	public FlightInformation read(int id) throws SQLException {
		FlightInformation flightInformation = new FlightInformation();
		con = connectionCon();

		pst = con.prepareStatement("select id,firstname,lastname,gender,salary from employee where id=?");

		pst.setInt(1, id);

		ResultSet rs = pst.executeQuery();

		if (rs.next()) {
			flightInformation.setId(rs.getInt("id"));
			flightInformation.setFirstname(rs.getString("firstname"));
			flightInformation.setLastname(rs.getString("lastname"));
			flightInformation.setGender(Gender.valueOf(rs.getString("gender")));
			flightInformation.setSalary(rs.getDouble("salary"));

		}

		return flightInformation;

	}

	public boolean update(FlightInformation employee) throws SQLException {

		con = connectionCon();

		pst = con.prepareStatement(
				" update Employee set firstname=?,lastname=?,gender=?,salary=?  where id = ? and flag=1");
		// pst.setInt(5, employee.getId());
		pst.setString(1, employee.getFirstname());
		pst.setString(2, employee.getLastname());
		pst.setString(3, employee.getGender().toString());
		pst.setDouble(4, employee.getSalary());
		pst.setInt(5, employee.getId());

		int flag = pst.executeUpdate();

		if (flag > 0) {

			return true;
		} else {

			return false;
		}

	}

	public boolean delete(int id) throws SQLException {

		con = connectionCon();

		try {
			pst = con.prepareStatement("update Employee set flag = 0   where id=? and flag=1");

			pst.setInt(1, id);
			int rs = pst.executeUpdate();
			if (rs == 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;

	}

	public List<FlightInformation> findAll() throws SQLException {

		List<FlightInformation> employee = new ArrayList<FlightInformation>();
		con =connectionCon();

		pst = con.prepareStatement("select id,firstname,lastname,gender,salary from Employee where flag=1");

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			
			FlightInformation emp = new FlightInformation();
			emp.setId(rs.getInt("id"));
			emp.setFirstname(rs.getString("firstname"));
			emp.setLastname(rs.getString("lastname"));
			emp.setGender(Gender.valueOf(rs.getString("gender")));
			emp.setSalary(rs.getDouble("salary"));
			employee.add(emp);

		}

		return employee;
	}

}
