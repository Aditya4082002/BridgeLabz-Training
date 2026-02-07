package scenario.oceanfleet;
import java.util.Scanner;
import java.util.List;

public class UserInterface {
	
	//display method
	public static void  displayVessel(Vessel vessel) {
		System.out.println(
				vessel.getVesselId() + "|" +
				vessel.getVesselName() + "|" +
				vessel.getVesselType() + "|" + 
				vessel.getAverageSpeed() + "knots"
		);
	}

	public static void main(String[] args) {
		//create object of scanner
		Scanner input  = new Scanner(System.in);
		
		//object of vesselUtil class
		VesselUtil vesselUtil = new VesselUtil();
		
		System.out.println("Enter Number of vessels");
		int number = input.nextInt();
		input.nextLine();//consume extra line
		
		//user input
		System.out.println("Enter vessel details: ");
		System.out.println("vesselId:vesselName:averageSpeed:vesselType");
		for(int i=0;i<number;i++) {
			String data = input.nextLine();
			String[] vesselData = data.split(":");
			
			String vesselId = vesselData[0];
			String vesselName = vesselData[1];
			double averageSpeed = Double.parseDouble(vesselData[2]);
			String vesselType = vesselData[3];
			
			Vessel vessel = new Vessel(vesselId,vesselName,averageSpeed,vesselType);
			vesselUtil.addVesselPerformance(vessel);
		}
		
		//method call find by id
		System.out.println("Enter the Vessel Id to check speed : ");
		String id = input.nextLine();
		displayVessel(vesselUtil.getVesselById(id));
		
		//get high performance vessels
		System.out.println("High performance vessels are : ");
		List<Vessel> highVesseles = vesselUtil.getHighPerformanceVessels();
		for(Vessel  vessel : highVesseles) {
			displayVessel(vessel);
		}
		
		//close scanner
		input.close();
	}
}
