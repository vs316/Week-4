package JavaCollections.MapInterface;

import java.util.*;

public class InvertMap {
    public static void main(String[] args) {
        Map<String, Integer> originalMap = new HashMap<>();
        List<String> keys = new LinkedList<>();

        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        for (Map.Entry<String, Integer> entry : originalMap.entrySet()) {
            keys.add(entry.getKey());
        }
        Map<Integer, List<String>> invertedMap = new HashMap<>();
        for (String key : keys) {
            Integer value = originalMap.get(key);
            invertedMap.putIfAbsent(value, new ArrayList<>());
            invertedMap.get(value).add(key);
        }
        System.out.println(invertedMap);
    }
}