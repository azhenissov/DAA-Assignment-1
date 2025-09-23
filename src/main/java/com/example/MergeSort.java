package com.example;

import com.example.util.Metrics;

public class MergeSort {
    private static final int CUTOFF = 12;

    public static void sort(int[] arr, Metrics metrics) {
        metrics.reset();
        metrics.setInputSize(arr.length);
        metrics.startTimer();

        int[] aux = new int[arr.length];
        metrics.incrementAllocations();

        mergeSort(arr, aux, 0, arr.length - 1,metrics);
        metrics.stopTimer();
    }
    private static void mergeSort(int[] arr, int[] aux, int left, int right, Metrics metrics) {
        metrics.incrementRecursionDepth();

        if (right - left + 1 <= CUTOFF) {
            insertionSort(arr, left, right, metrics);
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, aux, left, mid, metrics);
        mergeSort(arr, aux, mid + 1, right, metrics);

        merge(arr, aux, left, mid, right, metrics);
    }

    private static void merge(int[] arr, int[] aux, int left, int mid, int right, Metrics metrics) {
        for (int i = left; i <= right; i++) {
            aux[i] = arr[i];
        }
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            metrics.incrementComparisons();
            if (aux[i] <= aux[j]) {
                arr[k++] = aux[i++];
            }
            else {
                arr[k++] = aux[j++];
            }
        }
        while (i <= mid) {
            arr[k++] = aux[i++];
        }
        while (j <= right) {
            arr[k++] = aux[j++];
        }
    }

    private static void insertionSort(int[] arr, int left, int right, Metrics metrics) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= left) {
                metrics.incrementComparisons();
                if(arr[j] > key) {
                    arr[j+1] = arr[j];
                    j--;
                }
                else {
                    break;
                }
            }
            arr[j+1] = key;
            metrics.incrementSwaps();
        }
    }
}
