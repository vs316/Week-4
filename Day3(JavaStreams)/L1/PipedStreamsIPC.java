package javastreams;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamsIPC {
    public static void main(String[] args) {
        try (PipedInputStream pipedInputStream = new PipedInputStream();
                PipedOutputStream pipedOutputStream = new PipedOutputStream()) {

            // Connect the input and output streams
            pipedInputStream.connect(pipedOutputStream);

            // Writer thread - writes a message to the pipe
            Thread writerThread = new Thread(() -> {
                try {
                    String message = "Hello from writer thread!";
                    System.out.println("Writer thread: Writing message...");
                    pipedOutputStream.write(message.getBytes());
                    pipedOutputStream.flush();
                } catch (IOException e) {
                    System.err.println("Error writing to pipe: " + e.getMessage());
                }
            }, "WriterThread");

            // Reader thread - reads the message from the pipe
            Thread readerThread = new Thread(() -> {
                try {
                    byte[] buffer = new byte[100];
                    System.out.println("Reader thread: Waiting for data...");
                    int bytesRead = pipedInputStream.read(buffer);
                    String receivedMessage = new String(buffer, 0, bytesRead);
                    System.out.println("Reader thread: Received message: " + receivedMessage);
                } catch (IOException e) {
                    System.err.println("Error reading from pipe: " + e.getMessage());
                }
            }, "ReaderThread");

            // Start both threads
            writerThread.start();
            readerThread.start();

            // Wait for both threads to complete
            try {
                writerThread.join();
                readerThread.join();
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }

        } catch (IOException e) {
            System.err.println("Error with pipe streams: " + e.getMessage());
        }
    }
}