package junit_tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void testValidPassword() {
        assertTrue(PasswordValidator.isValid("Password1"), "Password with uppercase, digit, and 8+ characters should be valid");
        assertTrue(PasswordValidator.isValid("StrongPass123"), "Password with multiple valid conditions should be valid");
    }

    @Test
    void testInvalidPasswordTooShort() {
        assertFalse(PasswordValidator.isValid("Pass1"), "Password shorter than 8 characters should be invalid");
    }

    @Test
    void testInvalidPasswordNoUpperCase() {
        assertFalse(PasswordValidator.isValid("password1"), "Password without an uppercase letter should be invalid");
    }

    @Test
    void testInvalidPasswordNoDigit() {
        assertFalse(PasswordValidator.isValid("Password"), "Password without a digit should be invalid");
    }

    @Test
    void testInvalidPasswordWithSpaces() {
        assertFalse(PasswordValidator.isValid("Password 1"), "Password with spaces should be invalid");
    }

    @Test
    void testInvalidPasswordNull() {
        assertFalse(PasswordValidator.isValid(null), "Null password should be invalid");
    }
}
