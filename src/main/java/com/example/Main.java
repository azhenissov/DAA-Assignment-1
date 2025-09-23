package com.example;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Metrics metrics = new Metrics();
        int[] arr = {5,2,9,-1,6,0};

        MergeSort.sort(arr,metrics);

        CsvWriter csvWriter = new CsvWriter("metrics.csv");
        csvWriter.writeRow("mergesort", arr.length, metrics);

        System.out.println("Sorted Array:");
        for (int n : arr){
            System.out.print(n + " ");
        }
    }
}