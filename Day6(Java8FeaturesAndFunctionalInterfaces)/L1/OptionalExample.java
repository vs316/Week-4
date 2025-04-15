package java_functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // Sample list of integers
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        // Find the maximum value using stream and return as Optional
        Optional<Integer> maxOptional = numbers.stream().max(Integer::compare);

        // Handle the case when the list is empty
        if (maxOptional.isPresent()) {
            System.out.println("Maximum value: " + maxOptional.get());
        } else {
            System.out.println("The list is empty. No maximum value.");
        }

        // Example with an empty list
        List<Integer> emptyList = List.of();
        Optional<Integer> maxEmpty = emptyList.stream().max(Integer::compare);

        System.out.println("Result for empty list: " + maxEmpty.orElse(null));
    }
}
