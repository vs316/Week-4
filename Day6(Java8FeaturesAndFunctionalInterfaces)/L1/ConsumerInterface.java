package java_functional_interfaces;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterface {
    public static void main(String[] args) {
        List<String> stringList= List.of("Alice", "Bob", "Charlie", "David", "Eve","Fay");
        Consumer<String> printConsumer = s -> System.out.println(s);
        Consumer<String> toUpperCase=s-> System.out.println(s.toUpperCase());

        // Using the Consumer interface to print each string in the list
        System.out.println("Printing strings:");
        stringList.forEach(printConsumer);
        System.out.println("Printing strings in uppercase:");
        stringList.forEach(toUpperCase);

    }
}
