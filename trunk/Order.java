
public class Order {
	String foodName;
	double price;
	boolean status;	//when status == 1, order is ready
	String comments;
	
	Order(String name, String com){
		foodName = name;
		comments = com;
		status = false;
		//Need to add some database queries here to set price
		price = 0.00;
	}
	
	String getFoodName(){return foodName;}
	
	double getPrice(){return price;}
	
	String getComment(){return comments;}
	
	void setStatus(boolean i){status = i;}
	boolean getStatus(){return status;}

}
