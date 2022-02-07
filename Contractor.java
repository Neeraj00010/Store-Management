package StoreManagement;    //package name in which this class is stored
/*
 * Name - Neeraj Kumar Bansal
 * Course - CST8132_301
 * Assessment - Lab4
 * Lab Professor - Dr. Anu Thomas
 */

//java API class for input from user
import java.util.Scanner;

/**
 * Contractor class extends Employee class and call methods from that class for reading and printing details
 * @author Neeraj Bansal
 * @version 1.0
 * @since 1.8
 */
public class Contractor extends Employee{
	
//	protected int empType = 2;
	
	/**Instance variable for hourly rate an employee work of double data type */
	private double hourlyRate;
	
	/**Instance variable for number of hours an employee work of double data type */
	private double numHours;
	
	/**
	 * Employee named no-arg constructor to create default values of variables while compilation 
	 */
	Contractor(){}   //no-arg constructor
	
	/**
	 * Contractor named parameterized constructor to create default values of variables while compilation 
	 * @param number is storing employee number 
	 * @param n1 is first name
	 * @param n2 is last name
	 * @param e is email of employee
	 * @param ph is phone number
	 * @param hr is hourly rate an employee get
	 * @param nh is number of hours an empoyee work
	 */
	Contractor(int number, String n1, String n2, String e, long ph, double hr, double nh){     //parameterized constructor
		super.empNumber = number;
		super.p = new Person(n1,n2,e,ph);
		hourlyRate = hr;
		numHours = nh;
	} 
	
	/**
	 * Contractor named constructor for declaring type of employee
	 * @param type is employee type - contractor
	 */
	Contractor(int type){
		type = 2;
		empType = type;
	}
	
	/**
	 * This method is overritten for contractor class for storing more variables in previous written method
	 */
	@Override
	public void readEmployee(Scanner input) {
		
		super.readEmployee(input);   //super.method call previous written method in super class
		
		System.out.print("Enter hourly rate: ");
		hourlyRate = input.nextDouble();          //take and store input from user for hourly rate
		
		System.out.print("Enter number of worked: ");
		numHours = input.nextDouble();              //take and store input from user for number of hours an employee work
	}//exit method
	
	/**
	 * This method is overritten for contractor class for printing vlaues which are newly stored
	 */
	@Override
	public void printEmployee() {
		
		super.printEmployee();      //super.method call previous written method in super class
		
		System.out.printf("%12.2f |", (hourlyRate * numHours));
		
		System.out.print("\n");              //put cursor to next line
	}//exit method
	
	/**
	 * Mutator for new hourly rate
	 * @param hr is parameter for new hourly rate
	 */
	public void setSalary(double hr) {
		hourlyRate = hr;
	}
	
	/**
	 * Accessor for new hourly rate
	 * @return new hourly rate
	 */
	public double getSalary() {
		return hourlyRate;
	}
	
}//exit class