package com.example;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Metrics metrics = new Metrics();
        int[] arr = {5,2,9,-1,6,0};

        QuickSort.sort(arr, metrics);

        CsvWriter csvWriter = new CsvWriter("metrics.csv");
        csvWriter.writeRow("quicksort", arr.length, metrics);

        System.out.println("Sorted Array:");
        for (int n : arr){
            System.out.print(n + " ");
        }
        System.out.println(" ");
        System.out.println(metrics.getDuration()/1000000.0);
    }
}