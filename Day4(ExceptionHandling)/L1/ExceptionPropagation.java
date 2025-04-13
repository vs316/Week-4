package java_exceptions;

public class ExceptionPropagation {
    // Method 1: Throws ArithmeticException
    public static void method1() {
        int result = 10 / 0; // Division by zero triggers ArithmeticException
    }

    // Method 2: Calls method1()
    public static void method2() {
        method1(); // Exception propagates to this method
    }

    // Main method: Calls method2() and handles the exception
    public static void main(String[] args) {
        try {
            method2(); // Exception propagates to main()
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main: " + e.getMessage());
        }
    }
}