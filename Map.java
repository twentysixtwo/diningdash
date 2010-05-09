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
		TotalRows = 7;
		TotalCols = 5;
		addTables();
	}
	
	/**
	 * Adds the tables in the restaurant. Each table will instantiate a new table. As a reminder, the arguments are
	 * <Table number, max number of people in the table, waiter name, row position, col position>
	 */
	private void addTables(){
		Table t1 = new Table(1, 4, null, 1, 1);
		t1.setStatus(Color.red);
			resturantTables.add(t1);
		Table t2 = new Table(2, 4, null, 1, 3);
			resturantTables.add(t2);
		Table t3 = new Table(3, 4, null, 3, 1);
		t3.setStatus(Color.yellow);
			resturantTables.add(t3);
		Table t4 = new Table(4, 4, null, 3, 3);
			resturantTables.add(t4);
		Table t5 = new Table(5, 4, null, 5, 1);
			resturantTables.add(t5);
		Table t6 = new Table(6, 4, null, 5, 3);
		t6.setStatus(Color.red);
			resturantTables.add(t6);
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
