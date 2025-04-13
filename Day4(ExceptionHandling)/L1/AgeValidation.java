package java_exceptions;

import java.util.Scanner;

class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message);
    }
}
public class AgeValidation {
    public static void validateAge(int age) throws InvalidAgeException {
        if(age<18){
            throw new InvalidAgeException("Age must be 18 or above.");
        }else{
            System.out.println("Access granted!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        try{
            System.out.println("Enter your age: ");
            int age=scanner.nextInt();
            validateAge(age);
        }catch (InvalidAgeException e){
            System.out.println("Error: "+e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid age.");
        }finally {
            scanner.close();
        }
    }
}
