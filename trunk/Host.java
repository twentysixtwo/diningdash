/**
 * The Host class extends the Account class.
 * The host needs to be able to change and view tables.
 * 
 */
public class Host extends Account  {

	public Host(String named, float pay) {
		super(named, pay);
	}
	
	/**
	 * Seats the indicated table with the number of people in the argument
	 * Returns -1 if error occurs (i.e. Too many people for table)
	 * 
	 * @param tableNumber number of the table selected
	 * @param numberPeople number of people to seat
	 * @return 0 success, -1 error
	 */
	public int seatTable(int tableNumber, int numberPeople) {
		return 0;
	}
	
	/**
	 * View the current values of the table 
	 * Status (Occupied, Dirty, Unoccupied), Number of people, etc.
	 * @param tableNumber number of the table selected
	 * @return 0 success, -1 error
	 */
	public int viewTable(int tableNumber){
		return 0;
	}
}
