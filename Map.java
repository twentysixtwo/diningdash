import java.util.LinkedList;

public class Map {
	private LinkedList<Table> resturantTables = new LinkedList<Table>();
	
	private int TotalRows;
	private int TotalCols;
	
	/**
	 * Default constructor for Map class. It will call the database to get the information regarding the
	 * location of the tables in the restaurant. To change the size of the restaurants, you must
	 * change the values in the constructors.
	 */
	public Map(){
		TotalRows = 11;
		TotalCols = 11;
		addTables();
	}
	
	/**
	 * Adds the tables in the restaurant. Each table will instantiate a new table. As a reminder, the arguments are
	 * <Table number, max number of people allowed at the table, waiter name, row position, col position>
	 */
	private void addTables(){
		resturantTables = RecordKeeper.getMap();
	}
	
	/**
	 * Returns the total number of rows in the map of the restaurant.
	 * @return An integer value for the number of rows.
	 */
	public int getTotalRows(){
		return TotalRows;
	}
	
	/**
	 * Returns the total number of columns in the map of the restaurant.
	 * @return An integer value of the number of columns.
	 */
	public int getTotalCols(){
		return TotalCols;
	}
	
	/**
	 * Returns a linked list of tables in the restaurant. The linked list
	 * will be used to provide up-to date information regarding table statuses. 
	 * @return A linked list of tables in the restaurant.
	 */
	public LinkedList<Table> getTableList(){
		return RecordKeeper.getMap();
	}
}
