package filehandlingandsearch;

class RotationPointBinarySearch {

    public static int findRotationPoint(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Smallest element is in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }
            // Smallest element is in the left half (including mid)
            else {
                right = mid;
            }
        }

        // left == right is the index of smallest element
        return left;
    }

    public static void main(String[] args) {

        int[] arr = {15, 18, 2, 3, 6, 12};

        int rotationIndex = findRotationPoint(arr);

        System.out.println("Rotation Point Index: " + rotationIndex);
        System.out.println("Smallest Element: " + arr[rotationIndex]);
    }
}
