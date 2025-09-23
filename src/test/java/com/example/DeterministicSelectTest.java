package com.example;

import com.example.util.Metrics;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DeterministicSelectTest {

    @Test
    void testSelectSmallArray() {
        int[] arr = {7, 1, 5, 3, 9};
        Metrics metrics = new Metrics();
        int kth = DeterministicSelect.select(arr, 2, metrics); // 3-й по порядку
        assertEquals(5, kth);
    }

    @Test
    void testSelectSortedArray() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Metrics metrics = new Metrics();
        assertEquals(1, DeterministicSelect.select(arr.clone(), 0, metrics));
        assertEquals(4, DeterministicSelect.select(arr.clone(), 3, metrics));
        assertEquals(7, DeterministicSelect.select(arr.clone(), 6, metrics));
    }

    @Test
    void testSelectRandomArray() {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        Metrics metrics = new Metrics();
        int kth = DeterministicSelect.select(arr, 3, metrics);
        Arrays.sort(arr);
        assertEquals(arr[3], kth);
    }
}
