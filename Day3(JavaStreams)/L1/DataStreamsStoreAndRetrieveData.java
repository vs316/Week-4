package javastreams;

import java.io.*;

public class DataStreamsStoreAndRetrieveData {
    private static final String FILE_PATH = "student_data.bin";

    public static void writeStudentData(int rollNumber, String name, double gpa) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_PATH))) {
            // Write student details
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            System.out.println("Student data written successfully!");
        } catch (IOException e) {
            System.err.println("Error writing data: " + e.getMessage());
        }
    }

    public static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_PATH))) {
            // Read student details in the same order they were written
            int rollNumber = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            // Display the read data
            System.out.println("\nRetrieved Student Details:");
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);
        } catch (IOException e) {
            System.err.println("Error reading data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Write sample student data
        writeStudentData(101, "John Doe", 3.75);

        // Read and display the data
        readStudentData();
    }
}