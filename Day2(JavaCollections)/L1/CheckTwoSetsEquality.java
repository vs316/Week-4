package JavaCollections.SetInterface;

import java.util.HashSet;
import java.util.Set;

public class CheckTwoSetsEquality {

    public static void main(String[] args) {
        // Create two sets
        Set<Integer> set1 = new HashSet<>();
        set1.add(10);
        set1.add(20);
        set1.add(30);
        set1.add(40);
        set1.add(50);
        System.out.println("Set 1: " + set1);
        // Create another set
        Set<Integer> set2 = new HashSet<>();
        set2.add(10);
        set2.add(20);
        set2.add(30);
        set2.add(40);
        set2.add(50);
        System.out.println("Set 2: " + set2);
        // Check if the sets are equal
        if (set1.equals(set2)) {
            System.out.println("The sets are equal.");
        } else {
            System.out.println("The sets are not equal.");
        }
    }
}
