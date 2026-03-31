package DSA;

import java.util.*;

class ZeroSumSubarrays {

    public static void findZeroSumSubarrays(int[] arr) {

        // Map to store cumulative sum and list of indices
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int sum = 0;

        // Important: sum 0 at index -1 (handles subarrays starting at index 0)
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum already exists, zero-sum subarray found
            if (map.containsKey(sum)) {
                for (int startIndex : map.get(sum)) {
                    System.out.println(
                        "Zero-sum subarray found from index "
                        + (startIndex + 1) + " to " + i
                    );
                }
            }

            // Store current index for this sum
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
    }

    public static void main(String[] args) {

        int[] arr = {3, 4, -7, 1, 3, -4, -2, -2};

        findZeroSumSubarrays(arr);
    }
}

