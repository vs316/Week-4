package JavaCollections.SetInterface;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindSymmetricDifferenceOfTwoSets {
    public static void main(String[] args) {
        // Create two sets
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        // Find the symmetric difference of the sets
        Set<Integer> symmetricDifference = new HashSet<>(set1);
        symmetricDifference.addAll(set2);
        // Calculate intersection
        Set<Integer> common = new HashSet<>(set1);
        common.retainAll(set2);
        // System.out.println("Intersection: " + common);
        // Remove common elements from the union to get symmetric difference
        symmetricDifference.removeAll(common);
        System.out.println("Symmetric Difference: " + symmetricDifference);
    }
}