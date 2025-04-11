package JavaCollections.SetInterface;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CheckForSubsets {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        // Check if set1 is a subset of set2
        if (set1.containsAll(set2)) {
            System.out.println("set1 is a subset of set2");
        } else {
            System.out.println("set1 is not a subset of set2");
        }
    }
}