package com.example;

import com.example.util.Metrics;

import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {

    public static class Point{
        public final double x, y;
        public Point(double x, double y) {
            this.x = x; this.y = y;
        }
    }


    public static double findClosest(Point[] points,Metrics metrics){
        metrics.reset();
        metrics.setInputSize(points.length);
        metrics.startTimer();

        Point[] ptsByX = points.clone();
        Arrays.sort(ptsByX, Comparator.comparingDouble(p -> p.x));

        Point[] aux = new Point[points.length];
        double result = closestRec(ptsByX,aux,0,points.length-1,metrics);

        metrics.stopTimer();
        return result;
    }

    private static double closestRec(Point[] ptsByX, Point[] aux, int left, int right, Metrics metrics) {
        if(right - left <=3){
            return bruteForce(ptsByX, left, right, metrics);
        }

        int mid = (left + right)/2;
        double midX = ptsByX[mid].x;

        double dl = closestRec(ptsByX, aux, left, mid, metrics);
        double dr = closestRec(ptsByX, aux, mid+1, right, metrics);
        double d = Math.min(dl, dr);

        int stripSize = 0;
        for (int i = left; i <= right; i++){
            if(Math.abs(ptsByX[i].x - midX) < d){
                aux[stripSize++] = ptsByX[i];
            }
        }

        Arrays.sort(aux,0,stripSize,Comparator.comparingDouble(p -> p.y));

        for(int i = 0; i < stripSize; i++){
            for(int j = i+1;j<stripSize && (aux[j].y - aux[i].y) < d; j++){
                double dist = dist(aux[i], aux[j], metrics);
                if(dist < d){
                    d = dist;
                }
            }
        }
        return d;
    }

    private static double bruteForce(Point[] pts, int left, int right, Metrics metrics) {
        double min = Double.POSITIVE_INFINITY;
        for(int i = left; i <= right; i++) {
            for(int j = i+1; j <= right; j++) {
                double dist = dist(pts[i], pts[j], metrics);
                if(dist < min) {
                    min = dist;
                }
            }
        }
        return min;
    }

    private static double dist(Point a, Point b, Metrics metrics) {
        metrics.incrementComparisons();
        return Math.hypot(a.x - b.x, a.y - b.y);
    }
}
