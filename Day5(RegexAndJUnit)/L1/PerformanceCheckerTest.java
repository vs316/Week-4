package junit_tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class PerformanceCheckerTest {
    //Use @Timeout(2) in JUnit to fail the test if the method takes more than 2 seconds.
    @Test
    @Timeout(2)
    void testLongRunningTask() {
        // Call the long-running task
        int result = PerformanceChecker.longRunningTask();

        // Check the result
        assertEquals(42, result);
    }

}