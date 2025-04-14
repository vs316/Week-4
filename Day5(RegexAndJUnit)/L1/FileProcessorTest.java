package junit_tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {

    private final String testFilename = "sample.txt";
    private final String testContent = "Test content for the file.";

    @BeforeEach
    void setUp() {
        // Ensure the file is deleted before each test
        File file = new File("C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\" + testFilename);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testWriteAndReadContent() {
        // Write content to the file
        FileProcessor.writeToFile(testFilename, testContent);

        // Read content from the file
        String content = FileProcessor.readFromFile(testFilename);

        // Assert that the content matches
        assertNotNull(content, "Content should not be null.");
        assertEquals(testContent, content.trim(), "Content should match the written content.");
    }

    @Test
    void testFileExistsAfterWriting() {
        // Write content to the file
        FileProcessor.writeToFile(testFilename, testContent);

        // Check if the file exists
        File file = new File("C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\" + testFilename);
        assertTrue(file.exists(), "File should exist after writing.");
    }

    @Test
    void testIOExceptionHandling() {
        // Attempt to read from a non-existent file
        String nonExistentFilename = "nonexistent.txt";
        String content = FileProcessor.readFromFile(nonExistentFilename);

        // Assert that the content is null
        assertNull(content, "Content should be null for a non-existent file.");
    }

    @AfterEach
    void tearDown() {
        // Clean up the file after each test
        File file = new File("C:\\Users\\vacha\\IdeaProjects\\CapgeminiTraining\\src\\" + testFilename);
        if (file.exists()) {
            file.delete();
        }
    }
}