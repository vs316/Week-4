package javastreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadUserInputAndWriteToFile {
    public static void main(String[] args) {
        // Define input and output file paths
        String outputPath = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\javastreams\\output.txt";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            System.out.println("Enter your name: ");
            String name = reader.readLine();
            System.out.println("Enter your age: ");
            int age = Integer.parseInt(reader.readLine());
            System.out.println("Enter your favourite programming language: ");
            String favProgLang = reader.readLine();

            // Write user input to the output file
            writer.write("Name: " + name);
            writer.newLine();
            writer.write("Age: " + age);
            writer.newLine();
            writer.write("Favourite Programming Language: " + favProgLang);
            writer.newLine();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}