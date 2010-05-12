import java.util.*;
import java.awt.Color;
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
	 * Path of the database file
	 */
	String databasePath = System.getProperty("user.dir") + "\\src\\RestaurantDatabase.mdb";
	
	/**
	 * Connection to the database file
	 */
	static Connection con;
	
	/**
	 * Constructor for the RecordKeeper class.  This constructor connects
	 * to the database.
	 */
	RecordKeeper(){
		connectToDatabase();
	}
	
	
	
	/**
	 * Connects to the database file
	 */
	void connectToDatabase(){
		try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            // set this to a MS Access DB you have on your machine
            String url = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb)};DBQ="+databasePath;
            // now we can get the connection from the DriverManager
            con = DriverManager.getConnection( url ,"","");
        }

            catch (Exception e) {
            System.out.println("Error: " + e);
        }
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
		ResultSet rs;
		try {
			Statement s = con.createStatement();
			s.execute("select Username from Accounts where Username='"+newAccount.getName()+"'");
			rs=s.getResultSet();
			if (rs.next()==true)
			{
				return false;
			}
			else
			{
				s.executeUpdate("insert into Accounts values('"+newAccount.getName()+"','"+newAccount.name+"','"+password+"','"+newAccount.day+"',"+newAccount.payRate+","+newAccount.startTime+","+newAccount.endTime+","+newAccount.employeeID+","+newAccount.type+")");
				s.execute("select * from Map where TableNumber=-1");
			}
		}

		catch (Exception e) {
            System.out.println("Error: " + e);
		}
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
		ResultSet rs;
		try {
			Statement s = con.createStatement();
			s.execute("select Name from Food where Name='"+name+"'");
			rs=s.getResultSet();
			if (rs.next()==true)
			{
				s.executeUpdate("update Food set Price="+price+ " where Name='"+name+"'");
				s.execute("select * from Map where TableNumber=-1");
				s.executeUpdate("update Food set Day='"+date+ "' where Name='"+name+"'");
				s.execute("select * from Map where TableNumber=-1");
			}
			else
			{
				s.executeUpdate("insert into Food values('"+name+"',"+price+",'"+date+"')");
				s.execute("select * from Map where TableNumber=-1");
			}
		}

		catch (Exception e) {
            System.out.println("Error: " + e);
		}
		
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
		ResultSet rs;
		try {
			Statement s = con.createStatement();
			s.execute("select Price from Food where Name='"+foodName+"'");
			rs=s.getResultSet();
			if (rs.next()==true)
			{
				return rs.getDouble(1);
			}
			else
			{
				return 0;

			}
			
		}
		catch (Exception e) {System.out.println("exception: "+e);}
		return 0;
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

	
	/*
	 * This method is no longer necessary 
	/**
	 * Returns a list of all employees that have worked in the restaurant
	 * 
	 * @return List of Accounts
	 
	List<Account> listEmployees(){
		List<Account> data=new LinkedList<Account>();
		return data;
	}
	*/
	
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
	 * 
	 * Account type 1 = Busboy
	 * Account type 2 = Host
	 * Account type 3 = Waiter
	 */
	int login(String username, char[] p){
		String password = new String(p);
		System.out.println(password);
		ResultSet rs;
		try {
			Statement s = con.createStatement();
			s.execute("select Type from Accounts where Username='"+username+"' and Password='"+password+"'");
			rs=s.getResultSet();
			if (rs.next()==true)
			{
				return rs.getInt(1);
			}
			else
			{
				return 0;

			}
			
		}
		catch (Exception e) {System.out.println("exception: "+e);};
		return 0;
	}
	
	/**
	 * Returns the information about the tables used to create the
	 * floor map
	 * 
	 * As a reminder, the arguments are
	 * <Table number, max number of people allowed at the table, waiter name, row position, col position>
	 * 
	 * @return 
	 */
	public static LinkedList<Table> getMap(){
		LinkedList<Table> tableList = new LinkedList<Table>();
		ResultSet rs;
		try {
			Statement s = con.createStatement();
			s.execute("select * from Map");
			rs=s.getResultSet();
			while (rs.next() == true)
			{
				Table t = new Table(rs.getInt(1), 4, rs.getString(6), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
				tableList.add(t);
			}
		}
		catch (Exception e) {System.out.println("exception: "+e);};
		return tableList;
	}
	
	/**
	 * Adds the specified table data to the database.  This entry contains
	 * the table number and location of the table on the floor map.  If the
	 * table number already exists, updates that table with the new row
	 * and column information.
	 * 
	 * @param tableNum  The number of the table
	 * @param xLocation  The x location of the table on the floor map
	 * @param yLocation  The y location of the table on the floor map
	 */
	void addTable(int tableNum, int row, int col){
		ResultSet rs;
		try {
			Statement s = con.createStatement();
			s.execute("select TableNumber from Map where TableNumber="+tableNum+"");
			rs=s.getResultSet();
			if (rs.next()==true)
			{
				s.executeUpdate("update Map set Row="+row+ " where TableNumber="+tableNum+"");
				s.execute("select * from Map where TableNumber=-1");
				s.executeUpdate("update Map set Col="+col+ " where TableNumber="+tableNum+"");
				s.execute("select * from Map where TableNumber=-1");
			}
			else
			{
				s.executeUpdate("insert into Map values("+tableNum+","+row+","+col+")");
				s.execute("select * from Map where TableNumber=-1");

			}
			
		}
		catch (Exception e) {System.out.println("exception: "+e);}
	}
	
	/**
	 * Removes a specified table's data from the database.
	 * 
	 * @param tableNum  The number of the table to be removed
	 * @return Returns true if the operation was successful,
	 * and returns false if the operation failed.
	 */
	boolean removeTable(int tableNum){
		try {
			Statement s = con.createStatement();
			s.executeUpdate("delete from Map where TableNumber="+tableNum+"");
			s.execute("select * from Map where TableNumber=-1");
		}
		catch (Exception e) {System.out.println("exception: "+e);}
		
		
		return true;
	}


	public void sendBill(Bill tableBill) {
		// TODO Auto-generated method stub
	}
	
	
	/* Just use login()
	public static boolean checkUsername(String s){
		// Insert an if statement to query the database for the user name. Return true if it is found.
		return true;
		
	}
	
	public static boolean checkPassword(String s){
		//Insert an if statement to query the database for the password. Return true if it is found.
		return true;
	}*/
	
	public void updatesTable(Table t){
		/*
		 * Queries the database by the table number of t. Then updates the record in the database with
		 * the new t.
		 */
		ResultSet rs;
		try {
			Statement s = con.createStatement();
			s.execute("select TableNumber from Map where TableNumber="+t.getTableNumber()+"");
			rs=s.getResultSet();
			if (rs.next()==true)
			{
				s.executeUpdate("update Map set Row="+t.getPosRow()+ " where TableNumber="+t.getTableNumber()+"");
				s.execute("select * from Map where TableNumber=-1");
				s.executeUpdate("update Map set Col="+t.getPosCol()+ " where TableNumber="+t.getTableNumber()+"");
				s.execute("select * from Map where TableNumber=-1");
				s.executeUpdate("update Map set Seated="+t.getNumSeat()+ " where TableNumber="+t.getTableNumber()+"");
				s.execute("select * from Map where TableNumber=-1");
				s.executeUpdate("update Map set WaiterName='"+t.getName()+ "' where TableNumber="+t.getTableNumber()+"");
				s.execute("select * from Map where TableNumber=-1");
				if(t.getStatus() == Color.green){
					s.executeUpdate("update Map set Status="+ 0 + " where TableNumber="+t.getTableNumber()+"");
					s.execute("select * from Map where TableNumber=-1");
				}
				else if(t.getStatus() == Color.yellow){
					s.executeUpdate("update Map set Status="+ 1 + " where TableNumber="+t.getTableNumber()+"");
					s.execute("select * from Map where TableNumber=-1");
				}
				else if(t.getStatus() == Color.red){
					s.executeUpdate("update Map set Status="+ 2 + " where TableNumber="+t.getTableNumber()+"");
					s.execute("select * from Map where TableNumber=-1");
				}
			}
		}
		catch (Exception e) {System.out.println("exception: "+e);}
	}
	
	
	
	
	public int[] getMenuSize(){
		/*
		 * Queries the database to get the size of the menu. Return row then column in an array
		 */
		int count=0;
		try {
			Statement s=con.createStatement();
			s.execute("select * from Food");
			ResultSet rs= s.getResultSet();
			while (rs.next())
			{
				count++;
			}
		}catch (Exception e) {}
		int ret[]=new int[2];
		ret[0]=count;
		ret[1]=3;
		return ret;
	}
	
	public LinkedList<String> getMenuItems(){
		LinkedList<String> foodOnMenu = new LinkedList<String>();
		try {
			Statement s=con.createStatement();
			s.execute("select * from Food");
			ResultSet rs= s.getResultSet();
			while (rs.next())
			{
				foodOnMenu.add(rs.getString(1));
			}
		}catch (Exception e) {}
		
		return foodOnMenu;
	}



	public String[] getWaiterList() {
		String[] str = new String[10];
		str[0] = "Select Waiter";
		int i = 1;
		try {
			Statement s=con.createStatement();
			s.execute("select Name from Accounts where Type=3");
			ResultSet rs= s.getResultSet();
			while (rs.next())
			{
				str[i++] = rs.getString(1);
			}
		}catch (Exception e) {}
		return str;
	}
}