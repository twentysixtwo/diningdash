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
	public static Kitchen globalKitchen;
	
	/**
	 * Contains the map of the restaurant.
	 */
	public static Map restaurantMap;
	
	public static RecordKeeper restaurantRecord;
	
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
		RecordKeeper rec=new RecordKeeper();
		rec.updatesTable(t);
	}
	
	public static int[] getSizeOfMenu(){
		RecordKeeper rec=new RecordKeeper();
		return rec.getMenuSize();
	}
	
	public static LinkedList<String> getListOfMenu(){
		RecordKeeper rec=new RecordKeeper();
		return rec.getMenuItems();
	}

}
