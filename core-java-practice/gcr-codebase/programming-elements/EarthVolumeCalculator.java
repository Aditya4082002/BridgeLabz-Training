//create a class EarthVolumeCalculator to calculate the volume of earth in cubic kilometers and cubic miles
class EarthVolumeCalculator{
	public static void main(String[] args){
		//create a variable to indicate radius of earth
		long radiusOfEarthInKm = 6387L;
		double radiusOfEarthInMiles = radiusOfEarthInKm/1.6;
		
		//calculate the volume of earth in cubic kilometers and cubic miles
		double volumeInCubicKm = (4/3)*Math.PI*(radiusOfEarthInKm*radiusOfEarthInKm*radiusOfEarthInKm);
		double volumeInCubicMiles = (4/3)*Math.PI*radiusOfEarthInMiles*radiusOfEarthInMiles*radiusOfEarthInMiles;
		
		//display the results
		System.out.printf("The volume of earth in cubic kilometers is : %.0f\n",volumeInCubicKm);
		System.out.printf("and cubic miles is : %.0f\n",volumeInCubicMiles);
	}
}