package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Repository;
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

	@Override
	public FlightInformation read(int id, Date departureDate) throws SQLException {

		FlightInformation flightInformation = new FlightInformation(1, 2, "southwest", "dallas", "missouri", "12:00",
				"3:00", 3, 100, 1000, 10, "2017-05-09");
		if (id == 0) {
			return null;
		}
		return flightInformation;
	}

	@Override
	public boolean update(FlightInformation flightInformation) throws SQLException {

		con = connectionCon();

		pst = con.prepareStatement(
				" update Employee set flightId=?,airlineId=?,airlineName=?,origin=? where id = ? and flag=1");
		
		pst.setInt(1, flightInformation.getFlightId());
		pst.setLong(2, flightInformation.getAirlineId());
		pst.setString(3, flightInformation.getAirlineName());
		pst.setString(4, flightInformation.getOrigin());
		pst.setInt(5, flightInformation.getFlightId());

		int flag = pst.executeUpdate();

		if (flag > 0) {

			return true;
		} else {

			return false;
		}
	}

}
