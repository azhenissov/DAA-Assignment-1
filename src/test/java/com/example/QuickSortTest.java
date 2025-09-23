package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {
    @Test
    void testEmptyArray() {
        int[] arr = {};
        Metrics metrics = new Metrics();
        QuickSort.sort(arr, metrics);
        assertArrayEquals(new int[] {}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {1};
        Metrics metrics = new Metrics();
        QuickSort.sort(arr, metrics);
        assertArrayEquals(new int[] {1}, arr);
    }

    @Test
    void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        Metrics metrics = new Metrics();
        QuickSort.sort(arr, metrics);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReversedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        Metrics metrics = new Metrics();
        QuickSort.sort(arr, metrics);
        assertArrayEquals(new int[] {1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testRandomArray() {
        int[] arr = {10, -2, 0, 11, 5};
        Metrics metrics = new Metrics();
        QuickSort.sort(arr, metrics);
        assertArrayEquals(new int[] {10, -2, 0, 11, 5}, arr);
    }
}
