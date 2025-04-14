package junit_tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {

    @Test
    void testValidDateFormat() {
        assertEquals("15-08-2023", DateFormatter.formatDate("2023-08-15"), 
            "Valid date should be correctly formatted");
        assertEquals("01-01-2000", DateFormatter.formatDate("2000-01-01"), 
            "Valid date should be correctly formatted");
    }

    @Test
    void testInvalidDateFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> DateFormatter.formatDate("15-08-2023"), 
            "Invalid date format should throw an exception");
        assertEquals("Invalid date format. Expected format: yyyy-MM-dd", exception.getMessage());
    }

    @Test
    void testInvalidDateWithExtraCharacters() {
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> DateFormatter.formatDate("2023/08/15"), 
            "Invalid date format should throw an exception");
        assertEquals("Invalid date format. Expected format: yyyy-MM-dd", exception.getMessage());
    }

    @Test
    void testEmptyDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> DateFormatter.formatDate(""), 
            "Empty date should throw an exception");
        assertEquals("Invalid date format. Expected format: yyyy-MM-dd", exception.getMessage());
    }

    @Test
    void testNullDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, 
            () -> DateFormatter.formatDate(null), 
            "Null date should throw an exception");
        assertEquals("Invalid date format. Expected format: yyyy-MM-dd", exception.getMessage());
    }
}
