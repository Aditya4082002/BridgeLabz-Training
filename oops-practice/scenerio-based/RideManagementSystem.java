package ScenarioBased;
import java.util.*;

class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String message) {
        super(message);
    }
}

//interface
interface FareCalculator{
	public double calculateFare(double distance);
}

//class user
class User{
	//attributes
	private int id;
	private String name;
	
	//constructor
	public User(int id,String name){
		this.id = id;
		this.name = name;
	}
	
	//getter
	public String getName(){
		return name;
	}
}

//class Driver
class Driver{
	//attributes
	private int driverId;
	private String name;
	private boolean isAvailable = true;
	
	//constructor
	public Driver(int driverId,String name){
		this.driverId = driverId;
		this.name = name;
	}
	
	//getters
	public String getName(){
		return name;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	
	//setter
	public void setAvailable(boolean isAvailable) {
		this.isAvailable=isAvailable;
	}
}

//class for normal fare calculator
class NormalFareCalculator implements FareCalculator{
	@Override
	public double calculateFare(double distance) {
		return distance*12;
	}
}

//class for peak fare calculator
class PeakFareCalculator implements FareCalculator{
	@Override
	public double calculateFare(double distance) {
		return distance*20;
	}
}

//ride class
class Ride{
	//attributes
	private String userName;
	private String driverName;
	private double distance;
	private double fare;
	
	//constructor
	public Ride(String userName,String driverName,double distance, FareCalculator calculator){
		this.userName = userName;
		this.driverName = driverName;
		this.distance = distance;
		this.fare = calculator.calculateFare(distance);
	}
	
	//display details method
	public void displayRideDetails() {
		System.out.println("User : " + userName);
		System.out.println("Driver : " + driverName);
		System.out.println("Distance : " + distance);
		System.out.println("Fare : " + fare);
	}
}

//ride service class
class RideService{
	List<Driver> drivers = new ArrayList<>();
	List<Ride> rideHistory = new ArrayList<>();
	
	//constructor
	public RideService(List<Driver> drivers) {
		this.drivers = drivers;
	}
	
	public Ride bookRide(User user,double distance,FareCalculator calculator) throws  NoDriverAvailableException{
		for(Driver driver:drivers) {
			if(driver.isAvailable()) {
				driver.setAvailable(false);
				Ride ride = new Ride(user.getName(),driver.getName(),distance,calculator);
				rideHistory.add(ride);
				return ride;
			}
		}
		throw new  NoDriverAvailableException("No Driver available");
	}
	
	public void showRideHistory() {
		for(Ride ride:rideHistory) {
			ride.displayRideDetails();
			System.out.println("--------------------------------------------------");
		}
	}
	
	public void removeHistory(){
		rideHistory.clear();
		System.out.println("History removed...");
	}
}

public class RideManagementSystem {

	public static void main(String[] args) {
		
		User user = new User(101,"Aditya");
		
		Driver driver1 = new Driver(101,"raj");
		Driver driver2 = new Driver(102,"suraj");
		Driver driver3 = new Driver(103,"nikhil");
		
		List<Driver> drivers = new ArrayList<>();
		drivers.add(driver1);
		drivers.add(driver2);
		drivers.add(driver3);
		
		RideService rideService = new RideService(drivers);
		
		FareCalculator fareCalculator = new PeakFareCalculator();

        try {
            Ride ride = rideService.bookRide(user, 12.5, fareCalculator);
            ride.displayRideDetails();
        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Ride History:");
        rideService.showRideHistory();
        
        rideService.removeHistory();
        System.out.println("Ride History:");
        rideService.showRideHistory();
		
	}
}