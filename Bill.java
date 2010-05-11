import java.util.LinkedList;

/**
 * The bill class contains a linked list of orders. It is the bill associated with a table.
 * @author Henry
 *
 */

public class Bill {
	
	/**
	 * A linked list of orders.
	 */
	private LinkedList<Order> orders;
	
	/**
	 * Indicates if all the orders are finished or not. When all orders are done, will notify a waiter
	 */
	private Boolean isCooked;
	
	/**
	 * The tab of the table. Contains the sum of the prices of each order.
	 */
	private double tab;
	
	/**
	 * A reference to the waiter of the table.
	 */
	private Waiter itsWaiter;
	
	/**
	 * The number of people sitting at the table.
	 */
	private int numOfPeople;
	
	/**
	 * A reference to the table the bill belongs to
	 */
	private Table itsTable;
	
	/**
	 * The time the customers are seated.
	 */
	private long startTime;
	
	/**
	 * The time the customers finished.
	 */
	private long endTime;
	
	/**
	 * Default constructor of the bill.
	 * @param waiterName The waiter of the table.
	 * @param t A reference to the table the bill belongs to.
	 */
	public Bill(Waiter waiterName, Table t){
		itsWaiter = waiterName;
		itsTable = t;
		isCooked = false;
		orders = new LinkedList<Order>();
	}
	
	/**
	 * Adds an order to the bill. Will get the price of the order and automatically
	 * add it to the tab of the bill. Additionally, it will place the order into the
	 * global kitchen queue to be cooked.
	 * 
	 * @param name The name of the food being added to the bill
	 * @param comment Any comment regarding the order being place
	 */
	public void addOrder(String name, String comment){
		Order o = new Order(name, comment, this);
		tab += o.getPrice();
		try{
			orders.add(o);
			DataKeeper.globalKitchen.addToQueue(o);
			System.out.println("Order placed");
		}
		catch (Exception e){System.out.println("Some error occured");}
	}
	
	/**
	 * Will try to remove the order from the global queue first. If it does not
	 * find it in the global queue, either one of the arguments is incorrect, or
	 * it is not in the queue anymore (which may suggest a cook is working on it).
	 * 
	 * @param name The name of the order to remove
	 * @param comment The comment of the order it wants to remove
	 * @return Returns false if it is not in the global queue. Returns false if it 
	 * cannot find it in the order. Returns true if it removes from both the global queue and the order.
	 */
	public boolean removeOrder(String name, String comment){
		Order o = new Order(name, comment, this);
		if(DataKeeper.globalKitchen.searchAndRemoveGlobalQueue(o) == false)
			return false;
		tab -= o.getPrice();
		return (orders.remove(o));
	}
	
	/**
	 * Returns the status of the bill, indicating if all orders are completed or not.
	 * @return A boolean value indicating if all orders are completed or not.
	 */
	public Boolean getStatus(){return isCooked;}
	
	/**
	 * Sets the status of the bill.
	 * @param b A boolean value indicating if all orders are complete or not.
	 */
	public void setStatus(Boolean b){isCooked = b;}
	
	/**
	 * Returns the tab of the order.
	 * @return The tab of the order as a double.
	 */
	public double returnTab(){return tab;}
	
	/**
	 * Sets the startTime to the current time (in milliseconds).
	 */
	public void setStartTime(){startTime = System.currentTimeMillis();}
	
	/**
	 * Gets the start time (in milliseconds).
	 * @return The startTime as a long.
	 */
	public long getStartTime(){return startTime;}
	
	/**
	 * Sets the endTime to the current time (in milliseconds).
	 */
	public void setEndTime(){endTime = System.currentTimeMillis();}
	
	/**
	 * Gets the end time (in milliseconds).
	 * @return The endTime as a long.
	 */
	public long getEndTime(){return endTime;}
	
	public LinkedList<Order> getOrders(){
		return orders;
	}
		
}
