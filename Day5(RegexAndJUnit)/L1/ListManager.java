package junit_tests;

import java.util.List;

public class ListManager {
    public static void addElement(List<Integer> list, int e) {
        list.add(e);
    }

    public static void removeElement(List<Integer> list, int e) {
        list.remove(Integer.valueOf(e));
    }

    public static int getSize(List<Integer> list) {
        return list.size();
    }

    public static int getLastElement(List<Integer> list) {
        return list.get(list.size() - 1);
    }
}
