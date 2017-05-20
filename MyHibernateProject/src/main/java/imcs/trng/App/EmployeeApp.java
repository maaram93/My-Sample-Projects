package imcs.trng.App;

import static imcs.trng.HibernateUtil.EmployeeUtil.*;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import imcs.trng.Dao.EmployeeDao;
import imcs.trng.Dao.EmployeeDaoImplementation;
import imcs.trng.beans.SalaryCount;
import trng.imcs.hibernate.pojo.Employee;

enum Menu {

	createEmployee(1), findEmployee(2), updateEmployee(3), deleteEmployee(4), DisplayAll(5), calculateHRA(
			6), calculateGrossSalary(
					7), SortData(8), DisplayUniqueEmployeeNames(9), DisplayEmployeeSalaryWiseCount(10), Exit(11);

	int n;

	Menu(int n) {
		this.n = n;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
}

public class EmployeeApp {

	
	static EmployeeDao Eap;

	public static void main(String[] args) {

		EmployeeApp employeeApp = new EmployeeApp();
		int choice = 0;
		boolean flag = true;
		Eap = new EmployeeDaoImplementation();

		// LoadEmployees(Eap);

		while (flag) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Select an Operation below(EX : 1)");
			for (Menu M : Menu.values()) {

				System.out.println(M.getN() + " . " + M);

			}

			try {
				choice = scan.nextInt();

			} catch (InputMismatchException e) {
				System.out.println(e);
				System.out.println("Your input should be an Interger");
				continue;
			}

			switch (choice) {
			case 1:
				try {
					employeeApp.createEmploy();
				} catch (InputMismatchException e) {
					System.out.println(e);
					System.out.println("Employee can't be created due InputMismatch");

				}
				break;
			case 2:
				try {
					employeeApp.readEmploy();
				} catch (InputMismatchException e) {
					System.out.println(e);
					System.out.println("Employee can't be find due InputMismatch");
				}
				break;

			case 3:
				try {
					employeeApp.updateEmploy();
				} catch (InputMismatchException e) {
					System.out.println(e);
					System.out.println("Employee can't be updated due InputMismatch");

				}
				break;

			case 4:
				try {
					employeeApp.deleteEmployee();
				} catch (InputMismatchException e) {
					System.out.println(e);
					System.out.println("Employee can't be deleted due InputMismatch");

				}
				break;
			case 5:
				try {
					employeeApp.displayAllEmployees();
				} catch (NullPointerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 6:
				try {
					employeeApp.calculateHra();
				} catch (InputMismatchException e) {
					System.out.println(e);
					System.out.println("HRA can't be Calculated due InputMismatch");

				}
				break;

			case 7:
				try {
					employeeApp.calculateGrossSalary();
				} catch (InputMismatchException e) {
					System.out.println(e);
					System.out.println("GrossSalary can't be Calculated due InputMismatch");

				}
				break;

			case 8:
				try {
					employeeApp.sortEmployee();
				} catch (InputMismatchException e) {
					System.out.println(e);
					System.out.println("Employee can't be Sorted due InputMismatch");

				}
				break;
			case 9:
				try {
					employeeApp.displayUniqueEmployeeNames();
				} catch (InputMismatchException e) {
					System.out.println(e);
					System.out.println("Employee can't be Sorted due InputMismatch");

				}
				break;

			case 10:
				try {
					employeeApp.DisplayEmployeeSalaryWiseCount();
				} catch (InputMismatchException e) {
					System.out.println(e);
					System.out.println("Employee can't be Sorted due InputMismatch");

				}

				break;
			case 11:

				flag = false;
				System.out.println("Your Session ended");
				break;

			default:
				System.out.println("Your choice should be 1-6");

			}

		}
	}

	private void DisplayEmployeeSalaryWiseCount() {

		System.out.println("Number of Employees with same Salary");

		List<SalaryCount> maps = Eap.DisplayEmployeeSalaryWiseCount();

		Map<Double,Long> salaryCountResults = new HashMap<Double,Long>();
		 		
		 		for(SalaryCount count: maps ){
		 		System.out.println(salaryCountResults.put(count.getSalary(), (long) count.getCount()));
		 		}

	}

	private void displayUniqueEmployeeNames() {

		System.out.println("Eliminating duplicates based on LASTNAME");
		List<Employee> employee = Eap.displayUniqueEmployeeNames();
		Set<Employee> employees = new HashSet<Employee>(employee);
		for (Employee emp : employees) {
			System.out.println(emp);
		}

	}

	private void sortEmployee() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Select an Option to Sort" + "\n" + "1.Sort by lastname" + "\n" + "2.Sort by Salary");
		int option = scan.nextInt();

		if (option == 1) {
			List<Employee> employee = Eap.sortEmployeeByLastname();
			for (Employee emp : employee) {
				System.out.println(emp);
			}
		} else if (option == 2) {
			List<Employee> employee = Eap.sortEmployeeBySalary();
			for (Employee emp : employee) {
				System.out.println(emp);
			}
		} else {

			System.out.println("You have to choose Either 1 or 2");
		}

	}

	private void displayAllEmployees() {

		try {
			for (Employee emp : Eap.displayAll()) {
				System.out.println(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deleteEmployee() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Employee id EX: 1");
		int id2 = scan.nextInt();
		boolean flag;
		try {
			flag = Eap.delete(id2);
			if (flag) {
				System.out.println("Deleted successfully");
			} else {
				System.out.println("No employee found with given id : " + id2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void updateEmploy() {

		Employee employee = updateEmployDetails();
		boolean flag;
		try {
			flag = Eap.update(employee);
			if (flag == true)
				System.out.println(flag + "Employee Succesfully updated");
			else
				System.out.println(flag + "There is no Employee with id  " + employee.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void readEmploy() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Employee id EX: 1");
		int id = scan.nextInt();

		Employee employee = null;
		try {
			employee = Eap.read(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (employee.getId() != 0)
			System.out.println(employee);
		else
			System.out.println("There is No Employee with the given id " + id);

	}

	private void createEmploy() {

		Employee employee = createEmployDetails();
		try {
			Eap.create(employee);
		} catch (NullPointerException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Employee not created");
		}

	}

	private void calculateGrossSalary() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Employee id EX: 1");
		int id4 = scan.nextInt();
		try {
			double emp4 = Eap.grossSalary(id4);
			if (emp4 == 0) {

				throw new NullPointerException("No employee found with id " + id4);
			}
			double ans = 1.2 * emp4;
			System.out.println("GrossSalary of Employee with id " + id4 + "=" + ans);
		} catch (NullPointerException | SQLException e) {

			System.out.println(e);
			System.out.println("To calculate grossSalary of Employee You need to create Employee");
		}

	}

	private void calculateHra() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Employee id EX: 1");
		int id3 = scan.nextInt();
		try {
			double emp3 = Eap.hra(id3);
			if (emp3 == 0) {

				throw new NullPointerException("No employee found with id " + id3);
			}
			double ans = 0.2 * emp3;
			System.out.println("HRA of Employee with id " + id3 + "=" + ans);
		} catch (NullPointerException | SQLException e) {
			System.out.println(e);
			System.out.println("To calculate Employee HRA You need to create Employee");
		}

	}

}
