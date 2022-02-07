package StoreManagement;  //package name in which this class is stored
/*
 * Name - Neeraj Kumar Bansal
 * Course - CST8132_301
 * Assessment - Lab4
 * Lab Professor - Dr. Anu Thomas
 */

//java API class for input from user
import java.util.Scanner;

/**
 * This class extends Employee class and take salary input from user 
 * @author Neeraj Bansal
 * @version 1.0
 * @since 1.8
 */
public class Regular extends Employee{
	
	/**Instance variable for salary a employee get at the end of year of double data type */
	private double salary;
	
	/**
	 * Regular named no-arg constructor to create default values of variables while compilation 
	 */
	Regular(){}   //no-arg constructor
	
	Regular(int number, String n1, String n2, String e, long ph, double s){     //parameterized constructor
		super.empNumber = number;
		super.p = new Person(n1,n2,e,ph);
		salary = s;
	}  
	
	/**
	 * Regular named constructor for declaring type of employee
	 * @param type is employee type - regular
	 */
	Regular(int type){
		type = 1;
		empType = type;
	}
	
	/**
	 * This method is overritten for regular named class for storing more variables which are not previously written
	 */
	@Override
	public void readEmployee(Scanner input) {
		
		super.readEmployee(input);   //super.method call previous written method in super class
		
		System.out.print("Enter annual salary: ");
		salary = input.nextDouble() / 12;       //convert annual salary to monthly salary 
	}//exit method
	
	/**
	 * This method is overritten for regular named class for printing vlaues which are newly stored
	 */
	@Override
	public void printEmployee() {
		
		super.printEmployee();    //super.method call previous written method in super class
		
		System.out.printf("%12.2f |", salary);
		
		System.out.print("\n");   //put cursor to next line
	}//exit method

	/**
	 * Mutator for new salary
	 * @param hr is parameter for new salary
	 */
	public void setSalary(double sal) {
		salary = sal;
	}

	/**
	 * Accessor for new salary
	 * @return salary
	 */
	public double getSalary() {
		return salary;
	}
		
}//exit class