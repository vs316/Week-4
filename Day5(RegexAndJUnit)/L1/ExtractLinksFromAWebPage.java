package java_regex;

public class ExtractLinksFromAWebPage {
    public static void main(String[] args) {
        String text="Visit https://www.google.com and http://example.org for more info.";
        // Regular expression to match URLs
        String regex = "(https?://[\\w.-]+(\\.[\\w-]{2,})(/\\S*)?)";
        // Compile the regex pattern
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        // Match the pattern against the text
        java.util.regex.Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted Links:");
        // Iterate through all matches
        while (matcher.find()) {
            // Print each link found
            System.out.println(matcher.group());
        }
    }
}
