package java_functional_interfaces;

import java.util.function.BiFunction;

public class BiFunctionInterface {
    public static void main(String[] args) {
        String s1="Hello";
        String s2="World";
        BiFunction<String, String, String> biFunction = (str1, str2) -> str1 + " " + str2;
        System.out.println("Concatenated String: " + biFunction.apply(s1, s2));
    }
}
