package java_regex;

import java.util.regex.Pattern;

public class ValidateSSN {
    public static void main(String[] args) {
        String validSSN = "123-45-6789"; // Example of a valid SSN
        String invalidSSN = "123456789"; // Example of an invalid SSN

        // Regular expression to validate SSN format
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";

        // Validate valid SSN
        boolean isValidSSN1 = Pattern.matches(regex, validSSN);
        System.out.println("✅ \"" + validSSN + "\" is " + (isValidSSN1 ? "valid" : "invalid"));

        // Validate invalid SSN
        boolean isValidSSN2 = Pattern.matches(regex, invalidSSN);
        System.out.println("❌ \"" + invalidSSN + "\" is " + (isValidSSN2 ? "valid" : "invalid"));
    }
}
