package JavaCollections.SetInterface;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersectionOfTwoSets {
    public static void main(String[] args) {
        // Creating two sets
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6, 7));

        // Finding the union of the sets
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union: " + union);

        // Finding the intersection of the sets
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);

    }
}