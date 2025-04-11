package JavaCollections.ListInterface;

import java.util.LinkedList;
import java.util.Scanner;

public class FindNthElementFromEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the position of element from end:");
        int n = sc.nextInt();
        System.out.println("Original List: " + list);
        System.out.println("Nth Element from the end: " + list.get(list.size() - n));
        sc.close();
    }
}