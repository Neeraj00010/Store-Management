package StoreManagement;    //package name in which this class is stored
/*
 * Name - Neeraj Kumar Bansal
 * Course - CST8132_301
 * Assessment - Lab4
 * Lab Professor - Dr. Anu Thomas
 */

//java API class for exception when file not found
import java.io.FileNotFoundException;
//java API class for exception for input output
import java.io.IOException;
//java API class for exception when file's path is not trace by program
import java.nio.file.Paths;
//java API class for Array List
import java.util.ArrayList;
//java API class for exception when input data type does not match with data type of variable
import java.util.InputMismatchException;
//java API class for input from user
import java.util.Scanner;

/**
 * Store class is the composition of Employee class
 * This class has methods which read and print employee details
 * There are two more methods for printing title of store and and '=' line
 * @author Neeraj Bansal
 * @version 1.0
 * @since 1.8
 */
public class Store {
	
	/**take name of the store */
	private static String storeName;
	
	/**collect number of employees whom data to store */
	private static int numEmployee;
	
	/**Array to store employees info, 
	 * Inherits from Employee class
	 * employees object to store array values*/
	private static ArrayList<Employee> employees;
	
	/**
	 * Store named no-arg constructor to create default values of variables while compilation 
	 */
	Store(){}   //no-arg constructor
	
	/**
	 * Store named parameterized constructor
	 * @param name take same String value as entered in test class
	 * @param numEmployee take same integer value as entered in test class 
	 */
	Store(String name, int numEmployee){     //parameterized constructor
		storeName = name;            //local variable delare equals to instance variable
		employees = new ArrayList<Employee>(numEmployee);   //local variable for declaring length of array
	}
	
	/**
	 * This method read employee details
	 * Values will store according to type as requested by user: regular or contractor
	 * @param input for taking input from the user
	 */
	public void readEmployeeDetails(Scanner input) {
			
			System.out.print("Please enter details of employee " + (numEmployee + 1));  //header line to keep track of which 
			                                                                          //number of employee values are going to enter
			
			System.out.println();     //empty line print statement
			
			int type = 0;    //initialize local variable which store type of employee value
			
			boolean control = true;  //boolean variable for looping continuty
			
			while(control) {
			
				try {
			
					System.out.print("1 - Regular\n2 - Contractor \nEnter employee type: ");
		            type = input.nextInt();                     //variable taking input value for type of employee
			
			        /*Program process this loop if entered type is not equal to given two numbers */
			        while ((!(type == 1) && !(type == 2))) {     
				
				    System.out.println("\n*** Type should be 1 or 2... Please try again ***\n");

				    System.out.println("1 - Regular");
				    System.out.println("2 - Conractor");
				    System.out.print("Enter employee type: ");
				    type = input.nextInt();                       //same local variable to store input value for type of employee
				 
			        }//end inner-while loop
			
			    control = false;    //end infinity of while loop
			
			    }catch(InputMismatchException ime) {
				System.out.println("\n*** Type should be 1 or 2... Please try again ***\n");
				input.next();
				}catch(IllegalArgumentException iae) {
				System.out.println("*** Type should be 1 or 2... Please try again ***\n");
				input.next();
				}catch(Exception e) {
				System.err.println("\nUnknown Exception: " + e.getMessage());
				input.next();
				}
			}//exit outer while loop
			
			if(type == 1) {
				employees.add(new  Regular());           //Regular class to proceed, if condition is true
				employees.get(numEmployee).readEmployee(input);  //method to process in  Employee class and store details in Regular class
			}//exit if statement
			
			else if(type == 2) {
				employees.add(new Contractor());             //Contrator class to proceed, if condition is true
				employees.get(numEmployee).readEmployee(input);   //method to process in Employee class and store details in Contractor class
			}//exit else-if statement
			
			numEmployee++;    //increment numEmployee variable value everytime method runs
		
	}//exit method
	
	/**
	 * This method will open file using path defined
	 * Also run readFile and closeFile method
	 * @param input for taking input from user
	 */
	public static void openFile(Scanner input) {
		try {
			input = new Scanner(Paths.get("C:\\CST8116 Homework\\eclipse workspace\\Lab 5\\src\\StoreManagement\\emp.txt"));  //files opening using Scanner
			 
			while (input.hasNext()) {
	
				if (input.nextInt() == 1) {

					// uses the parameterized constructor to add a regular employee
					employees.add(
							new Regular(input.nextInt(), input.next(),
									input.next(), input.next(), input.nextLong(), (input.nextDouble() /12) ));
				} 
				else {
					// uses the parameterized constructor to add a contractor employee
					employees.add(
							new Contractor(input.nextInt(), input.next(),
									input.next(), input.next(), input.nextLong(), input.nextDouble(), input.nextDouble()));
				}//exit else statement
				
				numEmployee++;  //increment number of employee each time loop run
				
			}//exit while loop
		}catch(FileNotFoundException nfe) {
			System.out.println("File not found or file not accessible");
		}catch(IOException ioe) {
			System.out.println(ioe);
		}
		
		if(input != null)
			readFile(input);    //method run only when input is empty
	
		closeFile(input);       //close file method, successfully close the method
	}//exit method
	
	/**
	 * This method read the file
	 * @param input for taking input from user
	 */
	public static void readFile(Scanner input) {
		try {
			while(input.hasNext()) {
				System.out.println(input.nextInt() + " " + input.nextInt() + " " + input.nextInt() + " " + input.nextDouble());
			}
		}catch(InputMismatchException ime) {
			System.out.println("Input mismatch exception while reading from the file");
		}catch(IllegalStateException ise) {
			System.out.println("Scanner closed");
		}
		
	}//exit method
	
	/**
	 * This method will successfully close the file only when Scanner input is empty
	 * @param input for taking input from user
	 */
	public static void closeFile(Scanner input) {
		if(input != null)
			input.close();
	}//exit method
	
	/** This method will increase or decrease salary of employees according to their role or type	 */
	public void processIncrements() {
		
		if(employees.isEmpty()) 
			System.out.print("\n**** No employees to process ****\n\n");  //printing statement when employee object is empty

			else {
			
				for(int i = 0; i < employees.size(); i++) { //index variable
				
					if(employees.get(i).empType == 1) {
						double sal = ((Regular) employees.get(i)).getSalary();   //accessor for double value stored in file for type 1
					    sal = sal + (0.03 * sal);    //salary increase by 3%
					    ((Regular) employees.get(i)).setSalary(sal);   //mutator with parameter
				     }//end if statement
				     
					else {
					    double hr = ((Contractor) employees.get(i)).getSalary();  //accessor for double value stored in file for type 2
					    hr = hr + 1;   //hourly rate increase by $1
					    ((Contractor) employees.get(i)).setSalary(hr);  //mutator with parameter
				    }//end else statement
			}//end for loop
           }//exit else statement
	}//exit method
	
	/**
	 * Method will print employee details collected in Employee class
	 * This method will print details only if employees array holds any value in it
	 * @param input for taking input from the user
	 */
	public void printEmployeeDetails(Scanner input) {
			
			if(employees.isEmpty()) 
				System.out.print("\n**** No employees to print ****\n\n");  //printing statement when employee object is empty
			
			else {
	    		printTitle();   //static method which print header title
			/* print details everytime until the index variable reach size of an array    */
		    for(int i = 0; i < employees.size(); i++) {   
		    	if(employees.get(i) != null) {
				try {    
				employees.get(i).printEmployee();  //process method of Employee class
				} catch (ArrayIndexOutOfBoundsException aiobe) {
					System.out.println(aiobe);
				} catch (NullPointerException npe) {
					System.out.println(npe);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				}//exit if statement
		    	
	        } //exit for loop
			}//exit else statement
	}//exit method
	
	/** This static method will print a line of '=' everytime this method called*/
	public static void printLine() {
		
		for(int i = 0; i<82; i++) {
			System.out.print("=");
		}//exit for loop
		
	}//exit method
	
	/** This static method will print name of store everytime this method called */
	public static void printTitle() {

		String space = "";   //empty space value for formatting
        
		printLine();        //static method called from store class for printing line
		
		System.out.println();  //print empty line
		
		System.out.printf("%25s Store Management System", storeName);      //static method called from store class for printing title entered by user
	    
	    System.out.println();   //print empty line
	    
	    printLine();        //static method called from store class for printing line
	    
	    System.out.println();   //print empty line
	    
	    /* Header row for values which declare, what kind of values are under that column name    */
	    System.out.printf("%4sEMP# | %10sName | %8sEmail | %9sPhone Number | %6sSalary|", space, space, space, space, space);
	    System.out.println();   //print empty line
	}//exit method
	
}//exit class