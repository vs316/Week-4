package JavaCollections.ListInterface;

import java.util.*;

public class ReverseList {
    public static void reverseList(List<Integer> list) { // reverse ArrayList or LinkedList without using
                                                         // Collections.reverse()
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            Integer temp = list.get(i);
            list.set(i, list.get(size - 1 - i));
            list.set(size - 1 - i, temp);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        reverseList(list);
        System.out.println(list);

        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(6);
        list1.add(7);
        list1.add(8);
        list1.add(9);
        list1.add(10);
        reverseList(list1);
        System.out.println(list1);
    }
}