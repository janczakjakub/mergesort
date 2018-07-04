package com.nbc.java.course.mergesort;

public class MergeSort {
    public static void main(String... args) {
        System.out.println("Merge sort");

        // int[] unsortedArray = {4, 1, 3, -2, 2, 5, 8, 1, -12, 0};
        int[] unsortedArray = {4, 1, 3, 2, 5};

        System.out.println("Array before sort");
        showArray(unsortedArray);

        mergeSort(unsortedArray, 0, unsortedArray.length - 1);
        System.out.println("Array after merge-sort");
        showArray(unsortedArray);
    }

    private static void mergeSort(int array[], int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;

            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);

            merge(array, start, middle, end);
        }

    }

    private static void merge(int arr[], int start, int middle, int end) {
        int leftArraySize = middle - start + 1;
        int rightArraySize = end - middle;

        int leftArray[] = new int[leftArraySize];
        int rightArray[] = new int[rightArraySize];

        for (int i = 0; i < leftArraySize; ++i) {
            leftArray[i] = arr[start + i];
        }

        for (int j = 0; j < rightArraySize; ++j) {
            rightArray[j] = arr[middle + 1 + j];
        }


        int i = 0, j = 0;

        int k = start;
        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArraySize)
        {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArraySize)
        {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private static void showArray(int arr[]) {
        for (int n = 0; n < arr.length; n++) {
            System.out.println(arr[n]);
        }
    }
}
