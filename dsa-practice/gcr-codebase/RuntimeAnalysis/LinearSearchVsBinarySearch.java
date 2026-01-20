package RuntimeAnalysis;

import java.util.Arrays;

public class LinearSearchVsBinarySearch {
	
	//linear search
	public static int linearSearch(int[] data,int target) {
		for(int i=0;i<data.length;i++) {
			if(data[i]==target) {
				return i;
			}
		}
		return -1;
	}
	
	//binary search
	public static int binarySearch(int[] data,int target) {
		int start = 0;
		int end = data.length;
		
		while(start<end) {
			int mid = start + (end - start)/2;
			if(data[mid] == target) {
				return mid;
			}else if(data[mid]<target) {
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] sizes = {1000,10000,1000000};
		for(int size : sizes) {
			System.out.println("---------------------------------------");
			System.out.println("For size : " + size);
			int[] data = new int[size];
			//generate array
			for(int i=0;i<size;i++) {
				data[i] = (int)Math.random()*size;
			}
			long linearStart = System.nanoTime();
			int linearFound = linearSearch(data,size+1);
			long linearEnd = System.nanoTime();
			
			int[] sortedArray = Arrays.copyOf(data,size);
			long sortStart = System.nanoTime();
			Arrays.sort(sortedArray);			
			long sortEnd = System.nanoTime();
			
			long binaryStart = System.nanoTime();
			int binaryFound = binarySearch(sortedArray,size+1);
			long binaryEnd = System.nanoTime();
			
			System.out.println("---------------------------------------");
			System.out.println("Time in linear search : " + (linearEnd - linearStart));
			System.out.println("Time in Sorting : "+ (sortEnd - sortStart));
			System.out.println("Time in Binary search : "+ (binaryEnd - binaryStart));
			System.out.println("Total time in (Searching + sorting)");
		}
	}
}