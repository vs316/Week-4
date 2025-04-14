package java_regex;

public class CensorBadWords {
    public static void main(String[] args) {
        String input="This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "bad", "stupid"};
        String regex = "\\b(" + String.join("|", badWords) + ")\\b";
        String output = input.replaceAll(regex, "****");
        System.out.println("Modified String:");
        System.out.println(output);

    }
}
