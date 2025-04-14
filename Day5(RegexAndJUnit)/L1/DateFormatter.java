package junit_tests;

import java.util.regex.Pattern;

public class DateFormatter {
    private static final String DATE_PATTERN = "^\\d{4}-\\d{2}-\\d{2}$";

    public static String formatDate(String inputDate) {
        if (!Pattern.matches(DATE_PATTERN, inputDate)) {
            throw new IllegalArgumentException("Invalid date format. Expected format: yyyy-MM-dd");
        }
        String[] dateParts = inputDate.split("-");
        if (dateParts.length != 3) {
            throw new IllegalArgumentException("Invalid date format");
        }
        return dateParts[2] + "-" + dateParts[1] + "-" + dateParts[0];
    }
}
