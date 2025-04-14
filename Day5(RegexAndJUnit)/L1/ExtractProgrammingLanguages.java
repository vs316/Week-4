package java_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractProgrammingLanguages {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // Regular expression to match programming language names
        String regex = "\\b(JavaScript|Java|Python|Go)\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted Programming Languages:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

