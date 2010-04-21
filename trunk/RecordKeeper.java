import java.util.*;
import java.sql.*;

class Account{
	
}
class Bill{

}
class Food{
	
}


public class RecordKeeper {

	String databasePath;
	void connectToDatabase(){
		
	}
	
	void addBill(Bill newBill){
		
	}
	void addAccount(Account newAccount)
	{
		
	}
	void addFood(Food newFood)
	{
		
	}
	
	
	
	double dailyRevenueData(String date){
		double revenue=0;
		return revenue;
	}
	double dailyRevenueDataByHour(String date, String hour){
		double revenue=0;
		return revenue;
	}
	double dailyRevenuePercentagePerItem(String date){
		double percent=0;
		return percent;
	}
	double dailyRevenuePercentagePerItemByHour(String date, String hour){
		double percent=0;
		return percent;
	}
	int dailyTotalCustomers(String date){
		int total=0;
		return total;
	}
	int dailyTotalCustomersByHour(String date, String hour){
		int total=0;
		return total;
	}
	double dailyAvgCustomersPerTable(String date){
		double avg=0;
		return avg;
	}
	double dailyAvgCustomersPerTableByHour(String date, String hour){
		double avg=0;
		return avg;
	}
	double dailyAvgRevenuePerTable(String date){
		double avg=0;
		return avg;
	}
	double dailyAvgRevenuePerTableByHour(String date, String hour){
		double avg=0;
		return avg;
	}
	double dailyCapacity(String date)
	{
		double capacity=0;
		return capacity;
	}
	double dailyCapacityByHour(String date, String hour)
	{
		double capacity=0;
		return capacity;
	}
	double DailyAvgTurnAroundTime(String date)
	{
		double avg=0;
		return avg;
	}
	double DailyAvgTurnAroundTimeByHour(String date, String hour)
	{
		double avg=0;
		return avg;
	}
	double DailyAvgPerparationTime(String date)
	{
		double avg=0;
		return avg;
	}
	double DailyAvgPerparationTimeByHour(String date, String hour)
	{
		double avg=0;
		return avg;
	}
	List<Food> dailyListAllFood(String date){
		List<Food> food=new LinkedList<Food>();
		return food;
	}
	List<Double> dailyFoodPopularity(String date){
		List<Double> popularity=new LinkedList<Double>();
		return popularity;
	}
	List<Double> dailyFoodPopularityByHour(String date, String hour){
		List<Double> popularity=new LinkedList<Double>();
		return popularity;
	}

	
	
	List<Account> listEmployees(){
		List<Account> data=new LinkedList<Account>();
		return data;
	}
	List<Account> listEmployeesByDate(String date){
		List<Account> data=new LinkedList<Account>();
		return data;
	}
	Account AccountData(int ID){
		Account temp=new Account();
		return temp;
	}
	Account dailyAccountData(String date, int ID){
		Account temp=new Account();
		return temp;
	}

	
		
}
