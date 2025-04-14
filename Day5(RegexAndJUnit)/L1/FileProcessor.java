package junit_tests;

import java.io.*;

public class FileProcessor {
    private final static String filePath = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\sample.txt";

    public static void writeToFile(String filename, String content) {
        if (doesFileMatch(filename)) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(content);
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file: " + e.getMessage());
            }
        } else {
            System.out.println("Filename does not match the filePath.");
        }
    }

    public static String readFromFile(String filename) {
        if (doesFileMatch(filename)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                StringBuilder content = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                return content.toString();
            } catch (IOException e) {
                System.out.println("An error occurred while reading from the file: " + e.getMessage());
            }
        } else {
            System.out.println("Filename does not match the filePath.");
        }
        return null;
    }

    // Helper method to check if the filename matches the last part of the filePath
    private static boolean doesFileMatch(String filename) {
        File file = new File(filePath);
        String actualFilename = file.getName(); // Extract the last part of the filePath
        return actualFilename.equals(filename);
    }
}