
public class Order {
	String foodName;
	Float price;
	int status;	//when status == 1, order is ready
	String comments;
	
	Order(String name, Float val, String com){
		foodName = name;
		price = val;
		comments = com;
		status = 0;
	}
	
	String getFoodName(){
		return foodName;
	}
	
	Float getPrice(){
		return price;
	}
	
	String getComment(){
		return comments;
	}
	
	void setStatus(int i){
		status = i;
	}
	
	int getStatus(){
		return status;
	}

}
