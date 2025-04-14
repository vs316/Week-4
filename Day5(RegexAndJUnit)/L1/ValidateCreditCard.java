package java_regex;

import java.util.regex.Pattern;


public class ValidateCreditCard {
    public static void main(String[] args) {
        String visaCard = "4123456789012345"; // Example Visa card
        String masterCard = "5123456789012345"; // Example MasterCard

        // Regular expressions
        String visaRegex = "^4\\d{15}$";
        String masterRegex = "^5\\d{15}$";

        // Validate Visa card
        boolean isVisaValid = Pattern.matches(visaRegex, visaCard);
        System.out.println("Is Visa card valid? " + isVisaValid);

        // Validate MasterCard
        boolean isMasterValid = Pattern.matches(masterRegex, masterCard);
        System.out.println("Is MasterCard valid? " + isMasterValid);
    }
}

