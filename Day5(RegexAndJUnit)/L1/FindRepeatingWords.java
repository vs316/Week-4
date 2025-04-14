package java_regex;

public class FindRepeatingWords {
    public static void main(String[] args) {
        String input = "This is is a repeated repeated word test.";
        // Regular expression to match repeating words
        String regex = "\\b(\\w+)\\s+\\1\\b";
        // Compile the regex pattern
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        // Match the pattern against the text
        java.util.regex.Matcher matcher = pattern.matcher(input);
        System.out.println("Repeating Words:");
        // Iterate through all matches
        while (matcher.find()) {
            // Print each repeating word found
            System.out.println(matcher.group());
        }
    }
}
