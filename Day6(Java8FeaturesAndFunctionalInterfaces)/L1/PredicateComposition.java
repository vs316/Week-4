package java_functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateComposition {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Alice", "Bob", "Charlie", "David", "Aman", "Alok");

        Predicate<String> lengthGreaterThanFive = str -> str.length() > 5;
        Predicate<String> containsSubstring = str -> str.contains("a");

        Predicate<String> combinedPredicate = lengthGreaterThanFive.and(containsSubstring);

        List<String> filteredList = list.stream()
                                        .filter(combinedPredicate)
                                        .toList();

        System.out.println("Filtered list: " + filteredList);
    }
}
