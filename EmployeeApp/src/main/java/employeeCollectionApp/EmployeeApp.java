package employeeCollectionApp;

import static employeeCollectionOperation.EmployeeUtil.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import employeeCollectionOperation.Employee;
import employeeCollectionOperation.EmployeeCollectionsOperations;
import employeeCollectionOperation.EmployeeLastNameComparator;
import employeeCollectionOperation.EmployeeSalaryComparator;

enum Menu {

	createEmployee(1), findEmployee(2), updateEmployee(3), deleteEmployee(4), DisplayAll(5), 
	calculateHRA(6), calculateGrossSalary(7), SortData(8),DisplayUniqueEmployeeNames(9),DisplayEmployeeSalaryWiseCount(10), Exit(11);

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

	Scanner scan = new Scanner(System.in);
	static EmployeeCollectionsOperations Eap;

	public static void main(String[] args) {

		EmployeeApp employeeApp = new EmployeeApp();
		int choice = 0;
		boolean flag = true;
		Eap = new EmployeeCollectionsOperations();

		LoadEmployees(Eap);

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
				employeeApp.Eap.displayAll();
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
				String lines;
				try {
					BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("CSV File.csv"));
					for (int i = 0; i < Eap.numberOfEmployee; i++) {

						lines = Eap.Employees.get(i).getId() + "," + Eap.Employees.get(i).getFirstname() + ","
								+ Eap.Employees.get(i).getLastname() + "," + Eap.Employees.get(i).getSalary() + ","
								+ Eap.Employees.get(i).getGender();

						bufferedWriter.write(lines);
						bufferedWriter.newLine();
						bufferedWriter.flush();
						

					}
				} catch (IOException e) {

					e.printStackTrace();
				}

				flag = false;
				System.out.println("Your Session ended");
				break;
			default:
				System.out.println("Your choice should be 1-6");

			}

		}
	}

	private void DisplayEmployeeSalaryWiseCount() {
		HashMap<Double,Integer> employee = new HashMap<>();
		int value=1;
		System.out.println("Number of Employees with same Salary");
		for(int i=0;i<Eap.numberOfEmployee;i++){
			
			
			if(employee.containsKey(Eap.Employees.get(i).getSalary())){
				 value+= 1;
				 employee.replace(Eap.Employees.get(i).getSalary(), value);
			}else{
				employee.put(Eap.Employees.get(i).getSalary(), value);
			}
			
		}
		
		for(Map.Entry<Double,Integer> entry: employee.entrySet()){
			
			System.out.println(entry.getKey()+"-"+entry.getValue());
		}
		
		
		
	}

	private void displayUniqueEmployeeNames() {
		System.out.println("Eliminating duplicates based on LASTNAME");
		Set<Employee> employee = new HashSet<Employee>(Eap.Employees);
		for(Employee emp:employee ){
		System.out.println(emp);
		}
		
	}

	private void sortEmployee() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Select an Option to Sort" + "\n" + "1.Sort by lastname" + "\n" + "2.Sort by Salary");
		int option = scan.nextInt();
		
		if (option == 1) {
		Collections.sort(Eap.Employees, new EmployeeLastNameComparator());
		for(Employee emp:Eap.Employees ){
			System.out.println(emp);
			}
		}
		else if (option == 2) {
			Collections.sort(Eap.Employees, new EmployeeSalaryComparator());
			for(Employee emp:Eap.Employees ){
				System.out.println(emp);
				}
		}else {

			System.out.println("You have to choose Either 1 or 2");
		}
		
	}

	private void displayAllEmployees() {

		Eap.displayAll();
	}

	private void deleteEmployee() {
		System.out.println("Enter Employee id EX: 1");
		int id2 = scan.nextInt();
		boolean flag = Eap.delete(id2);
		if (flag) {
			System.out.println("Deleted successfully");
		} else {
			System.out.println("No employee found with given id : " + id2);
		}

	}

	private void updateEmploy() {

		Employee employee = createEmployDetails();
		boolean flag = Eap.update(employee);
		if (flag == true)
			System.out.println(flag + "Succesfully updated");
		else
			System.out.println(flag + "There is no Employee with id  " + employee.getId());

	}

	private void readEmploy() {

		System.out.println("Enter Employee id EX: 1");
		int id = scan.nextInt();

		Employee employee = Eap.read(id);
		if (employee != null)
			System.out.println(employee);
		else
		System.out.println("There is No Employee with the given id "+id);

	}

	private void createEmploy() {

		Employee employee = createEmployDetails();
		Eap.create(employee);

	}
	
	private void calculateGrossSalary() {
		System.out.println("Enter Employee id EX: 1");
		int id4 = scan.nextInt();
		try{
		double emp4 = Eap.grossSalary(id4);
		System.out.println("GrossSalary ="+emp4);
		}catch (NullPointerException e) {
			
			System.out.println("To calculate grossSalary of Employee You need to create Employee");
		}
		
	}

	private void calculateHra() {
		System.out.println("Enter Employee id EX: 1");
		int id3 = scan.nextInt();
		try{
		double emp3 = Eap.hra(id3);
		System.out.println("HRA ="+emp3);
		}catch (NullPointerException e) {
			
			System.out.println("To calculate Employee HRA You need to create Employee");
		}
		
	}

}
