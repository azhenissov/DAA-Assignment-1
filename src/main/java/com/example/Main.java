package com.example;


import com.example.util.CsvWriter;
import com.example.util.Metrics;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ClosestPair.Point[] pts = {
                new ClosestPair.Point(0,0),
                new ClosestPair.Point(5,6),
                new ClosestPair.Point(3,4),
                new ClosestPair.Point(7,7),
                new ClosestPair.Point(1,1)
        };
        Metrics metrics = new Metrics();
        double d = ClosestPair.findClosest(pts, metrics);

        System.out.println("Closest distance: " + d);
        System.out.println("Runtime (ms): " + metrics.getDuration() / 1000000.0);
    }
}