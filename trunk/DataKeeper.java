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
	
	public static void updatesTableInDatabase(Table t){
		restaurantRecord.updatesTable(t);
	}
	
	public static int[] getSizeOfMenu(){
		return restaurantRecord.getMenuSize();
	}
	
	public static LinkedList<String> getListOfMenu(){
		return restaurantRecord.getMenuItems();
	}

	public String[] getListOfWaiters() {
		return restaurantRecord.getWaiterList();
	}

}
