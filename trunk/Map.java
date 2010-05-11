import java.awt.Color;
import java.util.LinkedList;


public class Map {
	private LinkedList<Table> resturantTables = new LinkedList<Table>();
	
	private int TotalRows;
	private int TotalCols;
	
	/**
	 * Default constructor for Map class
	 */
	public Map(){
		TotalRows = 17;
		TotalCols = 15;
		addTables();
	}
	
	/**
	 * Adds the tables in the restaurant. Each table will instantiate a new table. As a reminder, the arguments are
	 * <Table number, max number of people allowed at the table, waiter name, row position, col position>
	 */
	private void addTables(){
		resturantTables = RecordKeeper.getMap();
	}
	
	public int getTotalRows(){
		return TotalRows;
	}
	
	public int getTotalCols(){
		return TotalCols;
	}
	
	public LinkedList<Table> getTableList(){
		return resturantTables;
	}
}
