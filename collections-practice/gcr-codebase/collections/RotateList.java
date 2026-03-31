package collections;

import java.util.*;

public class RotateList {

    public static <T> List<T> leftRotate(List<T> list, int k) {
        int n = list.size();
        if (n == 0) return list;

        List<T> result = new ArrayList<>();

        // add elements from k to end
        for (int i = k; i < n; i++) {
            result.add(list.get(i));
        }

        // add first k elements
        for (int i = 0; i < k; i++) {
            result.add(list.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;

        List<Integer> rotated = leftRotate(list, rotateBy);

        System.out.println(rotated);
    }
}

