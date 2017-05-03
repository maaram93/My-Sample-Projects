package employeeArrayOperation;

public interface EmployeeOperations {

	void create(Employee employee);

	Employee read(int id);

	boolean update(Employee employee);

	boolean delete(int id2);

	

	

	void displayAll();

}
