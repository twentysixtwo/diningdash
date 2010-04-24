import java.util.LinkedList;

/**
 * The DataKeeper class contains all the functions to be called from the other subsystems.
 * @author henry
 *
 */

public class DataKeeper {
	
	/**
	 * Contains the global kitchen queue to be accessed by the chefs.
	 */
	private static Kitchen globalKitchen;
	
	/**
	 * Contains the map of the restaurant.
	 */
	private static Map restaurantMap;
	
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
	public LinkedList getTables(){
		LinkedList<Table> listOfTables = new LinkedList<Table>();
		//Fill out more stuff here
		return listOfTables;
	}

}
