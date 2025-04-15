package java_functional_interfaces;

@FunctionalInterface
interface CustomFunctionalInterface {
    int calcSquareOfNumber(int num);

    // default method
    default void printMessage(int num) {
        System.out.println("Square of " + num + " is: " + calcSquareOfNumber(num));
    }
}

public class CustomFuncInterface {
    public static void main(String[] args) {
        // Using a lambda expression to implement the functional interface
        CustomFunctionalInterface squareCalculator = num -> num * num;

        // Calculate and print the square of a number
        int number = 5;
        squareCalculator.printMessage(number);
    }
}
