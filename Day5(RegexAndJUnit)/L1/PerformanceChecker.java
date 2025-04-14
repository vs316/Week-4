package junit_tests;

public class PerformanceChecker {
    public static int longRunningTask(){
        // Simulate a long-running task
        try {
            Thread.sleep(1500); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 42; // Return some result
    }
}
