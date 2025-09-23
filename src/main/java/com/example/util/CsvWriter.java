package com.example.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
    private final String filePath;
    private boolean headerWritten;

    public CsvWriter(String filePath) throws IOException {
        this.filePath = filePath;
        this.headerWritten = false;
    }

    public void writeHeader() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            writer.write("algorithm,input_size,runtime_ns,comparisons,swaps,recursion_depth,allocations");
            writer.newLine();
            headerWritten = true;
        }
    }

    public void writeRow(String algorithm, int inputSize, Metrics metrics) throws IOException {
        if (!headerWritten) {
            writeHeader();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            String row = metrics.toCsvRow(algorithm, inputSize);
            writer.write(row);
            writer.newLine();
        }
    }


    public void close() throws IOException {
    }
}
