//program to find the volume of a cylinder
import java.util.Scanner; 

class VolumeOfCylinder{
	public static void main(String[] args){
		//create a Scanner object
		Scanner input=new Scanner(System.in);
		
		//take radius and height input
		System.out.println("Enter the radius of the cylinder : ");
		double radius = input.nextDouble();
		System.out.println("Enter the height of the cylinder : ");
		double height = input.nextDouble();
		
		final double PI = 3.14;
		
		//calculate volume
		double volume = PI * (radius*radius) * height;
		
		//Display the volume
		System.out.println("Volume of the Cylinder is  : " + volume);
		
		//Closing the Scanner Stream
		input.close();
	}
}