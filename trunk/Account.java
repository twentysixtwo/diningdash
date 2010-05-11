/**
 * The account superclass contains basic information 
 * for each account holder. Each account holds the userName
 * of the employee, pay rate, an employee id, and the 
 * start and end time of the most recent shift. The 
 * shift information will be saved into the database
 * on each shift end (log out).
 *
 */
public class Account {
	
	/**
	 * Employee userName and name
	 */
	String userName;
	String name;
	/**
	 * 
	 */
	String day;
	
	/**
	 * Employee pay rate
	 */
	float payRate;
	
	/**
	 * Time of employee log in
	 */
	int startTime;
	
	/**
	 * Time of employee log out
	 */
	int endTime;
	
	/**
	 * Employee ID number
	 */
	int employeeID;
	
	/**
	 * Type of account.
	 */
	int type;
	
	/**
	 * Default constructor for Account
	 * Sets the employee userName and pay rate
	 * @param named Employee userName
	 * @param pay pay rate
	 */
	public Account(String named, float pay) {
		userName = named;
		payRate = pay;
	}
	
	/**
	 * Returns the Employee's userName. Used for verification/log in
	 * @return Employee username
	 */
	public String getName() {
		return userName;
	}
	
}