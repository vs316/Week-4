package JavaCollections.ListInterface;

import java.util.ArrayList;

public class RemoveDuplicatesWhileMaintainingOrder {
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer i : list) {
            if (!result.contains(i)) {
                result.add(i);
            } else {
                System.out.println("Duplicate found: " + i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("Original List: " + list);
        System.out.println("List with Duplicates Removed: " + removeDuplicates(list));
    }
}
