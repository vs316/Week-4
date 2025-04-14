package java_regex;

public class ValidateHexColorCode {
    public static void main(String[] args) {
        String hexColorCode = "#AABBCC";
        String regex = "^#([0-9A-Fa-f]{6})$";

        if (hexColorCode.matches(regex)) {
            System.out.println("Valid hex color code");
        } else {
            System.out.println("Invalid hex color code");
        }
    }
}
