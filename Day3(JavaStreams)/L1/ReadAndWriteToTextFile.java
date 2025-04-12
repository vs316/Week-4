package javastreams;

import java.io.*;

public class ReadAndWriteToTextFile {
    public static void main(String[] args) {
        // Define input and output file paths
        String inputPath = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\JavaStreams\\input.txt";
        String outputPath = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\JavaStreams\\output.txt";

        // Read from input file and write to output file using FileInputStream and
        // FileOutputStream
        try (FileInputStream fis = new FileInputStream(inputPath);
                FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            // Read from input file and write to output file
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully!");

        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An error occurred during file operations: " + e.getMessage());
        }
    }
}
