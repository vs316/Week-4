package javastreams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationSaveAndRetrieveFile {
    private static final String FILE_PATH = "src\\JavaStreams\\employees.ser";

    public static void main(String[] args) {
        // Create sample employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "IT", 75000.0));
        employees.add(new Employee(2, "Jane Smith", "HR", 65000.0));
        employees.add(new Employee(3, "Bob Johnson", "Finance", 80000.0));

        // Serialize employees
        saveEmployees(employees);

        // Deserialize and display employees
        List<Employee> retrievedEmployees = retrieveEmployees();
        if (retrievedEmployees != null) {
            System.out.println("\nRetrieved Employees:");
            for (Employee emp : retrievedEmployees) {
                System.out.println(emp);
            }
        }
    }

    private static void saveEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(FILE_PATH))) {

            oos.writeObject(employees);
            System.out.println("Employees have been serialized and saved to file");

        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Employee> retrieveEmployees() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(FILE_PATH))) {

            List<Employee> employees = (List<Employee>) ois.readObject();
            return employees;

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found during deserialization: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading employees: " + e.getMessage());
        }
        return null;
    }
}