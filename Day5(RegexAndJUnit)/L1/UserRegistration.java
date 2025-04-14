package junit_tests;

import java.util.regex.Pattern;

public class UserRegistration {
    private String username;
    private String email;
    private String password;

    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]{3,20}$"; // 3-20 alphanumeric characters
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"; // Valid email format
    private static final String PASSWORD_PATTERN =  "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{8,}$"; // At least 8 chars, 1 uppercase, 1 digit

    public void registerUser(String username, String email, String password) {
        if (username == null || !Pattern.matches(USERNAME_PATTERN, username)) {
            throw new IllegalArgumentException("Invalid username. Must be 3-20 alphanumeric characters.");
        }
        if (email == null || !Pattern.matches(EMAIL_PATTERN, email)) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        if (password == null || !Pattern.matches(PASSWORD_PATTERN, password)) {
            throw new IllegalArgumentException("Invalid password. Must be at least 8 characters, include 1 uppercase letter and 1 digit.");
        }

        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getters for testing purposes
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
