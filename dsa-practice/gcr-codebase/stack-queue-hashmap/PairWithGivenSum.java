package DSA;

import java.util.HashSet;

class PairWithGivenSum {

    public static boolean hasPair(int[] arr, int target) {

        HashSet<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;

            if (seen.contains(complement)) {
                System.out.println("Pair found: " + num + " + " + complement);
                return true;
            }

            seen.add(num);
        }

        System.out.println("No pair found");
        return false;
    }

    public static void main(String[] args) {

        int[] arr = {8, 4, 1, 6};
        int target = 10;

        hasPair(arr, target);
    }
}
