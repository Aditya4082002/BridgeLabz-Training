package RuntimeAnalysis;

import java.util.HashSet;
import java.util.TreeSet;

public class DataStructureSearchComparison {

    // Linear search in Array
    public static boolean arraySearch(int[] arr, int target) {
        for (int x : arr) {
            if (x == target) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int[] sizes = {1000, 100000, 1000000};

        for (int size : sizes) {

        	System.out.println("---------------------------------------");
        	System.out.println("Dataset Size (N) : " + size);

            //Create Data set
            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            for (int i = 0; i < size; i++) {
                array[i] = i;
                hashSet.add(i);
                treeSet.add(i);
            }

            int target = size - 1;

            //Array Search
            long arrayStart = System.nanoTime();
            boolean foundInArray = arraySearch(array, target);
            long arrayEnd = System.nanoTime();

            //HashSet Search
            long hashStart = System.nanoTime();
            boolean foundInHash = hashSet.contains(target);
            long hashEnd = System.nanoTime();

            //TreeSet Search
            long treeStart = System.nanoTime();
            boolean foundInTree = treeSet.contains(target);
            long treeEnd = System.nanoTime();

            System.out.println("---------------------------------------");
            System.out.println("Array Search Time   : " + (arrayEnd - arrayStart) + " ns  Found: " + foundInArray);
            System.out.println("HashSet Search Time : " + (hashEnd - hashStart) + " ns  Found: " + foundInHash);
            System.out.println("TreeSet Search Time : " + (treeEnd - treeStart) + " ns  Found: " + foundInTree);

            System.out.println("---------------------------------------");
        }
    }
}
