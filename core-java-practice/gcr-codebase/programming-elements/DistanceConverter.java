// create a class DistanceConverter to convert the distance from km to miles
class DistanceConverter{
	public static void main(String[] args){
		//create a variable to indicate the distance in km
		double distanceInkm = 10.8;
		
		//convert the distance from km to miles
		double distanceInMiles = distanceInkm/1.6;
		
		//display the result
		System.out.println("The distance "+ distanceInkm +" km im miles is "+ distanceInMiles);
	}
}