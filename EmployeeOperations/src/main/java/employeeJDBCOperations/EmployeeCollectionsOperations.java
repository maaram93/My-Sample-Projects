package employeeJDBCOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeeCollectionsOperations implements EmployeeOperations {

	public List<Employee> Employees;
	int i;
	public int numberOfEmployee;

	public EmployeeCollectionsOperations() {

		super();
		Employees = new ArrayList<>();

	}

	public void create(Employee employee) {

		Employees.add(numberOfEmployee++, employee);

	}

	public Employee read(int id) {

		int i = 0;

		Employee emply = null;

		for (i = 0; i < numberOfEmployee; i++) {

			if (Employees.get(i).getId() == id) {

				emply = Employees.get(i);
				break;

			}

		}

		return emply;

	}

	public boolean update(Employee employee) {

		for (int i = 0; i < numberOfEmployee; i++) {

			if (Employees.get(i).getId() == employee.getId()) {

				Employees.add(i, employee);
				return true;
			}
		}

		return false;
	}

	public boolean delete(int id2) {

		
			for (int i = 0; i < numberOfEmployee; i++) {
				if (Employees.get(i).getId() == id2) {
					Employees.remove(i);
					numberOfEmployee--;

					
					return true;
				}
			}
		

		return false;
	}

	public void displayAll() {

		for (int i = 0; i < numberOfEmployee; i++) {
			if (Employees != null) {
				System.out.println(Employees.get(i).toString());
			} else
				System.out.println("No Employees to display");
		}

	}

	public double hra(int id3) {

		double hra = 0;

		for (int i = 0; i < numberOfEmployee; i++) {
			if (Employees.get(i).getId() == id3) {
				hra = 0.2 * Employees.get(i).getSalary();
				break;
			}

		}

		return hra;

	}

	public double grossSalary(int id4) {
		double gs = 0;

		for (int i = 0; i < numberOfEmployee; i++) {
			if (Employees.get(i).getId() == id4) {
				gs = 1.2 * Employees.get(i).getSalary();
				break;
			}
		}
		return gs;
	}

}
