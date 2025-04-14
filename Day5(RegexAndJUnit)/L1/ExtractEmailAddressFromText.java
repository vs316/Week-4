package java_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmailAddressFromText {
    public static void main(String[] args) {
        String text = "Please contact us at support@example.com and info@company.org.";
        // Regular expression to match email addresses
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);
        // Match the pattern against the text
        Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted Email Addresses:");
        // Iterate through all matches
        while (matcher.find()) {
            // Print each email address found
            System.out.println(matcher.group());
        }
    }
}