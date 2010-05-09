import java.awt.Color;

public class Table {
	private Integer tableNumber;
	private Waiter tableWaiter;
	private Color status;
	private Bill tableBill;
	private int maxSeat;
	private int numSeated;
	private int positionRow;
	private int positionCol;
	
	Table(int tableNum, int maxSeated, Waiter w, int posR, int posC){
		tableNumber = tableNum;
		maxSeat = maxSeated;
		status = Color.green;
		tableWaiter = w;
		tableBill = new Bill(w, this);
		positionRow = posR;
		positionCol = posC;
	}

	int setTable(int num_Diners){
		if (num_Diners <= maxSeat){
			status = Color.yellow;
			return 1;
		}
		else 
			return 0;
	}
	
	void setTableNumber(int i){tableNumber = i;}
	Integer getTableNumber(){return tableNumber;}
		
	Bill returnBill(){return tableBill;}
	
	void setStatus(Color stat){
		status = stat;
		DataKeeper.updatesTableInDatabase(this);
	}
	Color getStatus(){return status;}
	
	void setNumSeat(int i){
		if(numSeated <= maxSeat) numSeated = i;
		else numSeated = -1;
		DataKeeper.updatesTableInDatabase(this);
	}
	int getNumSeat(){return numSeated;}
	
	int cleanedTable(){
		status = Color.green;
		numSeated = 0;
		DataKeeper.restaurantRecord.sendBill(tableBill);
		DataKeeper.updatesTableInDatabase(this);
		return 1;
	}
	
	int getPosRow(){
		return positionRow;
	}
	
	int getPosCol(){
		return positionCol;
	}
}
