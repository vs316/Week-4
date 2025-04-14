package junit_tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    @Test
    void testValidUserRegistration() {
        UserRegistration userRegistration = new UserRegistration();
        assertDoesNotThrow(() -> userRegistration.registerUser("validUser", "user@example.com", "Password1"));
        assertEquals("validUser", userRegistration.getUsername());
        assertEquals("user@example.com", userRegistration.getEmail());
        assertEquals("Password1", userRegistration.getPassword());
    }

    @Test
    void testInvalidUsername() {
        UserRegistration userRegistration = new UserRegistration();
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("u", "user@example.com", "Password1"));
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("user_with_invalid_characters!", "user@example.com", "Password1"));
    }

    @Test
    void testInvalidEmail() {
        UserRegistration userRegistration = new UserRegistration();
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("validUser", "invalid-email", "Password1"));
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("validUser", "user@.com", "Password1"));
    }

    @Test
    void testInvalidPassword() {
        UserRegistration userRegistration = new UserRegistration();
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("validUser", "user@example.com", "short"));
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("validUser", "user@example.com", "alllowercase1"));
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("validUser", "user@example.com", "NOUPPERCASE1"));
    }
}
