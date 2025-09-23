package com.example;

import com.example.util.Metrics;

import java.util.Arrays;

public class DeterministicSelect {

    private static final int GROUP_SIZE = 5;


    public static int select(int[] arr, int k, Metrics metrics) {
        if (k < 0 || k >= arr.length) {
            throw new IllegalArgumentException("k is out of bounds");
        }
        metrics.reset();
        metrics.setInputSize(arr.length);
        metrics.startTimer();

        int result = momSelect(arr, 0, arr.length - 1, k, metrics);

        metrics.stopTimer();
        return result;
    }

    private static int momSelect(int[] arr, int left, int right, int k, Metrics metrics) {
        while (true) {
            if (left == right) {
                return arr[left];
            }

            int pivotIndex = pivotIndex(arr, left, right, metrics);

            int p = SortUtils.partition(arr, left, right, metrics);

            if (k == p) {
                return arr[p];
            } else if (k < p) {
                right = p - 1;
            } else {
                left = p + 1;
            }
        }
    }

    private static int pivotIndex(int[] arr, int left, int right, Metrics metrics) {
        int n = right - left + 1;
        if (n <= GROUP_SIZE) {
            Arrays.sort(arr, left, right + 1);
            return left + n / 2;
        }

        int numMedians = (int) Math.ceil((double) n / GROUP_SIZE);
        for (int i = 0; i < numMedians; i++) {
            int subLeft = left + i * GROUP_SIZE;
            int subRight = Math.min(subLeft + GROUP_SIZE - 1, right);

            Arrays.sort(arr, subLeft, subRight + 1);
            int medianIndex = subLeft + (subRight - subLeft) / 2;

            // Move median to the beginning
            SortUtils.swap(arr, left + i, medianIndex, metrics);
        }

        // Recursively find median of medians
        return pivotIndex(arr, left, left + numMedians - 1, metrics);
    }
}
