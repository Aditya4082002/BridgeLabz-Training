package inheritance;

//super class definition
class Device{
	//attributes
	protected int deviceId;
	protected String status;
	
	//constructor
	Device(int deviceId, String status){
		this.deviceId = deviceId;
		this.status = status;
	}
	
	//method to display
	public void displayStatus() {
		System.out.println("Device ID : " + deviceId);
		System.out.println("Status : " + status);
	}
}

//subclass definition
class Thermostat extends Device{
	//attributes
	protected String temperatureSetting;
	
	//constructor
	Thermostat(int deviceId, String status,String temperatureSetting){
		super(deviceId,status);
		this.temperatureSetting=temperatureSetting;
	}
	
	@Override
	public void displayStatus() {
		super.displayStatus();
		System.out.println("Temperature Settings : "  + temperatureSetting);
	}
	
	
}

public class SmartHome {

	public static void main(String[] args) {
		Thermostat thermostat1 = new Thermostat(101,"online","low");
		thermostat1.displayStatus();

	}

}
