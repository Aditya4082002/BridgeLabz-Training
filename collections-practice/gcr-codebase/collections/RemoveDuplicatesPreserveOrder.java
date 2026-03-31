package collections;

import java.util.*;

public class RemoveDuplicatesPreserveOrder {

    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> set = new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3, 1, 2, 2, 3, 4);

        List<Integer> output = removeDuplicates(input);

        System.out.println(output);
    }
}
