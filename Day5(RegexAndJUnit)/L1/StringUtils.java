package junit_tests;

public class StringUtils {
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        String reversed = reverse(str);
        return str.equals(reversed);
    }

    public static int countVowels(String str) {
        if (str == null) {
            return 0;
        }
        int count = 0;
        for (char c : str.toCharArray()) {
            if ("aeiouAEIOU".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }
    public static String toUpperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }
    public static String toLowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    public static String removeWhitespace(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("\\s+", "");
    }
    public static String repeat(String str, int times) {
        if (str == null || times < 0) {
            return null;
        }
        StringBuilder repeated = new StringBuilder();
        for (int i = 0; i < times; i++) {
            repeated.append(str);
        }
        return repeated.toString();
    }
    public static String[] split(String str, String regex) {
        if (str == null || regex == null) {
            return null;
        }
        return str.split(regex);
    }
    public static String join(String[] arr, String delimiter) {
        if (arr == null || delimiter == null) {
            return null;
        }
        StringBuilder joined = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            joined.append(arr[i]);
            if (i < arr.length - 1) {
                joined.append(delimiter);
            }
        }
        return joined.toString();
    }
    public static String trim(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }
    public static String replace(String str, String target, String replacement) {
        if (str == null || target == null || replacement == null) {
            return null;
        }
        return str.replace(target, replacement);
    }
    public static String substring(String str, int beginIndex, int endIndex) {
        if (str == null || beginIndex < 0 || endIndex > str.length() || beginIndex > endIndex) {
            return null;
        }
        return str.substring(beginIndex, endIndex);
    }
    public static String format(String str, Object... args) {
        if (str == null || args == null) {
            return null;
        }
        return String.format(str, args);
    }


}
