import java.util.Queue;

/**
 * The Chef class extends the Account class. 
 * Chefs have an orderQueue for the food that they are preparing. 
 * Chefs add an order from the main Kitchen queue to the Chefs' 
 * private queues. 
 */

public class Chef extends Account {

	/** 
	 * Chef's private Queue<Order>
	 */
	private Queue<Order> orderQ;
	
	public Chef(String named, float pay) {
		super(named, pay);
	}
	
	/** 
	 * Removes an order from the kitchen queue and
	 * places it in the chef's queue.
	 * If an error occurs, -1 is returned. 
	 * 
	 * @param Order o to add to the Chef's queue.
	 * @return 0 success, -1 error
	 */
	
	public int addOrder() {
		return 0;
	}
	
	/**
	 * Removes an order from the chef's queue and
	 * sets the status of the order as done in the
	 * bill.
	 * 
	 * @param Order o 
	 * @return 0 success, -1 error
	 */
	
	public int finishOrder() {
		return 0;
	}
}
