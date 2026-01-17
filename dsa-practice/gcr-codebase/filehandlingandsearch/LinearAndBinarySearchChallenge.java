package filehandlingandsearch;

import java.util.Arrays;

class LinearAndBinarySearchChallenge {

    //1) Linear Search: First Missing Positive Integer
    public static int firstMissingPositive(int[] arr) {

        int n = arr.length;

        // visited[i] means number (i+1) is present
        boolean[] visited = new boolean[n + 1];

        // Mark visited for numbers in range [1 to n]
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 && arr[i] <= n) {
                visited[arr[i]] = true;
            }
        }

        // Find first missing
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return i;
            }
        }

        return n + 1;
    }

    //2) Binary Search: Find target index after sorting
    public static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } 
            else if (arr[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, -1, 1, 2};
        int target = 4;

        //First Missing Positive (Linear Search)
        int missing = firstMissingPositive(nums);
        System.out.println("First Missing Positive Integer: " + missing);

        //Sort array for Binary Search
        Arrays.sort(nums);
        System.out.println("Sorted Array: " + Arrays.toString(nums));

        //Binary Search for target index
        int index = binarySearch(nums, target);
        System.out.println("Target Index of " + target + " : " + index);
    }
}

