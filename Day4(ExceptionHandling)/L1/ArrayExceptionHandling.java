package java_exceptions;

import java.util.Scanner;

public class ArrayExceptionHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] numbers = {10, 20, 30, 40, 50};
        //  Integer[] numbers = null; // Uncomment to trigger NullPointerException

        try {
            System.out.print("Enter an index to retrieve value: ");
            int index = scanner.nextInt();

            // Retrieving value from the array
            System.out.println("Value at index " + index + ": " + numbers[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index! Please enter a valid index within range.");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (Exception e) {
            System.out.println("Unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close(); // Close scanner to prevent resource leaks
        }
    }
}