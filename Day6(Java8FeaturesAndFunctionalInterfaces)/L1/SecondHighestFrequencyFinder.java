package java_functional_interfaces;

import java.util.*;
import java.util.stream.Collectors;

public class SecondHighestFrequencyFinder {
    public static String findSecondHighestFrequencyWord(String str) {
        // Step 1: Tokenize the sequence into words and count word frequencies
        Map<String, Long> wordCountMap = Arrays.stream(str.split("\\s+")) // Split by whitespace
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        // Step 2: Find the distinct frequencies in descending order
        List<Long> sortedFrequencies = wordCountMap.values().stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();

        if (sortedFrequencies.size() < 2) {
            return null; // No second-highest frequency exists
        }

        // Step 3: Get the second-highest frequency
        long secondHighestFrequency = sortedFrequencies.get(1);

        // Step 4: Find any word with the second highest frequency
        return wordCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() == secondHighestFrequency)
                .map(Map.Entry::getKey)
                .findFirst() // Get any word with the second highest frequency
                .orElse(null); // Return null if no such word is found
    }

    public static void main(String[] args) {
        String str = "hello world hello everyone hello world";
        System.out.println("Second highest frequency word: " + findSecondHighestFrequencyWord(str));
    }
}