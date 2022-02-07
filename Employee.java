package StoreManagement;   //package name in which this class is stored
/*
 * Name - Neeraj Kumar Bansal
 * Course - CST8132_301
 * Assessment - Lab4
 * Lab Professor - Dr. Anu Thomas
 */

//java API class for input from user
import java.util.Scanner;

/**
 * This class extends person class and take read and print employee personal details
 * @author Neeraj Bansal
 * @version 1.0
 * @since 1.8
 */
public abstract class Employee extends Person{
	
	/**Instance variable which store employee number of integer type only */
	protected int empNumber;
	
	/**Parameterized constructor of person class called */
	protected Person p;

	protected int empType;  //variable for refrence of type of employee made for process increment
	
	/**
	 * Employee named no-arg constructor to create default values of variables while compilation 
	 */
	Employee(){}   //no-arg constructor
	
	/**
	 * Employee prameterized constructor with parameters
	 * @param number for employee number of integer type
	 * @param n1 for first name of employee
	 * @param n2 for last name of employee
	 * @param e for email address of employee
	 * @param ph for phone number of employee
	 */
	Employee(int number, String n1, String n2, String e, long ph){
		empNumber = number;            //local variable declare equals to instance variable
		p = new Person(n1, n2, e, ph);  //variables refrenced in same order of data type as in Person class
	}
	
	/**
	 * This method will take all personal details values of employee
	 * @param input for taking input from the user
	 */
	public void readEmployee(Scanner input) {
		
		System.out.print("Enter employee number: ");
		empNumber = input.nextInt();             //store employee number entered by user
		
		input.nextLine();                           //flushes extra \n from method
		
		System.out.print("Enter first name: ");
		String fName = input.nextLine();         //store first name of employee entered by user
		
		System.out.print("Enter last name: ");
		String lName = input.nextLine();           //store last name of employee entered by user
		
		System.out.print("Enter email: ");
		String email = input.nextLine();           //store email address of employee entered by user
		
		System.out.print("Enter phone number: ");
		long ph = input.nextInt();              //store phone number of employee entered by user
		
		p = new Person(fName, lName, email, ph);     //store entered values according order and type as in person class
	}//exit method
	
	/**
	 * This method will print any employee details stored in program
	 */
	public void printEmployee() {
		
		System.out.printf("%8d | %14s | %13s | %21d |", empNumber, p.getName(), p.getEmail(), p.getPhoneNumber());  //accessor called from Person class
	}//exit method
	
}//exit class