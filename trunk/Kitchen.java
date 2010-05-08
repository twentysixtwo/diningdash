import java.util.Queue;

public class Kitchen {
	Queue<Order> orders;
	
	void addToQueue(Order o){
		orders.add(o);
	}
	
	Order removeFromGlobalQueue(){
		return orders.remove();
	}
	
	boolean searchAndRemoveGlobalQueue(Order o){
		return orders.remove(o);
	}
	
	Order removeFromLocalQueue(){
		Order o = orders.remove();
		o.setStatusDone();
		return o;
	}

}
