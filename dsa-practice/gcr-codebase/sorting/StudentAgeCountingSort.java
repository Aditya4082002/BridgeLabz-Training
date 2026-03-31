package sorting;
import java.util.Arrays;

public class StudentAgeCountingSort {
	
	public static void countingSort(int[] ages) {
		int[] countArr = new int[9];
		for(int i=0;i<ages.length;i++){
			countArr[ages[i]-10]++;
		}
		int index=0;
		for(int i=0;i<countArr.length;i++) {
			if(countArr[i]!=0) {
				for(int j=1;j<=countArr[i];j++){
					ages[index] = i+10;
					index++;	
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] ages = {10,12,15,16,15,14,18,13,12,16,18};
		
		countingSort(ages);
		
		System.out.println(Arrays.toString(ages));

	}

}
