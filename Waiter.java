/**
 * The Waiter class extends the Account class.
 * Waiters have a tip attribute.
 * Waiters will have functions to deal with bills, orders, and the table.
 */

public class Waiter extends Account  {
	
	private String name;
	
	/**
	 * Tips for the day. Tips are added when each bill is placed into the database.
	 */
	private float tips;
	
	/**
	 * Bill for the currently selected table.
	 */
	//private Bill currentBill;
	
	public Waiter(String named, float pay) {
		super(named, pay);
		name = named;
	}
	
	/**
	 * Displays the bill information for the selected table.
	 * Sets the current bill attribute.
	 * Errors if table number is invalid. 
	 * @param tableNumber 
	 * @return 0 success, -1 error
	 */
	public int getBill(int tableNumber) {
		//currentBill = bill;
		return 0;
	}
	
	/**
	 * Adds an order to the bill. Takes in the name of the food and 
	 * any specific comments for the food. 
	 * @param comment 
	 * @param name Name of the food to be added
	 * @return 0 success, -1 error
	 */
	public int addOrder(String name, String comment){
		return 0;
	}
	
	/**
	 * Removes an order from the table's bill. Checks to ensure currentBill is the
	 * table's bill. Then deletes one of the named items from the order list.
	 * Errors if the food is not in the order.
	 * (Food already ready?)
	 * @param name name of the food item
	 * @param tableNumber
	 * @return 0 success, -1 error
	 */
	public int removeOrder(String name, int tableNumber){
		return 0;
	}
	
	/**
	 * Submits the orders from the table to the Kitchen queue to be cooked.
	 * Adds the list of orders in the table's bill to the Kitchen queue.
	 * Errors if orders already added or if there are no orders
	 * @param tableNumber
	 * @return 0 success, -1 error
	 */
	public int submitOrders(int tableNumber){
		return 0;
	}

	/**
	 * After the patrons leave the table, the waiter collects tips and
	 * sets the table to dirty.
	 * Errors if table is unoccupied, already dirty. 
	 * @param tableNumber
	 * @return 0 success, -1 error
	 */
	public int dirtyTable(int tableNumber){
		return 0;
	}
	
	public void setName(String s){
		name = s;
	}
	
	public String getName(){
		return name;
	}
}
