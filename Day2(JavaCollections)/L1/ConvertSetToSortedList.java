package JavaCollections.SetInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConvertSetToSortedList {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1, 9));

        // Convert the set to a sorted list
        ArrayList<Integer> sortedList = new ArrayList<>(set);
        sortedList.sort(Integer::compareTo);

        System.out.println("Sorted List: " + sortedList);

    }
}