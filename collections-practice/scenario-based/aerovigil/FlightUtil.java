package scenario.aerovigil;
import java.util.HashMap;

public class FlightUtil {
	//validate flight number
	public static boolean validateFlightNumber(String flightNumber) throws InvalidFlightException{
		String regex = "^FL-[1-9][0-9]{3}$";
		if(flightNumber.matches(regex)) {
			return true;
		}else {
			throw new InvalidFlightException("The flight number "+flightNumber+" is invalid.");
		}
	}
	
	//validate flight name
	public static boolean validatFlightName(String flightName) throws InvalidFlightException{
		String regex = "\\b(spicejet|vistara|indigo|air arabia)\\b";
		if(flightName.matches(regex)) {
			return true;
		}else {
			throw new InvalidFlightException("The flight name "+flightName+" is invalid.");
		}
	}
	
	//validate passenger count
	public static boolean validatePassengerCount(int passengerCount,String flightName) throws InvalidFlightException{
		HashMap<String, Integer> capicity = new HashMap<>();
		capicity.put("spicejet", 396);
		capicity.put("vistara", 615);
		capicity.put("indigo", 230);
		capicity.put("air arabia", 130);
		
		if(passengerCount<=0 || passengerCount>capicity.get(flightName)) {
			throw new InvalidFlightException("The passenger count "+passengerCount+" is invalid for "+flightName);
		}
		return true;
		
	}
	
	//calculate fuel to fill tank
	public static double calculateFuelToFillTank(String flightName,double currentFuelLevel) throws InvalidFlightException{
		HashMap<String, Integer> fuelCapicity = new HashMap<>();
		fuelCapicity.put("spicejet", 200_000);
		fuelCapicity.put("vistara", 300_000);
		fuelCapicity.put("indigo", 250_000);
		fuelCapicity.put("air arabia", 150_000);
		
		if(currentFuelLevel<=0 || currentFuelLevel>fuelCapicity.get(flightName)){
			throw new InvalidFlightException("Invalid fuel level for ");
		}
		
		return fuelCapicity.get(flightName)-currentFuelLevel;
	}
}
