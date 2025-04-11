package JavaCollections.MapInterface;

// Merge Two Maps Merge two maps such that if a key exists in both,sum their values.Example:Map1:{A=1,B=2},Map2:{B=3,C=4}→Output:{A=1,B=5,C=4}.
import java.util.*;

public class MergeTwoMaps {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>(Map.of("A", 1, "B", 2));
        Map<String, Integer> map2 = new HashMap<>(Map.of("B", 3, "C", 4));

        Map<String, Integer> mergedMap = new HashMap<>(map1);

        map2.forEach((key, value) -> mergedMap.merge(key, value, Integer::sum));

        System.out.println("Map1: " + map1);
        System.out.println("Map2: " + map2);
        System.out.println("Merged Map: " + mergedMap);
    }
}