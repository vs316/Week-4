package java_regex;

public class ExtractAllCapitalizedWordsFromASentence {
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        // Regular expression to match capitalized words
        String regex = "\\b[A-Z][a-z]*\\b";

        // Compile the regex pattern
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        // Match the pattern against the text
        java.util.regex.Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted Capital Words:");
        // Iterate through all matches
        while (matcher.find()) {
            // Print each capital word found
            System.out.println(matcher.group());
        }
    }
}
