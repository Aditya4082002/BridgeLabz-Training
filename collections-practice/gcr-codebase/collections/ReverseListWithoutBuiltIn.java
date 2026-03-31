package collections;

import java.util.*;

public class ReverseListWithoutBuiltIn {

    // Method to reverse any List (ArrayList / LinkedList)
    public static <T> void reverseList(List<T> list) {
        int start = 0;
        int end = list.size() - 1;

        while (start < end) {
            // swap elements
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);

            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        // ArrayList Example
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original ArrayList: " + arrayList);
        reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);

        System.out.println();

        // LinkedList Example
        List<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original LinkedList: " + linkedList);
        reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }
}
