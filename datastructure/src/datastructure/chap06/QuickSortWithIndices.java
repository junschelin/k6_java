package datastructure.chap06;

import java.util.Arrays;

public class QuickSortWithIndices {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int length = arr.length;
        quickSort(arr, 0, length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        System.out.println("Original array: " + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
