package java_regex;
import java.util.regex.Pattern;

public class ValidateIPv4Address {
    public static void main(String[] args) {
        String ip = "192.168.0.1";
        // Simplified regex
        String regex = "^((25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})$";

        boolean isValid = Pattern.matches(regex, ip);
        System.out.println("Is the IP address valid? " + isValid);
    }
}