import java.awt.Color;

/**
 * The table class contains all the information on the tables in the resturant,
 * including its status, its occupants, its bill, and more.
 * @author Henry Chao
 */
public class Table {
	/**
	 * An integer which uniquely identify the table.
	 */
	private Integer tableNumber;
	
	/**
	 * A reference to the waiter assigned to the table.
	 */
	private Waiter tableWaiter;
	
	/**
	 * The color of the table indicates its status.
	 * Green - Unoccupied
	 * Yellow - Occupied
	 * Red - Requires Cleaning
	 */
	private Color status;
	
	/**
	 * A reference to the bill for the table.
	 */
	private Bill tableBill = new Bill(tableWaiter, this);
	
	/**
	 * The maximum number of patrons allowed at the table. By default,
	 * this is set to 4.
	 */
	private int maxSeat;
	
	/**
	 * The number of patrons currently seated at the table.
	 */
	private int numSeated;
	
	/**
	 * The row position of the table in the map of the restaurant.
	 */
	private int positionRow;
	
	/**
	 * The column position of the table in the map of the restaurant.
	 */
	private int positionCol;
	
	/**
	 * The default constructor for the Table class. It is mainly used by the
	 * RecordKeeper class to pull data from the database and populate the
	 * tables used in the map of the restaurant.
	 * @param tableNum A unique integer identifier of the table.
	 * @param maxSeated The maximum number of people allowed at the table. The default is 4.
	 * @param name The name of the waiter assigned to the table.
	 * @param posR The row position of the table in the map of the restaurant.
	 * @param posC The column position of the table in the map of the restaurant.
	 * @param stat An integer number associated with the status of the table.
	 * Green = 0;
	 * Yellow = 1;
	 * Red = 2;
	 * @param ns The number of people seated at the table.
	 */
	Table(int tableNum, int maxSeated, String name, int posR, int posC, int stat, int ns){
		tableNumber = tableNum;
		maxSeat = maxSeated;
		switch(stat){
			case 0: {status = Color.green; break;}
			case 1: {status = Color.yellow; break;}
			case 2: {status = Color.red; break;}
			default: {status = Color.red; break;}
		}
		tableWaiter = new Waiter(name, 0);
		tableBill = new Bill(tableWaiter, this);;
		positionRow = posR;
		positionCol = posC;
		numSeated = ns;
	}

	int setTable(int num_Diners){
		if (num_Diners <= maxSeat){
			status = Color.yellow;
			return 1;
		}
		else 
			return 0;
	}
	
	void setTableNumber(int i){tableNumber = i;}
	
	Integer getTableNumber(){return tableNumber;}
		
	Bill returnBill(){return tableBill;}
	
	void setStatus(Color stat){
		status = stat;
		DataKeeper.updatesTableInDatabase(this);
	}
	Color getStatus(){return status;}
	
	/**
	 * Sets the number of people seated at the table.
	 * @param i An integer representing the number of people seated at the table.
	 */
	void setNumSeat(int i){
		if(numSeated <= maxSeat) numSeated = i;
		else numSeated = -1;
		DataKeeper.updatesTableInDatabase(this);
	}
	int getNumSeat(){return numSeated;}
	
	/**
	 * Sets the status of the table to clean.
	 */
	void cleanedTable(){
		status = Color.green;
		numSeated = 0;
		//DataKeeper.restaurantRecord.sendBill(tableBill);
		tableBill = null;
		DataKeeper.updatesTableInDatabase(this);
	}
	
	/**
	 * Assigns a waiter and sets the number of people seated at the table.
	 * @param s The name of the waiter.
	 * @param n The number of people seated at the table.
	 */
	void assignedTable(String s, int n){
		status = Color.yellow;
		tableWaiter.setName(s);
		numSeated = n;
		DataKeeper.updatesTableInDatabase(this);
	}
	
	int getPosRow(){
		return positionRow;
	}
	
	int getPosCol(){
		return positionCol;
	}
	
	Bill getTableBill(){
		return tableBill;
	}

	public String getName() {
		return tableWaiter.getName();
	}
}
