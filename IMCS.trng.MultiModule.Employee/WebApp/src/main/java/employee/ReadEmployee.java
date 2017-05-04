package employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employeeJDBCOperations.Employee;
import employeeJDBCOperations.EmployeeDAOImplementation;


public class ReadEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDAOImplementation edi = new EmployeeDAOImplementation(); 
    
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String id = request.getParameter("id");
		
		try {
			Employee employee= edi.read(Integer.parseInt(id));
			if((employee.getId())!=0){
				pw.println("<html><table align='center' border=2>");
				pw.println("<h3 align='center'>Employee Details </h3>");
				 pw.println("<tr><td>id</td><td>"+employee.getId()+"</td></tr>");
				 pw.println("<tr><td>firstname</td><td>"+employee.getFirstname()+"</td></tr>");
				 pw.println("<tr><td>lastname</td><td>"+employee.getLastname()+"</td></tr>");
				 pw.println("<tr><td>gender</td><td>"+employee.getGender()+"</td></tr>");
				 pw.println("<tr><td>salary</td><td>"+employee.getSalary()+"</td></tr>");
				 pw.println("</table></html>");
					
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("error.html");
				rd.forward(request, response);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
