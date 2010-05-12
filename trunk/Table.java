import java.awt.Color;

public class Table {
	private Integer tableNumber;
	private Waiter tableWaiter;
	private Color status;
	private Bill tableBill = new Bill(tableWaiter, this);;
	private int maxSeat;
	private int numSeated;
	private int positionRow;
	private int positionCol;
	
	Table(int tableNum, int maxSeated, String name, int posR, int posC, int stat, int ns){
		tableNumber = tableNum;
		maxSeat = maxSeated;
		switch(stat){
			case 0: {status = Color.green; break;}
			case 1: {status = Color.yellow; break;}
			case 2: {status = Color.red; break;}
			default: {status = Color.red; break;}
		}
		tableWaiter = new Waiter(name, 0);
		tableBill = new Bill(tableWaiter, this);;
		positionRow = posR;
		positionCol = posC;
		numSeated = ns;
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
	
	void cleanedTable(){
		status = Color.green;
		numSeated = 0;
		//DataKeeper.restaurantRecord.sendBill(tableBill);
		tableBill = null;
		DataKeeper.updatesTableInDatabase(this);
	}
	
	void assignedTable(String s, int n){
		status = Color.yellow;
		tableWaiter.setName(s);
		numSeated = n;
		DataKeeper.updatesTableInDatabase(this);
	}
	
	int getPosRow(){
		return positionRow;
	}
	
	int getPosCol(){
		return positionCol;
	}
	
	Bill getTableBill(){
		return tableBill;
	}

	public String getName() {
		return tableWaiter.getName();
	}
}
