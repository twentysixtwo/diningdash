import java.text.DecimalFormat;

/**
 * This class contains all the information regarding specific food orders.
 * 
 * @author Henry
 *
 */

public class Order {
	
	/**
	 * Name of the order
	 */
	private String foodName;
	
	/**
	 * The value of the food
	 */
	private double price;
	
	/**
	 * By default, will set status to 0, indicating the order is not ready.
	 * Once the cook makes the order and is ready to give to the customer, the status
	 * is set to 1.
	 */
	
	private boolean status;
	
	/**
	 * Any comments regarding the dish, such as allergies or specific
	 * ingredients will be kept here.
	 */
	private String comments;
	
	/**
	 * A reference to the bill to which it belongs
	 */
	private Bill itsBill;
	
	/**
	 * Default constructor of the class
	 * 
	 * By default, will set the status of the dish to not ready, or 0
	 * @param name The name of the dish
	 * @param com The comments regarding the order
	 */
	
	/**
	 * The time the food is cooked.
	 */
	private long finishedTime;
		
	public Order(String name, String com, Bill b, double p){
		foodName = name;
		comments = com;
		//itsBill = b;
		status = false;
		price = p;
	}
	
	/**
	 * Gets the name of the order
	 * @return A string containing the food name
	 */
	public String getFoodName(){return foodName;}
	
	/**
	 * Gets the price of the order
	 * @return The price of the order as a double
	 */
	public double getPrice(){return price;}
	
	/**
	 * Gets the price of the order as a string
	 * @return The price of the order as a double
	 */
	public String getPriceAsString(){
		DecimalFormat twoPlaces = new DecimalFormat("#.##");
		return Double.valueOf(twoPlaces.format(price)).toString();
	}
	
	/**
	 * Gets the comment associated with the order
	 * @return A string containing the comment
	 */
	public String getComment(){return comments;}
	
	/**
	 * Sets the status of the order as done, and also mark when the order is finished.
	 */
	public void setStatusDone(){
		finishedTime = System.currentTimeMillis();
		status = true;
	}
	
	/**
	 * Gets the status of the order
	 * @return A boolean value, with true indicating the order is done,
	 * and false indicating the order is not done
	 */
	public boolean getStatus(){return status;}

}
