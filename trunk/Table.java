
public class Table {
	private Integer tableNumber;
	private Waiter tableWaiter;
	private String status;
	private Bill tableBill;
	private int maxSeat;
	private int numSeated;
	private int positionRow;
	private int positionCol;
	
	Table(int tableNum, int maxSeated, Waiter w, int posR, int posC){
		tableNumber = tableNum;
		maxSeat = maxSeated;
		status = "GREEN";
		tableWaiter = w;
		tableBill = new Bill(w, this);
		positionRow = posR;
		positionCol = posC;
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
	Integer getTableNumber(){return tableNumber;}
		
	Bill returnBill(){return tableBill;}
	
	void setStatus(String stat){status = stat;}
	String getStatus(){return status;}
	
	void setMaxSeat(int i){maxSeat = i;}
	int getMaxSeat(){return maxSeat;}
	
	int cleanedTable(){
			status = "GREEN";
			numSeated = 0;
			DataKeeper.restaurantRecord.sendBill(tableBill);
			return 1;
	}
	
	int getPosRow(){
		return positionRow;
	}
	
	int getPosCol(){
		return positionCol;
	}
}
