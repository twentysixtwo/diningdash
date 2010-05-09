import java.util.*;
import java.sql.*;

/**
 * The RecordKeeper class manages the database of all the persistent data.  The
 * database includes Bill, Account, Food, floor map, and login data.  The 
 * RecordKeeper class also uses the database to provide daily and hourly 
 * statistics of the restaurant.
 *
 */
public class RecordKeeper {

	/**
	 * Constructor for the RecordKeeper class.  This constructor connects
	 * to the database.
	 */
	RecordKeeper(){
		
	}
	
	/**
	 * Path of the database file
	 */
	String databasePath;
	
	/**
	 * Connects to the database file
	 */
	void connectToDatabase(){
		
	}
	

	/**
	 * Adds the data in the Bill object to the database
	 * 
	 * @param newBill  the Bill to be added
	 */
	void addBill(Bill newBill){
		
	}
	
	/**
	 * Adds the data in the Account object to the database
	 * If that account already exists in the database, that data is overwritten
	 * 
	 * @param newAccount  the Account to be added
	 */
	void addAccount(Account newAccount)
	{
		
	}

	/**
	 * Adds a new user to the database.  This creates the data that's used to login,
	 * including setting the password.  This fails if the account name already exists.
	 * 
	 * @param Account newAccount  the account to add
	 * @param password  the password for the account to add
	 * @return Returns true if successful, and false if unsuccessful
	 */
	boolean addUser(Account newAccount, String password)
	{
		return true;
	}


	/**
	 * Adds the data to the table of food for a specified date in the database
	 * 
	 * @param name  name of the food to be added
	 * @param price  price of the food to be added
	 * @param date  In the format <code>MM-DD-YYYY</code>
	 */
	void addFood(String name, double price, String date)
	{
		
	}
	
	
	/**
	 * Returns the revenue for the restaurant on a specified date
	 * 
	 * @param date  In the format <code>MM-DD-YYYY</code>
	 * @return The revenue
	 */
	double dailyRevenueData(String date){
		double revenue=0;
		return revenue;
	}
	
	/**
	 * Returns the revenue for the restaurant on a specified date in
	 * a specified hour
	 * 
	 * @param date  In the format <code>MM-DD-YYYY</code>
	 * @param hour  In the format 0=midnight, 2=2:00am, 12=noon,
	 *  14=2:00pm, and 23=11:00pm.  Specifying 1:00pm means the hour
	 *  between 1:00pm and 2:00pm 
	 * 
	 * @return The revenue
	 */
	double dailyRevenueDataByHour(String date, int hour){
		double revenue=0;
		return revenue;
	}
	
	/**
	 * Returns the percentage of the total daily revenue that is due to
	 * the sale of a specified food item on a specified date
	 * 
	 * @param String foodName  name of the food 
	 * @param date  In the format <code>MM-DD-YYYY</code>
	 * @return The percentage
	 */
	double dailyRevenuePercentagePerItem(String foodName, String date){
		double percent=0;
		return percent;
	}
	
	/**
	 * Returns the percentage of the total hourly revenue that is due to
	 * the sale of a specified food item on a specified date on
	 * a specified hour
	 * 
	 * @param foodName name of the food
	 * @param date  In the format <code>MM-DD-YYYY</code>
	 * @param hour  In the format 0=midnight, 2=2:00am, 12=noon,
	 *  14=2:00pm, and 23=11:00pm.  Specifying 1:00pm means the hour
	 *  between 1:00pm and 2:00pm 
	 * @return The percentage
	 */
	double dailyRevenuePercentagePerItemByHour(String foodName, String date, int hour){
		double percent=0;
		return percent;
	}
	
	/**
	 * Returns the total number of customers on a specified date
	 * 
	 * @param date  In the format <code>MM-DD-YYYY</code>
	 * @return Number of customers
	 */
	int dailyTotalCustomers(String date){
		int total=0;
		return total;
	}
	
	/**
	 * Returns the total number of customers on a specified date in a 
	 * specified hour
	 * 
	 * @param date  In the format <code>MM-DD-YYYY</code>
	 * @param hour  In the format 0=midnight, 2=2:00am, 12=noon,
	 *  14=2:00pm, and 23=11:00pm.  Specifying 1:00pm means the hour
	 *  between 1:00pm and 2:00pm 
	 * @return Number of customers
	 */
	int dailyTotalCustomersByHour(String date, int hour){
		int total=0;
		return total;
	}
	
	/**
	 * Returns the average number of customers per table on a
	 * specified date
	 * 
	 * @param date  In the format <code>MM-DD-YYYY</code>
	 * @return Average number of customers
	 */
	double dailyAvgCustomersPerTable(String date){
		double avg=0;
		return avg;
	}
	
	/**
	 * Returns the average number of customers per table on a
	 * specified date in a specified hour
	 * 
	 * @param date  In the format <code>MM-DD-YYYY</code>
	 * @param hour  In the format 0=midnight, 2=2:00am, 12=noon,
	 *  14=2:00pm, and 23=11:00pm.  Specifying 1:00pm means the hour
	 *  between 1:00pm and 2:00pm
	 * @return Average number of customers
	 */
	double dailyAvgCustomersPerTableByHour(String date, int hour){
		double avg=0;
		return avg;
	}
	
	/**
	 * Returns the average revenue per table on a specified date
	 * 
	 * @param date  In the format <code>MM-DD-YYYY</code>
	 * @return Average revenue per table
	 */
	double dailyAvgRevenuePerTable(String date){
		double avg=0;
		return avg;
	}
	
	/**
	 * Returns the average revenue per table on a specified date
	 * in a specified hour
	 * 
	 * @param date  In the format <code>MM-DD-YYYY</code>
	 * @param hour  In the format 0=midnight, 2=2:00am, 12=noon,
	 *  14=2:00pm, and 23=11:00pm.  Specifying 1:00pm means the hour
	 *  between 1:00pm and 2:00pm
	 * @return Average revenue per table
	 */
	double dailyAvgRevenuePerTableByHour(String date, int hour){
		double avg=0;
		return avg;
	}
	
	
	/**
	 * Returns the average turnaround time on a specified date
	 * 
	 * @param date  In the format <code>MM-DD-YYYY</code>
	 * @return Average turnaround time in minutes
	 */
	double dailyAvgTurnAroundTime(String date)
	{
		double avg=0;
		return avg;
	}
	
	/**
	 * Returns the average turnaround time on a specified date
	 * in a specified hour
	 * 
	 * @param date  In the format <code>MM-DD-YYYY</code>
	 * @param hour  In the format 0=midnight, 2=2:00am, 12=noon,
	 *  14=2:00pm, and 23=11:00pm.  Specifying 1:00pm means the hour
	 *  between 1:00pm and 2:00pm
	 * @return Average turnaround time in minutes
	 */
	double dailyAvgTurnAroundTimeByHour(String date, int hour)
	{
		double avg=0;
		return avg;
	}
	
	/**
	 * Returns the average preparation time on a specified date
	 * 
	 * @param date  In the format <code>MM-DD-YYYY</code>
	 * @return Average preparation time in minutes
	 */
	double dailyAvgPerparationTime(String date)
	{
		double avg=0;
		return avg;
	}
	
	/**
	 * Returns the average preparation time on a specified date
	 * in a specified hour
	 * 
	 * @param date  In the format <code>MM-DD-YYYY</code>
	 * @param hour  In the format 0=midnight, 2=2:00am, 12=noon,
	 *  14=2:00pm, and 23=11:00pm.  Specifying 1:00pm means the hour
	 *  between 1:00pm and 2:00pm
	 * @return Average preparation time in minutes
	 */
	double dailyAvgPerparationTimeByHour(String date, int hour)
	{
		double avg=0;
		return avg;
	}
	
	/**
	 * Returns a list of all Food in the database for a specified date
	 * 
	 * @param date  In the format <code>MM-DD-YYYY</code>
	 * @return list of the names of all food
	 */
	List<String> dailyListAllFood(String date){
		List<String> food=new LinkedList<String>();
		return food;
	}
	
	/**
	 * Returns the price of a specified food item
	 * 
	 * @param foodName  Name of the food item
	 * @return The price of the food item
	 */
	double foodPrice(String foodName)
	{
		double price=0;
		return price;
	}
	


	/**
	 * Returns the percentage of the total amount of food items ordered
	 * that is due to the sale of a specified food item on a specified date
	 * 
	 * @param foodName  Name of the food item
	 * @param date  In the format <code>MM-DD-YYYY</code>
	 * @return The percentage
	 */
	double dailyFoodPopularity(String foodName ,String date){
		double popularity=0;
		return popularity;
	}
	
	/**
	 * Returns the percentage of the total amount of food items ordered
	 * that is due to the sale of a specified food item on a specified date
	 * in a specified hour
	 * 
	 * @param foodName  Name of the food item
	 * @param date  In the format <code>MM-DD-YYYY</code>
	 * @param hour  In the format 0=midnight, 2=2:00am, 12=noon,
	 *  14=2:00pm, and 23=11:00pm.  Specifying 1:00pm means the hour
	 *  between 1:00pm and 2:00pm
	 * @return The percentage
	 */
	double dailyFoodPopularityByHour(String foodName, String date, int hour){
		double popularity=0;
		return popularity;
	}

	
	
	/**
	 * Returns a list of all employees that have worked in the restaurant
	 * 
	 * @return List of Accounts
	 */
	List<Account> listEmployees(){
		List<Account> data=new LinkedList<Account>();
		return data;
	}
	
	/**
	 * Returns a list of all employees that have worked in the restaurant
	 * on a specified date
	 * 
	 * @param date  In the format <code>MM-DD-YYYY</code>
	 * @return List of Accounts
	 */
	List<Account> listEmployeesByDate(String date){
		List<Account> data=new LinkedList<Account>();
		return data;
	}
	
	/**
	 * Returns the Account of a specific employee
	 * 
	 * @param username  Username of the employee
	 * @return The Account to be returned
	 */
	
	Account accountData(String username){
		//Account temp= new Account();
		//TODO Write a method to search for accounts and return its type
		//return temp;
		return null;
	}
	
	/**
	 * Returns the Account of a specific employee with the data
	 * from a specified day
	 * 
	 * @param date  In the format <code>MM-DD-YYYY</code>
	 * @param username  Username of the employee
	 * @return The Account to be returned
	 */
	Account dailyAccountData(String date, String username){
		//Account temp=new Account();
		//TODO Write a method to search for the account and date
		//return temp;
		return null;
	}

	/**
	 * Checks if the login information is correct by comparing the
	 * given username and password with that stored in the database.
	 * If the login information is correct, return the account type
	 * of the user.  If it is incorrect, return 0.
	 * 
	 * @param username  The username used to log in
	 * @param password  The password used to log in
	 * @return Returns 0 if the login information is incorrect,
	 * otherwise returns the number corresponding to the account type.
	 */
	int login(String username, String password){
		return 0;
	}
	
	/**
	 * Returns the information about the tables used to create the
	 * floor map
	 * 
	 * @return Returns an array with 3 columns and as many rows as
	 * there are tables.  The first column contains the table number,
	 * and the next two columns contain the x and y location of the
	 * table on the floor map.
	 */
	int[][] getMap(){
		int [][] map=new int[3][5];
		return map;
	}
	
	/**
	 * Adds the specified table data to the database.  This entry contains
	 * the table number and location of the table on the floor map.
	 * 
	 * @param tableNum  The number of the table
	 * @param xLocation  The x location of the table on the floor map
	 * @param yLocation  The y location of the table on the floor map
	 */
	void addTable(int tableNum, int xLocation, int yLocation){
		
	}
	
	/**
	 * Removes a specified table's data from the database.
	 * 
	 * @param tableNum  The number of the table to be removed
	 * @return Returns true if the operation was successful,
	 * and returns false if the operation failed.
	 */
	boolean removeTable(int tableNum){
		return true;
	}


	public void sendBill(Bill tableBill) {
		// TODO Auto-generated method stub
	}
	
	public static boolean checkUsername(String s){
		// Insert an if statement to query the database for the user name. Return true if it is found.
		return true;
		
	}
	
	public static boolean checkPassword(String s){
		//Insert an if statement to query the database for the password. Return true if it is found.
		return true;
	}
}