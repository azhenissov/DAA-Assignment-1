package com.example;
import static org.junit.jupiter.api.Assertions.*;

import com.example.util.Metrics;
import org.junit.jupiter.api.Test;

public class ClosestPairTest {
    @Test
    void testSimpleCase(){
        ClosestPair.Point[] points = {
                new ClosestPair.Point(0,0),
                new ClosestPair.Point(3,4),
                new ClosestPair.Point(0,7),
                new ClosestPair.Point(1,1),
        };
        Metrics m = new Metrics();
        double dist = ClosestPair.findClosest(points, m);
        assertEquals(Math.sqrt(2), dist, 1e-6);
    }
    @Test
    void testCollinearPoints() {
        ClosestPair.Point[] points = {
                new ClosestPair.Point(0,0),
                new ClosestPair.Point(1,0),
                new ClosestPair.Point(2,0),
                new ClosestPair.Point(3,0)
        };
        Metrics m = new Metrics();
        double dist = ClosestPair.findClosest(points, m);
        assertEquals(1.0, dist, 1e-9);
    }

    @Test
    void testRandomPoints() {
        ClosestPair.Point[] points = {
                new ClosestPair.Point(10,10),
                new ClosestPair.Point(20,20),
                new ClosestPair.Point(15,14),
                new ClosestPair.Point(16,13)
        };
        Metrics m = new Metrics();
        double dist = ClosestPair.findClosest(points, m);
        assertEquals(Math.sqrt(2), dist, 1e-6);
    }
}
