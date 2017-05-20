package imcs.trng.HibernateUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import trng.imcs.hibernate.pojo.Employee;
import trng.imcs.hibernate.pojo.Gender;

public class EmployeeUtil {

	public static Employee createEmployDetails() {

		Scanner scan = new Scanner(System.in);
		//EmployeeCollectionsOperations Eap;
		
		System.out.println("Enter Employee firstname EX: raj  ");
		String firstname = scan.nextLine();

		System.out.println("Enter Employee lastname EX: raj  ");
		String lastname = scan.next();
		System.out.println("Enter Employee SALARY Should NOT Exceed 100000(100K)EX: 100.00  ");

		double salary = scan.nextDouble();
		if (salary > 100000) {
			throw new InputMismatchException("Employee can't exceed 100K");
		}
		System.out.println("Enter Gender(EX: MALE OR FEMALE)");
		String line = scan.next();
		if ((!line.toUpperCase().equals("MALE")) &&( !line.toUpperCase().equals("FEMALE"))) {
			
			throw new InputMismatchException("Gender should be either male or female");

		}
		Gender guess = Gender.valueOf(line.toUpperCase());

		Gender gender = null;
		switch (guess) {

		case MALE:

			gender = Gender.MALE;
			
			break;
		case FEMALE:
			gender = Gender.FEMALE;
			break;
		default:
			System.out.println("Enter either MALE or FEMALE");

		}
		
		
		Employee employee = new Employee(firstname, lastname, gender, salary);

		return employee;

	}
	public static Employee updateEmployDetails() {

		Scanner scan = new Scanner(System.in);
		//EmployeeCollectionsOperations Eap;
		System.out.println("Enter Employee id EX: 1  ");
		int id = scan.nextInt();
		System.out.println("Enter Employee firstname EX: raj  ");
		String firstname = scan.next();

		System.out.println("Enter Employee lastname EX: raj  ");
		String lastname = scan.next();
		System.out.println("Enter Employee SALARY Should NOT Exceed 100000(100K)EX: 100.00  ");

		double salary = scan.nextDouble();
		if (salary > 100000) {
			throw new InputMismatchException("Employee can't exceed 100K");
		}
		System.out.println("Enter Gender(EX: MALE OR FEMALE)");
		String line = scan.next();
		if ((!line.toUpperCase().equals("MALE")) &&( !line.toUpperCase().equals("FEMALE"))) {
			
			throw new InputMismatchException("Gender should be either male or female");

		}
		Gender guess = Gender.valueOf(line.toUpperCase());

		Gender gender = null;
		switch (guess) {

		case MALE:

			gender = Gender.MALE;
			
			break;
		case FEMALE:
			gender = Gender.FEMALE;
			break;
		default:
			System.out.println("Enter either MALE or FEMALE");

		}
		
		
		Employee employee = new Employee();
		employee.setId(id);
		employee.setFirstname(firstname);
		employee.setLastname(lastname);
		employee.setGender(gender);
		employee.setSalary(salary);

		return employee;

	}
}


