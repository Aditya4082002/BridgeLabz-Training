package javaConstructors;

public class HotelBooking {

	public static void main(String[] args) {
		//creating objects
		Booking booking1 = new Booking();
		Booking booking2 = new Booking("Aditya","Deluxe",5);
		Booking booking3 = new Booking(booking2);
		
		booking1.displayDetails();
		booking2.displayDetails();
		booking3.displayDetails();
	}
}

//class definition
class Booking{
	//attributes
	private String guestName;
	private String roomType;
	private int nights;
	
	//default constructor
	public Booking() {
		guestName = "Unknown";
		roomType = "Not Specified";
		nights=0;
	}
	
	//parameterized constructor
	public Booking(String guestName,String roomType,int nights) {
		this.guestName = guestName;
		this.roomType = roomType;
		this.nights = nights;
	}
	
	//copy constructor
	public Booking(Booking booking1) {
		this.guestName = booking1.guestName;
		this.roomType = booking1.roomType;
		this.nights = booking1.nights;
	}
	
	//display function
	public void  displayDetails() {
		System.out.println("Guest Name : " + guestName);
		System.out.println("Room Type : " + roomType);
		System.out.println("nights : " + nights);
	}
	
}
