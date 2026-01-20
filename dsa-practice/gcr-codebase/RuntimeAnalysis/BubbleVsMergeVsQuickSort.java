package RuntimeAnalysis;

import java.util.Arrays;
import java.util.Random;

public class BubbleVsMergeVsQuickSort {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;

        int pivotIndex = partition(arr, low, high);

        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // last element pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap pivot to correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        int[] sizes = {1000, 10000, 1000000};
        Random random = new Random();

        for (int size : sizes) {

            System.out.println("=======================================");
            System.out.println("Dataset Size: " + size);

            // generate random data set
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = random.nextInt(size);
            }

            // Bubble Sort 
            // Bubble sort is too slow for very large data sets
            if (size <= 10000) {
                int[] bubbleArray = Arrays.copyOf(data, size);

                long bubbleStart = System.nanoTime();
                bubbleSort(bubbleArray);
                long bubbleEnd = System.nanoTime();

                System.out.println("Bubble Sort Time : " + (bubbleEnd - bubbleStart) + " ns");
            } else {
                System.out.println("Bubble Sort Time : Unfeasible for " + size);
            }

            //Merge Sort
            int[] mergeArray = Arrays.copyOf(data, size);

            long mergeStart = System.nanoTime();
            mergeSort(mergeArray, 0, mergeArray.length - 1);
            long mergeEnd = System.nanoTime();

            System.out.println("Merge Sort Time : " + (mergeEnd - mergeStart) + " ns");

            //Quick Sort
            int[] quickArray = Arrays.copyOf(data, size);

            long quickStart = System.nanoTime();
            quickSort(quickArray, 0, quickArray.length - 1);
            long quickEnd = System.nanoTime();

            System.out.println("Quick Sort Time : " + (quickEnd - quickStart) + " ns");

            System.out.println("=======================================");
        }
    }
}
