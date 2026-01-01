package javaConstructors;

public class CarMain {

	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car("Aditya","aura",4,2500);
		
		car1.totalCost();
		car2.totalCost();
		
	}

}

//class definition
class Car{
	//attributes
	private String customerName;
	private String carModel;
	private int rentalDays;
	private int costPerDay ;
	
	//default constructor
	public Car() {
		customerName= "Unknown";
		carModel = "Unknown";
		rentalDays = 0;
		costPerDay = 0;
	}
	
	//parameterized constructor
	public Car(String customerName,String carModel,int rentalDays, int costPerDay) {
		this.customerName=customerName;
		this.carModel = carModel;
		this.rentalDays = rentalDays;
		this.costPerDay = costPerDay;
	}
	
	//method to calculate cost
	public void totalCost() {
		System.out.println("Total Cost : " + costPerDay*rentalDays);
	}
}