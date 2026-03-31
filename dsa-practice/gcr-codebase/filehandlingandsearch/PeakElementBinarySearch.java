package filehandlingandsearch;

class PeakElementBinarySearch {

    public static int findPeakIndex(int[] arr) {

        int n = arr.length;
        int left = 0, right = n - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Handle boundaries safely
            boolean leftOk = (mid == 0) || (arr[mid] > arr[mid - 1]);
            boolean rightOk = (mid == n - 1) || (arr[mid] > arr[mid + 1]);

            // If both conditions true, it's a peak
            if (leftOk && rightOk) {
                return mid;
            }

            // If left neighbor is bigger, peak must be on left side
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }
            // Else peak must be on right side
            else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 20, 4, 1, 0};

        int peakIndex = findPeakIndex(arr);

        System.out.println("Peak Index: " + peakIndex);
        System.out.println("Peak Element: " + arr[peakIndex]);
    }
}

