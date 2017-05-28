package mainApp;


import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Flight;
import entities.FlightDetails;
import repository.FlightDao;
import repository.FlightDaoImplementation;


enum Menu {

	create(1), find(2), update(3), delete(4);
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

public class FlightApp {

	
	static FlightDao Eap;

	public static void main(String[] args) {

		int choice = 0;
		boolean flag = true;
		Eap = new FlightDaoImplementation();
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
					create();
				} catch (InputMismatchException e) {
					System.out.println(e);
					System.out.println("Employee can't be created due InputMismatch");

				}
				break;
			case 2:
				try {
					read();
				} catch (InputMismatchException e) {
					System.out.println(e);
					System.out.println("Employee can't be find due InputMismatch");
				}
				break;

			case 3:
				try {
					update();
				} catch (InputMismatchException e) {
					System.out.println(e);
					System.out.println("Employee can't be updated due InputMismatch");

				}
				break;

			case 4:
				try {
					delete();
				} catch (InputMismatchException e) {
					System.out.println(e);
					System.out.println("Employee can't be deleted due InputMismatch");

				}
				break;
			default:
				System.out.println("Your choice should be 1-6");

			}

		}
	}

	

	private static void delete() {
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

	private static void update() {

		Flight flight = new Flight(2, 2, "dallas", "missouri", "12:00",
				"3:00", 3,100);
		FlightDetails flightDetails = new FlightDetails(2,"2017-05-23",300.25,20);
		boolean flag;
		try {
			flag = Eap.update(flight);
			if (flag == true)
				System.out.println(flag + "Employee Succesfully updated");
			else
				System.out.println(flag + "There is no Employee with id  " + flight.getFlightId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void read() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Employee id EX: 1");
		int id = scan.nextInt();

		Flight flight = null;
		try {
			flight = Eap.read(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flight.getFlightId() != 0)
			System.out.println(flight);
		else
			System.out.println("There is No Employee with the given id " + id);

	}

	private static void create() {

		Flight flight = new Flight(1, 2, "dallas", "missouri", "12:00",
				"3:00", 3,100);
		FlightDetails flightDetails = new FlightDetails(1,"2017-05-23",300.25,20);
		try {
			Eap.create(flight);
		} catch (NullPointerException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Employee not created");
		}

	}

	
}
