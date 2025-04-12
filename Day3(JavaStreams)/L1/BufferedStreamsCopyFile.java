package javastreams;

import java.io.*;

public class BufferedStreamsCopyFile {
    private static final int BUFFER_SIZE = 4096; // 4KB buffer size

    public static void main(String[] args) {
        String sourcePath = "src\\JavaStreams\\large_file.txt";
        String bufferedOutputPath = "src\\JavaStreams\\large_file_buffered_copy.txt";
        String unbufferedOutputPath = "src\\JavaStreams\\large_file_unbuffered_copy.txt";

        // First, create a large file for testing if it doesn't exist
        createLargeFile(sourcePath);

        // Test with buffered streams
        long bufferedTime = copyWithBufferedStreams(sourcePath, bufferedOutputPath);

        // Test with unbuffered streams
        long unbufferedTime = copyWithUnbufferedStreams(sourcePath, unbufferedOutputPath);

        // Print performance comparison
        System.out.println("\nPerformance Comparison:");
        System.out.println("Buffered Streams took: " + bufferedTime + " nanoseconds (" +
                (bufferedTime / 1_000_000.0) + " milliseconds)");
        System.out.println("Unbuffered Streams took: " + unbufferedTime + " nanoseconds (" +
                (unbufferedTime / 1_000_000.0) + " milliseconds)");
        System.out.println("Difference: " + ((unbufferedTime - bufferedTime) / 1_000_000.0) + " milliseconds");
        System.out.println(
                "Buffered streams were " + String.format("%.2f", (double) unbufferedTime / bufferedTime) + "x faster");
    }

    private static void createLargeFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                System.out.println("Creating large test file...");
                // Create a file of approximately 100MB
                for (int i = 0; i < 1_000_000; i++) {
                    writer.write(
                            "This is a line of text that will be repeated many times to create a large file for testing purposes.\n");
                }
                System.out.println("Large test file created successfully!");
            } catch (IOException e) {
                System.out.println("Error creating large file: " + e.getMessage());
            }
        }
    }

    private static long copyWithBufferedStreams(String sourcePath, String destPath) {
        long startTime = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            long endTime = System.nanoTime();
            System.out.println("File copied successfully using buffered streams!");
            return endTime - startTime;

        } catch (IOException e) {
            System.out.println("Error during buffered copy: " + e.getMessage());
            return -1;
        }
    }

    private static long copyWithUnbufferedStreams(String sourcePath, String destPath) {
        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(sourcePath);
                FileOutputStream fos = new FileOutputStream(destPath)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            long endTime = System.nanoTime();
            System.out.println("File copied successfully using unbuffered streams!");
            return endTime - startTime;

        } catch (IOException e) {
            System.out.println("Error during unbuffered copy: " + e.getMessage());
            return -1;
        }
    }
}