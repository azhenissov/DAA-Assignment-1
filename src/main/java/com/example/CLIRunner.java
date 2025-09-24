package com.example;

import com.example.util.CsvWriter;
import com.example.util.Metrics;

import java.io.IOException;
import java.util.Random;

public class CLIRunner {

    public static void main(String[] args) throws IOException {
        String algo = null;
        int size = 0;
        String output = "metrics.csv";

        // --- простейший парсер аргументов ---
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--algo" -> algo = args[++i];
                case "--size" -> size = Integer.parseInt(args[++i]);
                case "--output" -> output = args[++i];
                default -> {
                    System.err.println("Unknown argument: " + args[i]);
                    return;
                }
            }
        }

        if (algo == null || size <= 0) {
            System.err.println("Usage: --algo <mergesort|quicksort|select|closest> --size <N> [--output <file.csv>]");
            return;
        }

        // --- создаём данные ---
        Random rnd = new Random(42);
        Metrics metrics = new Metrics();

        switch (algo) {
            case "mergesort" -> {
                int[] arr = rnd.ints(size, 0, 10000).toArray();
                MergeSort.sort(arr, metrics);
            }
            case "quicksort" -> {
                int[] arr = rnd.ints(size, 0, 10000).toArray();
                QuickSort.sort(arr, metrics);
            }
            case "select" -> {
                int[] arr = rnd.ints(size, 0, 10000).toArray();
                int k = size / 2;
                int kth = DeterministicSelect.select(arr, k, metrics);
                System.out.println("k-th element (k=" + k + "): " + kth);
            }
            case "closest" -> {
                ClosestPair.Point[] pts = new ClosestPair.Point[size];
                for (int i = 0; i < size; i++) {
                    pts[i] = new ClosestPair.Point(rnd.nextDouble() * 1000, rnd.nextDouble() * 1000);
                }
                double d = ClosestPair.findClosest(pts, metrics);
                System.out.println("Closest distance: " + d);
            }
            default -> {
                System.err.println("Unknown algo: " + algo);
                return;
            }
        }

        // --- сохраняем CSV ---
        CsvWriter writer = new CsvWriter(output);
        writer.writeRow(algo, size, metrics);

        System.out.printf("✅ %s done (N=%d). Runtime: %.3f ms%n",
                algo, size, metrics.getDuration() / 1_000_000.0);
    }
}
