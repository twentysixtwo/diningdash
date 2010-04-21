
public class Table {
	int tableNumber;
	Waiter tableWaiter;
	String status;
	Bill tableBill;
	
	Table(int tableNum, Waiter name){
		tableNumber = tableNum;
		tableWaiter = name;
		status = "YELLOW";
	}

	int getTableNumber(){
		return tableNumber;
	}
	
	Bill returnBill(){
		return tableBill;
	}
	
	String setStatus(String stat){
		status = stat;
	}
	
	String getStatus(){
		return status;
	}
}
