package filehandlingandsearch;

class FirstNegativeLinearSearch {

    public static int firstNegativeIndex(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;  // first negative number index
            }
        }

        return -1; // no negative found
    }

    public static void main(String[] args) {

        int[] arr = {5, 8, 2, -4, 10, -7};

        int index = firstNegativeIndex(arr);

        if (index != -1) {
            System.out.println("First negative number found at index: " + index);
            System.out.println("Value: " + arr[index]);
        } else {
            System.out.println("No negative number found");
        }
    }
}

