import java.util.Queue;

public class Kitchen {
	Queue<Order> orders;
	
	void addToQueue(Order o){
		orders.add(o);
	}
	
	Order removeFromQueue(){
		return orders.remove();
	}

}
