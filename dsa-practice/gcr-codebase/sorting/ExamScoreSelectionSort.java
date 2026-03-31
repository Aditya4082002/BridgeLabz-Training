package sorting;

import java.util.Arrays;

public class ExamScoreSelectionSort {
	public static void selectionSort(int[] scores) {
		int unSortedIndex=0;
		for(int i=0;i<scores.length-1;i++){
			int min  = min(scores,unSortedIndex);
			int temp = scores[unSortedIndex];
			scores[unSortedIndex] = scores[min];
			scores[min] = temp;
			unSortedIndex++;
		}
	}
	
	public static int min(int[] scores,int start) {
		int minIndex = start;
		for(int i=start;i<scores.length;i++) {
			if(scores[i]<scores[minIndex]){
				minIndex = i;
			}
		}
		return minIndex;
	}

	public static void main(String[] args) {
		int[] scores = {86,96,84,59,86,52,35,68,45,68};
		
		
		selectionSort(scores);
		
		//display sorted scores
		System.out.println(Arrays.toString(scores));

	}

}
