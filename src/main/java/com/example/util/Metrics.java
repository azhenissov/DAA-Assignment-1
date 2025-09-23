package com.example.util;

public class Metrics {
    private long comparisons;
    private long swaps;
    private long recursionDepth;
    private long allocations;
    private long startTimeNs;
    private long endTimeNs;
    private int inputSize; // Added to match your CsvWriter

    public Metrics() {
        reset();
    }

    public void reset() {
        comparisons = 0;
        swaps = 0;
        recursionDepth = 0;
        allocations = 0;
        startTimeNs = 0;
        endTimeNs = 0;
        inputSize = 0;
    }

    public void setInputSize(int inputSize) {
        this.inputSize = inputSize;
    }

    public int getInputSize() {
        return inputSize;
    }

    public void incrementComparisons() {
        comparisons++;
    }

    public void incrementSwaps() {
        swaps++;
    }

    public void incrementRecursionDepth() {
        recursionDepth++;
    }

    public void incrementAllocations() {
        allocations++;
    }

    public void startTimer() {
        startTimeNs = System.nanoTime();
    }

    public void stopTimer() {
        endTimeNs = System.nanoTime();
    }

    public long getDuration() {
        return endTimeNs - startTimeNs;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public long getMaxDepth() {
        return recursionDepth;
    }

    public long getAllocations() {
        return allocations;
    }

    public String toCsvRow(String algorithm, int inputSize) {
        return String.format("%s,%d,%d,%d,%d,%d,%d",
                algorithm, inputSize, getDuration(), comparisons, swaps, recursionDepth, allocations);
    }
}