package java_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDate {
    public static void main(String[] args) {
        String text="The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        // Regular expression to match dates in the format dd/mm/yyyy
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";
        // Compile the regex pattern
        Pattern pattern= Pattern.compile(regex);
        // Match the pattern against the text
        Matcher matcher= pattern.matcher(text);
        System.out.println("Extracted Dates:");
        // Iterate through all matches
        while (matcher.find()) {
            // Print each date found
            System.out.println(matcher.group());
        }
    }
}
