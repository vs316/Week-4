package JavaCollections.ListInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RotateElementsInList {
    public static List<Integer> rotateList(List<Integer> list, int positions) {
        // Handle cases where positions are greater than the list size
        positions = positions % list.size();
        if (positions < 0) {
            positions += list.size();
        }

        // Rotate the list
        Collections.rotate(list, -positions);
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10, 20, 30, 40, 50);

        int rotateBy = 2;
        System.out.println("Original List: " + list);
        List<Integer> rotatedList = rotateList(list, rotateBy);
        System.out.println("Rotated List: " + rotatedList);
    }
}