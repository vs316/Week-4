package junit_tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivByZeroTest {

    @Test
    void divide() {
        assertEquals(0, DivByZero.divide(1, 0));
        assertEquals(2, DivByZero.divide(4, 2));
        assertEquals(-1, DivByZero.divide(-2, 2));
        assertEquals(0, DivByZero.divide(0, 1));
    }
}