package com.example;

import com.example.util.Metrics;

import java.util.Random;

public class SortUtils {

    private static final Random RAND  = new Random();
    public static void swap(int[] arr, int i, int j, Metrics metrics) {
        if (i != j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            metrics.incrementSwaps();
        }
    }

    public static int partition(int[] arr, int left, int right, Metrics metrics) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            metrics.incrementComparisons();
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j, metrics);
            }
        }
        swap(arr, i +1, right, metrics);
        return i +1;
    }

    // Guard: checking arrat is sorted ascending

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    // randomly shuffle arr

    public static void shuffle(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = RAND.nextInt(i + 1);
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }
}
