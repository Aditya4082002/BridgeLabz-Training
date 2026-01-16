package sorting;

import java.util.Arrays;

public class InsertionSortEmployeeIDs {

	public static void insertionSort(int[] arr){
		for(int i=1;i<arr.length;i++) {
			int key = arr[i];
			
			int j=i-1;
			while(j>=0 && arr[j]>key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
	
	public static void main(String[] args) {
		int[] employeeIds = {101,106,102,103,108,107,104,105};
		
		
		insertionSort(employeeIds);
		
		//print sorted array
		System.out.println(Arrays.toString(employeeIds));
	}

}
