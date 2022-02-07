package StoreManagement;   //package name in which this class is stored
/*
 * Name - Neeraj Kumar Bansal
 * Course - CST8132_301
 * Assessment - Lab4
 * Lab Professor - Dr. Anu Thomas
 */

/**
 * This method intialize variables for personal details of employee
 * @author Neeraj Bansal
 * @version 1.0
 * @since 1.8
 */
public class Person {
	
	/**Instance variable which store first name of employee of String data type only */
	private String firstName;     //instance variables
	
	/**Instance variable which store last name of employee of String data type only */
	private String lastName;
	
	/**Instance variable which store first name of employee of String data type only */
	private String email;
	
	/**Instance variable which store phone numberof employee of integer type only */
	private long phoneNumber;
	
	/**
	 * Employee named no-arg constructor to create default values of variables while compilation 
	 */
	Person(){} //non-arg constructor
	
	/**
	 * Parameterized constructor with parameters
	 * This constructor intialize instance variables
	 * @param fName same as firstName variable
	 * @param lName same as lastName variable
	 * @param email same as email instance variable
	 * @param ph same as phoneNumber variable
	 */
	Person(String fName, String lName, String email, long ph ){  //parameterized constructor
		firstName = fName;  //local variable declare equals to instance variable
		lastName = lName;   //local variable declare equals to instance variable
		this.email = email;  //local variable declare equals to instance variable explicitly
		phoneNumber = ph;    //local variable declare equals to instance variable
	}
	
	/**
	 * Accessor for name of employee
	 * @return addition of string variable with space between them
	 */
	public String getName() {           //accessor for name
		return firstName + " " + lastName;
	}//exit method
	
	/**
	 * Accessor for email address of employee
	 * @return email variable
	 */
	public String getEmail() {        //accessor for email
		return email;
	}//exit method
	
	/**
	 * Accessor for phone number of employee
	 * @return phoneNumber variable
	 */
	public long getPhoneNumber() {    //accessor phone number
		return phoneNumber;
	}//exit method
	
}//exit class