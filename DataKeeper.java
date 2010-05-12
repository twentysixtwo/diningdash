import java.util.LinkedList;

/**
 * The DataKeeper class contains all the functions to be called from 
 * the other subsystems.
 * @author Henry Chao
 *
 */

public class DataKeeper {
	
	/**
	 * Contains the global kitchen queue to be accessed by the chefs.
	 */
	public static Kitchen globalKitchen;
	
	/**
	 * Contains the map of the restaurant.
	 */
	public static Map restaurantMap;
	
	/**
	 * A new instance of the RecordKeeper class. Instantiates a new
	 * copy and loads in the necessary information from the database.
	 */
	public static RecordKeeper restaurantRecord = new RecordKeeper();
	
	/**
	 * Default constructor for DataKeeper. Will instantiate a new kitchen and map object.
	 */
	public DataKeeper(){
		globalKitchen = new Kitchen();
		restaurantMap = new Map();
	}
	
	/**
	 * Generates a linked list of tables to return.
	 * @return A list of tables as a linked list.
	 */
	public LinkedList<Table> getTables(){
		return restaurantMap.getTableList();
	}
	
	/**
	 * Updates the information for table, such as the Bill or the number
	 * of occupants, in the database.
	 * @param t The table t which has just changed and needs to update.
	 */
	public static void updatesTableInDatabase(Table t){
		restaurantRecord.updatesTable(t);
	}
	
	/**
	 * Gets the size of the menu in terms of the rows and columns in
	 * the menu.
	 * @return An array of integers, where the first element is the number
	 * of rows and the second is the number of columns.
	 */
	public static int[] getSizeOfMenu(){
		return restaurantRecord.getMenuSize();
	}
	
	/**
	 * Gets a linked list of items contained in the menu.
	 * @return A linked list of Strings with the name and price of
	 * the food item in the menu. 
	 */
	public static LinkedList<String> getListOfMenu(){
		return restaurantRecord.getMenuItems();
	}

	/**
	 * Gets an array of Strings containing the name of the waiters.
	 * @return An array of Strings with the name of the waiters in the
	 * database.
	 */
	public String[] getListOfWaiters() {
		return restaurantRecord.getWaiterList();
	}

}
