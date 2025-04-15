package java_functional_interfaces;

import java.util.Arrays;
import java.util.List;

public class FilterList {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Aman", "Alok");
        List<String> filteredNames = names.stream()
                                          .filter(name -> name.startsWith("A"))
                                          .toList();
        System.out.println("Filtered names: " + filteredNames);
    }
}
