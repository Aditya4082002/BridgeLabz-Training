package classanobject;

public class MovieTicketMain {

	public static void main(String[] args) {
		
		//create object of movieticket
		MovieTicket ticket1 = new MovieTicket("Dragon","A10",120);
		ticket1.BookATicket();
		ticket1.displayTicketDetails();
	}

}

//class definition
class MovieTicket{
	//attributes
	private String movieName;
	private  String seatNumber;
	private double price;
	static int count=3;
	
	//constructor
	public MovieTicket(String movieName,String seatNumber,double price) {
		this.movieName= movieName;
		this.seatNumber = seatNumber;
		this.price = price;
	}
	//method to book ticket
	public void BookATicket() {
		System.out.println("Ticket have not booked yet.");
		if(count>0) {
			System.out.println("Ticket booked for " + movieName);
			count--;
		}else {
			System.out.println("House full!!!! sorry... Ticket already booked");
		}
	}
	
	//method to display ticket
	public void displayTicketDetails() {
		System.out.println("Ticket booked for movie : " + movieName);
		System.out.println("Seat Number : " + seatNumber);
		System.out.println("Price : " + price);
	}
}