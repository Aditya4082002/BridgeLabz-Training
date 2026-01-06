package scenrioBase;
import java.util.Scanner;
public class TemperatureAnalyzer {
	
	public static float[] averageTemperature(float[][] temperature) {
		float[] average = new float[7];
		
		for(int i=0;i<7;i++){
			float sum=0;
			for(float temp : temperature[i]) {
				sum +=temp;
			}
			average[i] = sum/7;
		}
		return average;
	}

	public static void main(String[] args) {
		//create scanner object
		Scanner input = new Scanner(System.in);
		
		float[][] temperature = new float[7][24];
		
		//take input
		for(int i=0;i<7;i++) {
			for(int j=0;j<24;j++) {
				temperature[i][j] = (float)(Math.random()*20)+1;
			}
		}
		
		//calculate average
		float[] averageTemperature = averageTemperature(temperature);
	
		for(int i=0;i<7;i++) {
			System.out.println("Average temperature of day " + (i+1) + " : " + averageTemperature[i]);
		}
		
		int hotest = 0;
		int coldest = 0;
		for(int i=0;i<7;i++) {
			if(averageTemperature[hotest]<averageTemperature[i]) {
				hotest = i;
			}
			if(averageTemperature[coldest]>averageTemperature[i]) {
				coldest = i;
			}
		}
		
		System.out.println("Hotest day : " + (hotest+1));
		System.out.println("Coldest day : " + (coldest+1));
		
		//close scanner stream
		input.close();
	}

}
