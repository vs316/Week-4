package javastreams;

import java.io.*;

public class IPCPipedStreams {
    public static void main(String[] args) {
        try (PipedInputStream pipedInputStream = new PipedInputStream();
                PipedOutputStream pipedOutputStream = new PipedOutputStream()) {

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}