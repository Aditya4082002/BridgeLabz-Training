package inheritance;

//interface
interface Refuelable{
	public void refuel();
}

//super class
class Vehicle{
	//attributes
	protected int maxSpeed;
	protected String model;
	
	//constructor
	Vehicle(int maxSpeed, String model){
		this.maxSpeed = maxSpeed;
		this.model = model;
	}
}

//ElectricVehicle subclass
class ElectricVehicle extends Vehicle{
	//constructor
	ElectricVehicle(int maxSpeed, String model){
		super(maxSpeed,model);
	}
	
	public void charge() {
		System.out.println("Vehicle is charging.");
	}
}

//PetrolVehicle subclass
class PetrolVehicle extends Vehicle implements Refuelable{
	//constructor
	PetrolVehicle(int maxSpeed, String model){
		super(maxSpeed,model);
	}
	@Override
	public void refuel() {
		System.out.println("Vehicle Refuel Successfull.");
	}
}

public class VehicleManagement {

	public static void main(String[] args) {
		ElectricVehicle electricVehicle1  = new ElectricVehicle(220,"nexonEV");
		PetrolVehicle petrolVehicle1 = new PetrolVehicle(260,"Aura");
		
		electricVehicle1.charge();
		petrolVehicle1.refuel();
	}

}
