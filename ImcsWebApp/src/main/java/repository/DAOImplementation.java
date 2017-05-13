package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import model.Employee;
import model.Gender;

@Repository("xyz")
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

	public boolean create(Employee employee) throws SQLException {
		con = connectionCon();
		pst = con.prepareStatement(" insert into employee (firstname,lastname,gender,salary) values(?,?,?,?)");
		pst.setString(1, employee.getFirstname());
		pst.setString(2, employee.getLastname());
		pst.setString(3, employee.getGender().toString());
		pst.setDouble(4, employee.getSalary());

		int flag = pst.executeUpdate();

		if (flag > 0) {
			System.out.println("Employee created Successfully");
			return true;

		}
		return false;
	}

	public Employee read(int id) throws SQLException {
		Employee employee = new Employee();
		con = connectionCon();

		pst = con.prepareStatement("select id,firstname,lastname,gender,salary from employee where id=?");

		pst.setInt(1, id);

		ResultSet rs = pst.executeQuery();

		if (rs.next()) {
			employee.setId(rs.getInt("id"));
			employee.setFirstname(rs.getString("firstname"));
			employee.setLastname(rs.getString("lastname"));
			employee.setGender(Gender.valueOf(rs.getString("gender")));
			employee.setSalary(rs.getDouble("salary"));

		}

		return employee;

	}

	public boolean update(Employee employee) throws SQLException {

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

	public boolean delete(int id2) throws SQLException {

		con = connectionCon();

		try {
			pst = con.prepareStatement("update Employee set flag = 0   where id=? and flag=1");

			pst.setInt(1, id2);
			int rs = pst.executeUpdate();
			if (rs == 0) {
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("No Employee to delete with id  " + id2);
			return false;
		}
		return true;

	}

	public List<Employee> displayAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
