package javastreams;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ConvertUpperCaseToLowerCaseLetters {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\JavaStreams\\input.txt";
        String outputPath = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\JavaStreams\\output.txt";

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputPath), StandardCharsets.UTF_8));
                BufferedWriter bw = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(outputPath), StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }
            System.out.println("File has been successfully converted!");

        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}