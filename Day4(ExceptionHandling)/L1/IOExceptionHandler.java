package java_exceptions;

import java.io.*;

public class IOExceptionHandler {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\java_exceptions\\data.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("FIle not found. Please check if 'data.txt' exists.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
