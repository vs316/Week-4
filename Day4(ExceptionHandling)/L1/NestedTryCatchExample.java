package java_exceptions;

import java.util.Scanner;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example array
        int[] numbers = {10, 20, 30, 40, 50};

        try {
            // Taking index input
            System.out.print("Enter an index to retrieve value: ");
            int index = scanner.nextInt();

            try {
                // Retrieving value from array
                int value = numbers[index];

                // Taking divisor input
                System.out.print("Enter a divisor: ");
                int divisor = scanner.nextInt();

                try {
                    // Performing division
                    int result = value / divisor;
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close(); // Ensures scanner resource is closed properly
        }
    }
}