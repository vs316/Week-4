package junit_tests;

public class DivByZero {
    public static int divide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Division by zero is not allowed.");
            return 0;
        }
    }
}
