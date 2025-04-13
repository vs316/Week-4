package java_exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderWithResources {
    public static void main(String[] args) {
        // Try-with-resources ensures BufferedReader is closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader("info.txt"))) {
            String firstLine = reader.readLine();
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("File is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
