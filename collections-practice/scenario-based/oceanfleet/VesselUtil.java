package scenario.oceanfleet;
import java.util.*;

public class VesselUtil {
	private List<Vessel> vesselList = new ArrayList<>();
	
	//method to add vessel
	public void addVesselPerformance(Vessel vessel) {
		vesselList.add(vessel);
	}
	
	//method to get vessel by Id
	public Vessel getVesselById(String vesselId) {
		for(Vessel vessel:vesselList){
			if(vessel.getVesselId().equals(vesselId)) {
				return vessel;
			}
		}
		return null;
	}
	
	//method to get high performance vessel
	public List<Vessel> getHighPerformanceVessels(){
		List<Vessel> highList = new ArrayList<>();
		
		double max = 0;
		for(Vessel vessel:vesselList) {
			if(vessel.getAverageSpeed()>max) {
				max= vessel.getAverageSpeed();
			}
		}
		
		for(Vessel vessel:vesselList) {
			if(vessel.getAverageSpeed()==max) {
				highList.add(vessel);
			}
		}
		
		return highList;
	}
}
