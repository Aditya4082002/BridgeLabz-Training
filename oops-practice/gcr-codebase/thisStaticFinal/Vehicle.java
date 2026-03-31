package thisStaticFinal;

public class Vehicle {

	//static variable 
	static double registrationFee=150;

	//instance variables
	private String ownerName;
	private String vehicleType;
	private final String registrationNumber; //can not be changed
		
	//static methods
	public static void updateRegistrationFee(double newRegistrationFee) {
		registrationFee = newRegistrationFee;
		System.out.println("new registration fee : "  + newRegistrationFee);
	}
		
	//constructor
	public Vehicle(String ownerName,String vehicleType,String registrationNumber){
		this.ownerName = ownerName;
		this.vehicleType=vehicleType;
		this.registrationNumber=registrationNumber;
	}
		
	//method to display details
	public void displayDetails() {
		if(this instanceof Vehicle) {
			System.out.println("Owner Name : " + ownerName);
			System.out.println("Vehicle Type : " + vehicleType);
			System.out.println("Registration Number : " + registrationNumber);
			System.out.println("Registration Fee : " + registrationFee);
		}else {
			System.out.println("Invalid Object");
		}
	}
		
	//main method 
	public static void main(String[] args) {
		Vehicle vehicle1 = new Vehicle("Honest raj","Sedan","ABC123");
		Vehicle vehicle2 = new Vehicle("Price danish","SUV","XYZ789");
		vehicle1.displayDetails();
		vehicle2.displayDetails();
	}
}
