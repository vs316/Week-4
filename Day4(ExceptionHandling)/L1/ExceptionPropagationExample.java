package java_exceptions;

public class ExceptionPropagationExample {

    // Method that throws an exception if input is invalid
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive.");
        }
        return amount * (rate / 100) * years; // Simple interest formula
    }

    public static void main(String[] args) {
        try {
            double amount = 5000;
            double rate = -5; // Invalid rate to test exception
            int years = 3;

            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated Interest: " + interest);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}