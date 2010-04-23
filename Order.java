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
	String foodName;
	
	/**
	 * The value of the food
	 */
	double price;
	
	/**
	 * By default, will set status to 0, indicating the order is not ready.
	 * Once the cook makes the order and is ready to give to the customer, the status
	 * is set to 1.
	 */
	
	boolean status;
	
	/**
	 * Any comments regarding the dish, such as allergies or specific
	 * ingredients will be kept here.
	 */
	String comments;
	
	/**
	 * A reference to the bill to which it belongs
	 */
	Bill itsBill;
	
	/**
	 * Default constructor of the class
	 * 
	 * By default, will set the status of the dish to not ready, or 0
	 * @param name The name of the dish
	 * @param com The comments regarding the order
	 */
		
	Order(String name, String com, Bill b){
		foodName = name;
		comments = com;
		itsBill = b;
		status = false;
		//Need to add some database queries here to set price
		price = 0.00;
	}
	
	/**
	 * Gets the name of the order
	 * @return A string containing the food name
	 */
	String getFoodName(){return foodName;}
	
	/**
	 * Gets the price of the order
	 * @return The price of the order as a double
	 */
	double getPrice(){return price;}
	
	/**
	 * Gets the comment associated with the order
	 * @return A string containing the comment
	 */
	String getComment(){return comments;}
	
	/**
	 * Sets the status of the order
	 * @param i A boolean value, with true indicating the order is done, 
	 * and false indicating the order is not done 
	 */
	void setStatus(boolean i){status = i;}
	
	/**
	 * Gets the status of the order
	 * @return A boolean value, with true indicating the order is done,
	 * and false indicating the order is not done
	 */
	boolean getStatus(){return status;}

}
