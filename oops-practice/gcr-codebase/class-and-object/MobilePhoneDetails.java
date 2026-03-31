package classanobject;

public class MobilePhoneDetails  {

	public static void main(String[] args) {
		
		//create object of item class
		Mobile mobile1 = new Mobile("VIVO",15999,"VIVO V29");
		Mobile mobile2 = new Mobile("ONE PLUS",39999,"ONE PLUS nord4");
		Mobile mobile3 = new Mobile("APPLE",79999,"iphone 16");
		
		mobile1.displayDetails();
		mobile2.displayDetails();
		mobile3.displayDetails();

	}
}

//class definition
class Mobile {
	//attributes
	private String brand;
	private double price;
	private String model;
	
	//constructor
	public Mobile(String brand,double price,String model) {
		this.brand = brand;
		this.price = price;
		this.model = model;
 	}
	
	//method to displayDetails
	public void displayDetails(){
		System.out.println("Brand of mobile : " + brand);
		System.out.println("price of mobile : " + price);
		System.out.println("Model of mobile : " + model);
		System.out.println("---------------------------");
	}
	
}