package JavaCollections.MapInterface;

import java.util.*;

public class FindKeyWithMaxValue {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        String keyWithMaxValue = "";
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                keyWithMaxValue = entry.getKey();
                maxValue = entry.getValue();
            }
        }
        System.out.println("Key with maximum value: " + keyWithMaxValue);
    }
}
