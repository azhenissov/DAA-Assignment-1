package com.example;


import com.example.util.CsvWriter;
import com.example.util.Metrics;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] arr = {12, 3, 5, 7, 19, 26, 4, 8};
        Metrics metrics = new Metrics();

        int k = 4;
        int val = DeterministicSelect.select(arr, k, metrics);
        System.out.println("The " + (k + 1) + "-th smallest element is " + val);
        System.out.println("Runtime " +metrics.getDuration() / 1000000.0);
    }
}