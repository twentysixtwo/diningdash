
public class Table {
	private int tableNumber;
	private Waiter tableWaiter;
	private String status;
	private Bill tableBill;
	private int maxSeat;
	private int numSeated;
	
	Table(int tableNum, int maxSeated, Waiter w){
		tableNumber = tableNum;
		maxSeat = maxSeated;
		status = "GREEN";
		tableWaiter = w;
		tableBill = new Bill(w, tableNumber, this);
	}

	int setTable(int num_Diners){
		if (num_Diners <= maxSeat){
			status = "YELLOW";
			return 1;
		}
		else 
			return 0;
	}
	
	void setTableNumber(int i){tableNumber = i;}
	int getTableNumber(){return tableNumber;}
		
	Bill returnBill(){return tableBill;}
	
	void setStatus(String stat){status = stat;}
	String getStatus(){return status;}
	
	void setMaxSeat(int i){maxSeat = i;}
	int getMaxSeat(){return maxSeat;}
	
	int cleanedTable(){
			status = "GREEN";
			numSeated = 0;
			DataKeeper.recordKeeper.sendBill(tableBill);
			return 1;
	}
}
