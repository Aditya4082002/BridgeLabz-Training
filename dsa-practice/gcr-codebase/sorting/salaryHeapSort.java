package sorting;

import java.util.Arrays;

public class salaryHeapSort {

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {

            // swap root (max) with last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // heapify reduced heap
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int heapSize, int rootIndex) {
        int largest = rootIndex;
        int left = 2 * rootIndex + 1;
        int right = 2 * rootIndex + 2;

        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != rootIndex) {
            int temp = arr[rootIndex];
            arr[rootIndex] = arr[largest];
            arr[largest] = temp;

            heapify(arr, heapSize, largest);
        }
    }

    public static void main(String[] args) {
        int[] salaryDemands = {60000, 45000, 90000, 30000, 75000, 50000};

        heapSort(salaryDemands);

        System.out.println(Arrays.toString(salaryDemands));
    }
}