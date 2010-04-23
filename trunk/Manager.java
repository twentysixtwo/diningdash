/**
 * The Manager class extends the Account class. 
 * Manager will access various Data from the Database
 */
public class Manager extends Account {

	private String date;
	
	public Manager(String named, float pay) {
		super(named, pay);
	}
	
	public String getDate() {
		return date;
	}
	
	public int setDate(String dat) {
		date = dat;
		return 0;
	}
	
	/**
	 * Displays the list of employees that worked on the set date.
	 * Lists their information (Names, Hours).
	 * If invalid date, no data for the date, etc, returns -1.
	 * @return 0 on success, -1 error
	 */
	public int getEmployeesDay() {
		return 0;
	}
	
	/**
	 * Displays the list of bills for the set date.
	 * Lists all the standard bill information.
	 * If invalid date, no data for the date, etc, returns -1.
	 * @return 0 success, -1 error
	 */
	public int getBillsDay() {
		return 0;
	}
	
	/**
	 * Calculates and displays the summary of the bills for that date.
	 * Averages various bill attributes to provide a summary of the day.
	 * If invalid date, no data for the date, etc, returns -1.
	 * @return 0 success, -1 error
	 */
	public int getDailySummary() {
		return 0;
	}
	
	/**
	 * Calculates and displays the summary of the bills for the last 7 days from that date.
	 * Averages various bill attributes to provide a summary of the day.
	 * Displays an abbreviated summary if there isn't information for all the days.
	 * If invalid date, no data for the date range, etc, returns -1.
	 * @return 0 success, -1 error
	 */
	public int getWeeklySummary() {
		return 0;
	}
	
	/**
	 * Calculates and displays the summary of the bills for the Month.
	 * Averages various bill attributes to provide a summary of the Month.
	 * Displays an abbreviated summary if there isn't information for all the days.
	 * If invalid date, no data for the Month, etc, returns -1.
	 * @return 0 success, -1 error
	 */
	public int getMonthlySummary() {
		return 0;
	}
}
