package employeeJDBCOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class EmployeeDAOImplementation implements EmployeeDAOInterface {

	EmployeeDAOImplementation Edi;
	PreparedStatement pst;
	Connection con;

	public Connection connectionCon() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample?useSSL=false", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		return con;
	}

	@Override
	public void create(Employee employee) throws SQLException {

		Edi = new EmployeeDAOImplementation();
		con = Edi.connectionCon();

		pst = con.prepareStatement(" insert into employee (firstname,lastname,gender,salary) values(?,?,?,?)");

		pst.setString(1, employee.getFirstname());
		pst.setString(2, employee.getLastname());
		pst.setString(3, employee.getGender().toString());
		pst.setDouble(4, employee.getSalary());

		int flag = pst.executeUpdate();

		if (flag > 0) {
			System.out.println("Employee created Successfully");

		}

	}

	@Override
	public Employee read(int id) throws SQLException {

		Employee employee = new Employee();

		Edi = new EmployeeDAOImplementation();
		con = Edi.connectionCon();

		pst = con.prepareStatement("select id,firstname,lastname,gender,salary from employee where id=? and flag = 1");

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

	@Override
	public boolean update(Employee employee) throws SQLException {

		Edi = new EmployeeDAOImplementation();
		con = Edi.connectionCon();

		pst = con.prepareStatement(" update Employee set firstname=?,lastname=?,gender=?,salary=?  where id = ? and flag=1");
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

	@Override
	public boolean delete(int id2) throws SQLException {

		Edi = new EmployeeDAOImplementation();
		con = Edi.connectionCon();

		try {
			pst = con.prepareStatement("update Employee set flag = 0   where id=? and flag=1");
			
			pst.setInt(1, id2);
			int rs=pst.executeUpdate();
			if(rs==0){
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("No Employee to delete with id  " + id2);
			return false;
		}

		//System.out.println("Employee deleted Successfully");
		return true;
	}

	@Override
	public double hra(int id3) throws SQLException {

		Edi = new EmployeeDAOImplementation();
		con = Edi.connectionCon();

		pst = con.prepareStatement("select salary from Employee where id=? and flag=1");

		pst.setInt(1, id3);
		ResultSet rs = pst.executeQuery();

		if ((rs.next()) == true) {
			return rs.getDouble("salary");
		} else {

			return 0;
		}

	}

	@Override
	public double grossSalary(int id4) throws SQLException {

		Edi = new EmployeeDAOImplementation();
		con = Edi.connectionCon();

		pst = con.prepareStatement("select salary from Employee where id=? and flag=1");

		pst.setInt(1, id4);
		ResultSet rs = pst.executeQuery();

		if ((rs.next()) == true) {
			return rs.getDouble("salary");
		} else {

			return 0;
		}
	}

	@Override
	public List<Employee> displayAll() throws SQLException {

		

		List<Employee> employee = new ArrayList<Employee>();

		Edi = new EmployeeDAOImplementation();
		con = Edi.connectionCon();

		pst = con.prepareStatement("select id,firstname,lastname,gender,salary from Employee where flag=1");

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			
			Employee emp = new Employee();
			emp.setId(rs.getInt("id"));
			emp.setFirstname(rs.getString("firstname"));
			emp.setLastname(rs.getString("lastname"));
			emp.setGender(Gender.valueOf(rs.getString("gender")));
			emp.setSalary(rs.getDouble("salary"));
			employee.add(emp);

		}

		/*for (Employee emp1 : employee) {
			System.out.println(emp1);
		}*/
		return employee;

	}
	
	public Map<Double,Integer> DisplayEmployeeSalaryWiseCount() {
		
		Edi = new EmployeeDAOImplementation();
		con = Edi.connectionCon();

		Map<Double,Integer> map = new HashMap<Double,Integer>();
		
		try {
			pst = con.prepareStatement("select salary,count(salary) from employee where flag=1 group by salary ");
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				
				map.put(rs.getDouble("salary"), rs.getInt("count(salary)"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
		
	}
	
	public List<Employee> displayUniqueEmployeeNames(){
		
		
		List<Employee> employee = new ArrayList<Employee>();
		Edi = new EmployeeDAOImplementation();
		con = Edi.connectionCon();
		try {
			pst = con.prepareStatement("select distinct(lastname),id,firstname,gender,salary from Employee where flag=1 group by lastname");
		
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setFirstname(rs.getString("firstname"));
				emp.setLastname(rs.getString("lastname"));
				emp.setGender(Gender.valueOf(rs.getString("gender")));
				emp.setSalary(rs.getDouble("salary"));
				employee.add(emp);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		return employee;

	}
	
	public List<Employee> sortEmployeeByLastname(){
		
		List<Employee> employee = new ArrayList<Employee>();
		Edi = new EmployeeDAOImplementation();
		con = Edi.connectionCon();
		
		try {
			pst = con.prepareStatement("select id,firstname,lastname,gender,salary from Employee where flag=1 order by lastname");
		
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setFirstname(rs.getString("firstname"));
				emp.setLastname(rs.getString("lastname"));
				emp.setGender(Gender.valueOf(rs.getString("gender")));
				emp.setSalary(rs.getDouble("salary"));
				employee.add(emp);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		return employee;
		
	}
	
public List<Employee> sortEmployeeBySalary(){
		
		List<Employee> employee = new ArrayList<Employee>();
		Edi = new EmployeeDAOImplementation();
		con = Edi.connectionCon();
		
		try {
			pst = con.prepareStatement("select id,firstname,lastname,gender,salary from Employee where flag=1 order by salary");
		
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setFirstname(rs.getString("firstname"));
				emp.setLastname(rs.getString("lastname"));
				emp.setGender(Gender.valueOf(rs.getString("gender")));
				emp.setSalary(rs.getDouble("salary"));
				employee.add(emp);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		return employee;
		
	}

}
