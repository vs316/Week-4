package java_functional_interfaces;

import java.util.Arrays;
import java.util.List;

public class MapAndReduceOps {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        //sum of squares of all even numbers
        int sumOfSquaresOfEvenNumbers = list.stream().filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum of squares of even numbers: " + sumOfSquaresOfEvenNumbers);
    }

}
