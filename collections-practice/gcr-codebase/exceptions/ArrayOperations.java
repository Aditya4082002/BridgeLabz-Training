package exceptions;
import java.util.Scanner;

public class ArrayOperations {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Size :");
		int size = input.nextInt();
		int[] array = new int[size];
//		int[] array = null // for null pointer exception
		System.out.println("Enter elemets in array");
		for(int i=0;i<size;i++) {
			array[i]= input.nextInt();
		}
		System.out.println("Enter index to search in array :");
		int index = input.nextInt();
		
		try {
			System.out.println(array[index]);
			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Array index out of bound");
		}catch(NullPointerException e) {
			System.out.println("Null pointer exception");
		}
		
		input.close();
	}

}
