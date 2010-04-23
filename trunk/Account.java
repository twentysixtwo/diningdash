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
	private String userName;
	private String name;
	/**
	 * 
	 */
	private String day;
	
	/**
	 * Employee pay rate
	 */
	private float payRate;
	
	/**
	 * Time of employee log in
	 */
	private int startTime;
	
	/**
	 * Time of employee log out
	 */
	private int endTime;
	
	/**
	 * Employee ID number
	 */
	private int employeeID;
	
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
	 * @return Employee name
	 */
	public String getName() {
		return userName;
	}
	
}