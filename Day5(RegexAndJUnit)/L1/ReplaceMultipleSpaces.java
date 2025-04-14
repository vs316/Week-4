package java_regex;

public class ReplaceMultipleSpaces {
    public static void main(String[] args) {
        String input = "This   is   an  example    with  multiple spaces.";
        // Regular expression to match multiple spaces
        String output = input.replaceAll("\\s+", " ");
        System.out.println("Modified String:");
        System.out.println(output);
    }
}
