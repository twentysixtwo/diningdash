import java.util.LinkedList;


public class Bill {
	private LinkedList<Order> orders;
	private Boolean isCooked;	//indicates if it's ready or not
	private double tab;
	private int tableNumber;
	private Waiter itsWaiter;
	private int numOfPeople;
	
	Bill(Waiter waiterName, int tableNum){
		itsWaiter = waiterName;
		tableNumber = tableNum;
		isCooked = false;
	}
	
	void addOrder(String name, String comment){
		Order o = new Order(name, comment);
		tab += o.getPrice();
		orders.add(o);
		DataKeeper.globalKitchen.addToQueue(o);
	}
	
	/**
	 * Will try to remove the order from the global queue first. If it does not
	 * find it in the global queue, either one of the arguments is incorrect, or
	 * it is not in the queue anymore (which may suggest a cook is working on it).
	 * 
	 * @param name
	 * @param comment
	 * @return Returns false if it is not in the global queue. Returns false if it 
	 * cannot find it in the order. Returns true if it removes from both the global queue and the order.
	 */
	boolean removeOrder(String name, String comment){
		Order o = new Order(name, comment);
		if(DataKeeper.globalKitchen.searchAndRemoveGlobalQueue(o) == false)
			return false;
		tab -= o.getPrice();
		return (orders.remove(o));
	}
	
	Boolean getStatus(){return isCooked;}
	
	void setStatus(Boolean b){isCooked = b;}
	
	double returnTab(){return tab;}
		
}
