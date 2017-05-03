package employeeCollectionOperation;

public interface EmployeeOperations {

	void create(Employee employee);

	Employee read(int id);

	boolean update(Employee employee);

	boolean delete(int id2);
	
	double hra(int id3);

	double grossSalary(int id4);
	

	

	void displayAll();

}
