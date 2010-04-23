/**
 * The Busboy class extends the Account class.
 * Busboys check for dirty tables and, after cleaning them, 
 * change the status of the table to unoccupied.
 */
public class Busboy extends Account  {

	public Busboy(String named, float pay) {
		super(named, pay);
	}
	
	/**
	 * Uses the table number to access the correct table and change the status.
	 * If error occurs, -1 is returned, table status is unchanged and message is outputted.
	 * @return 0 for success, -1 otherwise
	 * @param int tableNumber number of table to set clean, unoccupied
	 * 
	 */
	
	public int cleanTable(int tableNumber) {
		return 0;
	}

}
