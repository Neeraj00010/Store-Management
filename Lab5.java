package StoreManagement;  //package name in which this class is stored
/*
 * Name - Neeraj Kumar Bansal
 * Course - CST8132_301
 * Assessment - Lab4
 * Lab Professor - Dr. Anu Thomas
 */

import java.util.InputMismatchException;
//java API class for input from user
import java.util.Scanner;

/**
 * This is a testing class which take inputs from user and print that entered details
 * @author Neeraj Bansal
 * @version 1.0
 * @since 1.8
 */
public class Lab5 {
/**
 * Main method, with input object for taking inputs from user using Scanner API class
 * Name and num are two parameters which store name of the store and no. of employees
 * @param args command line arguments
 */
	public static void main(String[] args) {
		
        Scanner input = new Scanner(System.in);        //input object for taking inputs from user
		
		System.out.print("Enter the name of the store: ");
		String name = input.nextLine(); //instance variable for storing string input
		
		int num = 0;
		boolean control = true;
		
		while(control) {
			try{
			
				System.out.print("How many employees do you have? ");
			    num = input.nextInt();          //instance variable for storing integer input from user
			
			while(num <= 0) {      //loop will print if num value is lees or equals to than 0
				
				System.err.print("Number of employees should be greater than zero... Please try again\n");
				System.out.print("How many employees do you have? ");
				num = input.nextInt();          //instance variable for storing integer input from user
				
			}//exit inner while loop
			
		    control = false;
		
			}catch(InputMismatchException ime) {
			System.err.println("Number of employees should be greater than zero... Please try again");
			input.next();
			}catch(IllegalArgumentException iae) {
			System.err.println("Number of employees should be greater than zero... Please try again");
			input.next();
			}catch(Exception e) {
			System.err.println("Unknown Exception: " + e.getMessage());
			input.next();
			}
		}//exit outer while

		Store s = new Store(name, num);      //object to import Store class with 2 parameters
		
		 while(true) {              //boolean value to continue repeating the loop infinite times
				
				System.out.print("1. Read Employee Details from keyboard\n2. Read Employee Details from file \n3. Process increments \n4. Print Employee Details \n5. Exit \nEnter your choice: ");
				int option = input.nextInt();   //local variable store number which to continue
				
				if(option == 1)
					s.readEmployeeDetails(input);  //method to read details with store class referenced object, if condition is true
				
				else if(option == 2) {
					if(input != null) {
					Store.openFile(input);  //method to process when option is 2
					}
					
				}//end else if
				
				else if(option == 3) {
					s.processIncrements();  //method to process when option is 3
				}//end else if
				
				else if(option == 4) {
					s.printEmployeeDetails(input);   //method to process with object for printing details, if condition is true
				}//end else if
				
				else if(option == 5){                     //print statement and then shutdown the program
					System.out.print("Goodbye... Have a nice day!"); 
				break;                                              //exit statement imidiately
				}//end else if
				
				else {                          //print statement, if above conditions are false
					System.out.println("Invalid choice... choice should be a positive integer between 1-5... Please try again");
				}//end else statement
				
			}//exit while
	
	}//exit main method

}//exit class