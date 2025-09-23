package com.example;

import java.util.Random;

public class QuickSort {
    private static final int CUTOFF = 12;
    private static Random RAND = new Random();


    public static void sort(int[] arr, Metrics metrics) {
        metrics.reset();
        metrics.setInputSize(arr.length);
        metrics.startTimer();

        quickSort(arr, 0, arr.length-1, metrics);
        metrics.stopTimer();
    }

    private static void quickSort(int[] arr, int left, int right, Metrics metrics) {
        while (left < right) {
            if(right - left + 1 <= CUTOFF) {
                insertionSort(arr, left, right, metrics);
                return;
            }
        }
        // Randomized pivot
        int pivotIndex = left + RAND.nextInt(right - left + 1);
        swap(arr, pivotIndex, right, metrics);

        //partition
        int p = partition(arr, left, right, metrics);

        // recurse into smaller side first
        if(p - left < right - p){
            quickSort(arr, left, p - 1, metrics);
            left = p + 1; // iterate right side
        } else{
            quickSort(arr, p + 1, right, metrics);
            right = p - 1; // iterate left side
        }
    }

    private static int partition(int[] arr, int left, int right, Metrics metrics) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            metrics.incrementComparisons();
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j, metrics);
            }
        }

        swap(arr, i + 1, right, metrics);
        return i + 1;
    }

    private static void insertionSort(int[] arr, int left, int right, Metrics metrics) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >=left){
                metrics.incrementComparisons();
                if(arr[j] > key){
                    arr[j+1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }
            arr[j+1] = key;
            metrics.incrementSwaps();
        }
    }

    public static void swap(int[] arr, int i, int j, Metrics metrics) {
        if (i!=j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            metrics.incrementSwaps();
        }
    }
}
