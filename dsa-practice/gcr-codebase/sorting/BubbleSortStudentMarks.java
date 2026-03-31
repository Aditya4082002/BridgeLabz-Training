package sorting;
import java.util.Arrays;

public class BubbleSortStudentMarks {
	//method for bubble sort
	public static void bubbleSort(int[] arr){
		boolean swapped;
		for(int i=0;i<arr.length;i++) {
			swapped = false;
			for(int j=0;j<arr.length-i-1;j++) {
				if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}
	}
		
	public static void main(String[] args) {
		int[] studentMarks = {50,60,44,85,10,35,20};
		
		
		bubbleSort(studentMarks);
		
		//print sorted array
		System.out.println(Arrays.toString(studentMarks));
	}
}
