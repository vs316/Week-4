package java_regex;

import java.util.Scanner;

public class UsernameValidation {
    public boolean isValid(String username){
        String regex= "^[a-zA-Z][a-zA-Z0-9_]{5,15}$";
        return username.matches(regex);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String username = sc.nextLine();
        System.out.println("Whether username is valid or not: "+new UsernameValidation().isValid(username));
    }
}
