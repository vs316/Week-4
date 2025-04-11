package JavaCollections.ListInterface;

import java.util.*;

public class FindFrequencyOfElementsInList {
    public static Map<String, Integer> findFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String element : list) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> inputList = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> result = findFrequency(inputList);
        System.out.println(result);
    }
}