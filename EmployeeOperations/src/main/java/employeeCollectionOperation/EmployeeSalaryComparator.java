package employeeCollectionOperation;

import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {

	
	final int BEFORE = -1;
	final int EQUAL = 0;
	final int After = 1;
	
	@Override
	public int compare(Employee e1, Employee e2) {
		if (e1.getSalary() > e2.getSalary())
			return After;
		if (e1.getSalary() < e2.getSalary())
			return BEFORE;
		return 0;
	}

}
