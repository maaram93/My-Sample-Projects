package employeeJDBCOperations;

import java.util.Comparator;
import java.util.Scanner;

public class EmployeeLastNameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {

		final int BEFORE = -1;
		final int EQUAL = 0;
		final int After = 1;

		if (e1.getLastname().compareTo(e2.getLastname()) > 0) {
			return After;
		}
		if (e1.getLastname().compareTo(e2.getLastname()) < 0) {
			return BEFORE;
		}

		return 0;
	}

}
