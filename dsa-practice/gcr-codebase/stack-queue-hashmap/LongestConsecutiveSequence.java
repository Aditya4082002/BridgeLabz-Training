package DSA;

import java.util.HashSet;

class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Add all elements to set
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : nums) {

            // Check if num is the start of a sequence
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int count = 1;

                // Count consecutive numbers
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println(
            "Longest consecutive sequence length: "
            + longestConsecutive(nums)
        );
    }
}
