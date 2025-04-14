package java_regex;

public class ValidateLicensePlateNumber {
    public static void main(String[] args) {
        String licensePlate = "AB1234";
        String regex = "^[A-Z]{2}\\d{4}$";

        if (licensePlate.matches(regex)) {
            System.out.println("Valid license plate number");
        } else {
            System.out.println("Invalid license plate number");
        }
    }
}
