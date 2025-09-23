package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class MergeSortTest {
    @Test
    public void testEmptyArray() {
        int[] arr = {};
        Metrics metrics = new Metrics();
        MergeSort.sort(arr, metrics);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {52};
        Metrics metrics = new Metrics();
        MergeSort.sort(arr, metrics);
        assertArrayEquals(new int[]{52}, arr);
    }

    @Test
    void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        Metrics metrics = new Metrics();
        MergeSort.sort(arr, metrics);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReversedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        Metrics metrics = new Metrics();
        MergeSort.sort(arr, metrics);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testRandomArray() {
        int[] arr = {10, -7, 1, 0, 2};
        Metrics metrics = new Metrics();
        MergeSort.sort(arr, metrics);
        assertArrayEquals(new int[]{10, -7, 1, 0, 2}, arr);
    }
}
