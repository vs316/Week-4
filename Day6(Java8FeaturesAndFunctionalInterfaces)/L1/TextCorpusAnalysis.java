package java_functional_interfaces;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TextCorpusAnalysis {
    public static void main(String[] args) throws IOException {
        // Step 1: Read the text corpus
        String corpus = readTextCorpus("corpus.txt");

        // Step 2: Tokenize the text into words
        List<String> words = Arrays.stream(corpus.split("\\W+")) // Split by non-word characters
                .map(String::toLowerCase) // Convert to lowercase
                .collect(Collectors.toList());

        // Step 3: Count the frequency of each word
        Map<String, Long> wordFrequency = words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        // Step 4: Find the top N most frequent words
        int topN = 5;
        List<Map.Entry<String, Long>> topWords = wordFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()) // Sort by frequency in descending order
                .limit(topN) // Limit to top N
                .collect(Collectors.toList());

        // Step 5: Display the top N words and their frequencies
        System.out.println("Top " + topN + " Most Frequent Words:");
        topWords.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
    }

    private static String readTextCorpus(String fileName) throws IOException {
        // Reading the text corpus from a file
        StringBuilder corpus = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                corpus.append(line).append(" ");
            }
        }
        return corpus.toString();
    }
}
