//import Scanner class to take input from user
import java.util.Scanner;

//create class OddEvenArray for the required task
class OddEvenArray{
	public static void main(String[] args){
		//create an object of Scanner class
		Scanner input=new Scanner(System.in);
		
		//take a number input and create two arrays for number/2 +1
 		int number = input.nextInt();
		int[] oddArray = new int[number/2+1];
		int[] evenArray = new int[number/2+1];
		int oddIndex = 0;
		int evenIndex= 0;
		
		//storing even and odd number in respective array
		for(int index=1;index<=number;index++){
			if(index%2==0){
				evenArray[evenIndex]=index;
				evenIndex++;
			}
			else{
				oddArray[evenIndex]=index;
				oddIndex++;
			}
		}
		
		//printing odd array
		System.out.println("OddArray:");
		for(oddIndex=0;oddIndex<oddArray.length;oddIndex++){
			System.out.println(oddArray[oddIndex]);
		}
		
		//printing even array
		System.out.println("EvenArray");
		for(evenIndex=0;evenIndex<evenArray.length;evenIndex++){
			System.out.println(evenArray[evenIndex]);
		}
		
		
		//Closing the Scanner Stream
		input.close();
	}
}