package employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeeJDBCOperations.Employee;
import employeeJDBCOperations.EmployeeDAOImplementation;
import employeeJDBCOperations.Gender;
import java.sql.SQLException;

public class CreateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmployeeDAOImplementation edi = new EmployeeDAOImplementation();

	public CreateEmployee() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lasttname");
		String gender = request.getParameter("gender");
		String salary = request.getParameter("salary");
		
		Employee employee = new Employee();
		employee.setFirstname(firstname);
		employee.setLastname(lastname);
		employee.setGender(Gender.valueOf(gender.toUpperCase()));
		employee.setSalary(Double.parseDouble(salary));
		
		try {
			boolean flag=edi.create(employee);
			if(flag){
				pw.println("<html><h3>Employee Successfully inserted into database</h3></html>");
				pw.println("<html><a href='http://localhost:8080/WebApp/read.html'>View Employee</a></html>");
				}
			
			else
				System.out.println(" Error \n Employee not inserted into database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
