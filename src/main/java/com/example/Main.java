package com.example;

import com.example.Metrics;
import com.example.CsvWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, IOException {
        Metrics metrics = new Metrics();
        CsvWriter csvWriter = new CsvWriter("metrics.csv");

        // Simulate algorithm run
        metrics.startTimer();
        metrics.incrementComparisons();
        metrics.incrementSwaps();
        metrics.incrementRecursionDepth();
        metrics.incrementAllocations();
        metrics.stopTimer();

        // Write metrics
        csvWriter.writeRow("mergesort", 1000, metrics);
    }
}