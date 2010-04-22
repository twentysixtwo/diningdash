import java.util.*;
import java.sql.*;

class Account{
	
}
class Bill{

}
class Food{
	
}

/**
 * The RecordKeeper class manages the database.  The database includes
 * Bill, Account, Food, and login data.  The RecordKeeper class also uses the 
 * database to provide daily and hourly statistics of the restaurant.
 *
 */
public class RecordKeeper {

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
	 * @param Bill newBill  the Bill to be added
	 */
	void addBill(Bill newBill){
		
	}
	
	/**
	 * Adds the data in the Account object to the database
	 * If that account already exists in the database, that data is overwritten
	 * 
	 * @param Account newAccount  the Account to be added
	 */
	void addAccount(Account newAccount)
	{
		
	}

	/**
	 * Adds a new user to the database.  This creates the data that's used to login,
	 * including setting the password.  This fails if the account name already exists.
	 * 
	 * @param Account newAccount  the account to add
	 * @param String password  the password for the account to add
	 * @return boolean  Returns true if successful, and false if unsuccessful
	 */
	boolean addUser(Account newAccount, String password)
	{
		return true;
	}


	/**
	 * Adds the data to the table of food for a specified date in the database
	 * 
	 * @param String name  name of the food to be added
	 * @param double price  price of the food to be added
	 * @param String date  In the format <code>MM-DD-YYYY</code>
	 */
	void addFood(String name, double price, String date)
	{
		
	}
	
	
	/**
	 * Returns the revenue for the restaurant on a specified date
	 * 
	 * @param String date  In the format <code>MM-DD-YYYY</code>
	 * @return double  The revenue
	 */
	double dailyRevenueData(String date){
		double revenue=0;
		return revenue;
	}
	
	/**
	 * Returns the revenue for the restaurant on a specified date in
	 * a specified hour.  Specifying 1:00pm means the hour between
	 * 1:00pm and 2:00pm
	 * 
	 * @param String date  In the format <code>MM-DD-YYYY</code>
	 * @param int hour  In the format 0=midnight, 2=2:00am, 12=noon,
	 *  14=2:00pm, and 23=11:00pm 
	 * 
	 * @return double  The revenue
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
	 * @param String date  In the format <code>MM-DD-YYYY</code>
	 * @return double  The percentage
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
	 * @param String foodName name of the food
	 * @param String date  In the format <code>MM-DD-YYYY</code>
	 * @param int hour  In the format 0=midnight, 2=2:00am, 12=noon,
	 *  14=2:00pm, and 23=11:00pm 
	 * @return double  The percentage
	 */
	double dailyRevenuePercentagePerItemByHour(String foodName, String date, int hour){
		double percent=0;
		return percent;
	}
	
	/**
	 * Returns the total number of customers on a specified date
	 * 
	 * @param String date  In the format <code>MM-DD-YYYY</code>
	 * @return int  Number of customers
	 */
	int dailyTotalCustomers(String date){
		int total=0;
		return total;
	}
	
	/**
	 * Returns the total number of customers on a specified date in a 
	 * specified hour
	 * 
	 * @param String date  In the format <code>MM-DD-YYYY</code>
	 * @param int hour  In the format 0=midnight, 2=2:00am, 12=noon,
	 *  14=2:00pm, and 23=11:00pm 
	 * @return int  Number of customers
	 */
	int dailyTotalCustomersByHour(String date, int hour){
		int total=0;
		return total;
	}
	
	/**
	 * Returns the average number of customers per table on a
	 * specified date
	 * 
	 * @param String date  In the format <code>MM-DD-YYYY</code>
	 * @return double  Average number of customers
	 */
	double dailyAvgCustomersPerTable(String date){
		double avg=0;
		return avg;
	}
	
	/**
	 * Returns the average number of customers per table on a
	 * specified date in a specified hour
	 * 
	 * @param String date  In the format <code>MM-DD-YYYY</code>
	 * @param int hour  In the format 0=midnight, 2=2:00am, 12=noon,
	 *  14=2:00pm, and 23=11:00pm
	 * @return double   Average number of customers
	 */
	double dailyAvgCustomersPerTableByHour(String date, int hour){
		double avg=0;
		return avg;
	}
	
	/**
	 * Returns the average revenue per table on a specified date
	 * 
	 * @param String date  In the format <code>MM-DD-YYYY</code>
	 * @return double  Average revenue per table
	 */
	double dailyAvgRevenuePerTable(String date){
		double avg=0;
		return avg;
	}
	
	/**
	 * Returns the average revenue per table on a specified date
	 * in a specified hour
	 * 
	 * @param String date  In the format <code>MM-DD-YYYY</code>
	 * @param int hour  In the format 0=midnight, 2=2:00am, 12=noon,
	 *  14=2:00pm, and 23=11:00pm
	 * @return double  Average revenue per table
	 */
	double dailyAvgRevenuePerTableByHour(String date, int hour){
		double avg=0;
		return avg;
	}
	
	
	/**
	 * Returns the average turnaround time on a specified date
	 * 
	 * @param String date  In the format <code>MM-DD-YYYY</code>
	 * @return double  Average turnaround time in minutes
	 */
	double DailyAvgTurnAroundTime(String date)
	{
		double avg=0;
		return avg;
	}
	
	/**
	 * Returns the average turnaround time on a specified date
	 * in a specified hour
	 * 
	 * @param String date  In the format <code>MM-DD-YYYY</code>
	 * @param int hour  In the format 0=midnight, 2=2:00am, 12=noon,
	 *  14=2:00pm, and 23=11:00pm
	 * @return double  Average turnaround time in minutes
	 */
	double DailyAvgTurnAroundTimeByHour(String date, int hour)
	{
		double avg=0;
		return avg;
	}
	
	/**
	 * Returns the average preparation time on a specified date
	 * 
	 * @param String date  In the format <code>MM-DD-YYYY</code>
	 * @return double  Average preparation time in minutes
	 */
	double DailyAvgPerparationTime(String date)
	{
		double avg=0;
		return avg;
	}
	
	/**
	 * Returns the average preparation time on a specified date
	 * in a specified hour
	 * 
	 * @param String date  In the format <code>MM-DD-YYYY</code>
	 * @param int hour  In the format 0=midnight, 2=2:00am, 12=noon,
	 *  14=2:00pm, and 23=11:00pm
	 * @return double  Average preparation time in minutes
	 */
	double DailyAvgPerparationTimeByHour(String date, int hour)
	{
		double avg=0;
		return avg;
	}
	
	/**
	 * Returns a list of all Food in the database for a specified date
	 * 
	 * @param String date  In the format <code>MM-DD-YYYY</code>
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
	 * @return double  The price of the food item
	 */
	double FoodPrice(String foodName)
	{
		double price=0;
		return price;
	}
	


	/**
	 * Returns the percentage of the total amount of food items ordered
	 * that is due to the sale of a specified food item on a specified date
	 * 
	 * @param String foodName  Name of the food item
	 * @param String date  In the format <code>MM-DD-YYYY</code>
	 * @return double  The percentage
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
	 * @param String foodName  Name of the food item
	 * @param String date  In the format <code>MM-DD-YYYY</code>
	 * @param int hour  In the format 0=midnight, 2=2:00am, 12=noon,
	 *  14=2:00pm, and 23=11:00pm
	 * @return double  The percentage
	 */
	double dailyFoodPopularityByHour(String foodName, String date, int hour){
		double popularity=0;
		return popularity;
	}

	
	
	/**
	 * Returns a list of all employees that have worked in the restaurant
	 * 
	 * @return List&ltAccount>  List of Accounts
	 */
	List<Account> listEmployees(){
		List<Account> data=new LinkedList<Account>();
		return data;
	}
	
	/**
	 * Returns a list of all employees that have worked in the restaurant
	 * on a specified date
	 * 
	 * @param String date  In the format <code>MM-DD-YYYY</code>
	 * @return List&ltAccount>  List of Accounts
	 */
	List<Account> listEmployeesByDate(String date){
		List<Account> data=new LinkedList<Account>();
		return data;
	}
	
	/**
	 * Returns the Account of a specific employee
	 * 
	 * @param String username  Username of the employee
	 * @return Account  Account to be returned
	 */
	Account AccountData(String username){
		Account temp=new Account();
		return temp;
	}
	
	/**
	 * Returns the Account of a specific employee with the data
	 * from a specified day
	 * 
	 * @param String date  In the format <code>MM-DD-YYYY</code>
	 * @param String username  Username of the employee
	 * @return
	 */
	Account dailyAccountData(String date, String username){
		Account temp=new Account();
		return temp;
	}

	/**
	 * Checks if the login information is correct by comparing the
	 * given username and password with that stored in the database.
	 * If the login information is correct, return the account type
	 * of the user.  If it is incorrect, return 0.
	 * 
	 * @param String username
	 * @param String password
	 * @return int  Returns 0 if the login information is incorrect,
	 * otherwise returns the number corresponding to the account type.
	 */
	int login(String username, String password){
		return 0;
	}
	
		
}
