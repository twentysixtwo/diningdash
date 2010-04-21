import java.util.LinkedList;


public class Bill {
	private LinkedList<Order> orders;
	private int Status;	//indicates if it's ready or not
	private Float tab;
	private int tableNumber;
	private Waiter itsWaiter;
	private int numOfPeople;
	
	Bill(Waiter waiterName, int tableNum){
		itsWaiter = waiterName;
		tableNumber = tableNum;
	}
	
	void addOrder(Order o){
		orders.add(o);
	}
	
	void showOrder(){
		
	}
	
	int getStatus(){
		return Status;
	}
	
	void setStatus(){
		
	}
	
	Float returnTab(){
		return tab;
	}
	
	
}
