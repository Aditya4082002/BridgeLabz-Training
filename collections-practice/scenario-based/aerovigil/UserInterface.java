package scenario.aerovigil;
import java.util.Scanner;

public class UserInterface {
	public static void main(String[] args) {
		//crate object of scanner class
		Scanner input = new Scanner(System.in);
		
		//take user input
		System.out.println("Enter Flight details in the format :");
		System.out.println("<FlightNumber>:<FlightName>:<PassengerCount>:<CurrentFuelLevel>");
		String inputData = input.nextLine();
		
		//split data
		String[] details = inputData.split(":");
		
		String flightNumber = details[0];
		String flightName = details[1].toLowerCase();
		int passengerCount = Integer.parseInt(details[2]);
		int currentFuelLevel = Integer.parseInt(details[3]);
		
		//validate
		try {
			FlightUtil.validateFlightNumber(flightNumber);
			FlightUtil.validatFlightName(flightName);
			FlightUtil.validatePassengerCount(passengerCount, flightName);
			double fuel = FlightUtil.calculateFuelToFillTank(flightName, currentFuelLevel);
			System.out.println("Fuel required to fill the tank: "+fuel+" liters");
			
		}catch(InvalidFlightException e) {
			System.out.println(e.getMessage());
		}
 		
		//close scanner
		input.close();
	}
}
