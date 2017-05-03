package employeeArrayOperation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeeArrayOperations implements EmployeeOperations {

	public Employee[] Employees;
	int size, i;
	public int numberOfEmployee;

	public EmployeeArrayOperations(int size) {

		this.size = size;
		Employees = new Employee[size];

	}

	public EmployeeArrayOperations() {
		super();

	}

	public void create(Employee employee) {

		
		if (Employees.length == numberOfEmployee) {
			ReSizeArray();
		}

		Employees[numberOfEmployee++] = employee;

	}

	private void ReSizeArray() {
		size = size * 2;
		Employees = Arrays.copyOf(Employees, size);

		

	}

	public Employee read(int id) {

		int i = 0;

		Employee emply = null;

		for (i = 0; i < numberOfEmployee; i++) {

			if (Employees[i].getId() == id) {

				emply = Employees[i];
				break;

			}

		}
		

		return emply;

	}

	public boolean update(Employee employee) {

		for (int i = 0; i < numberOfEmployee; i++) {

			if (Employees[i].getId() == employee.getId()) {

				Employees[i] = employee;
				return true;
			}
		}

		return false;
	}

	public boolean delete(int id2) {

		if (Employees[i] != null) {
			for (int i = 0; i < numberOfEmployee; i++) {
				if (Employees[i].getId() == id2) {
					Employees[i] = null;
					numberOfEmployee--;

					for (int j = 0; j < size - 1; j++) {
						Employees[j] = Employees[j + 1];
					}
					return true;
				}
			}
		}

		return false;
	}

	public void displayAll() {

		for (int i = 0; i < numberOfEmployee; i++) {
			if (Employees[i] != null) {
				System.out.println(Employees[i]);
			} else
				System.out.println("No Employees to display");
		}

	}

}
