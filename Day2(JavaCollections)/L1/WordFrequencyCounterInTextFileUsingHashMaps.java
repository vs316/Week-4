package JavaCollections.MapInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounterInTextFileUsingHashMaps {
    public static void main(String[] args) {
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        String filepath = "C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\JavaCollections\\MapInterface\\textfile.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}