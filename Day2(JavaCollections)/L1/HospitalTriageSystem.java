package JavaCollections.Queues;

import java.util.PriorityQueue;

class Patient implements Comparable<Patient> {
    private final String name;
    private final int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public int compareTo(Patient other) {
        // Higher severity patients should come first
        return other.severity - this.severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriageSystem {
    public static void main(String[] args) {
        // Create a priority queue that will automatically sort by severity
        PriorityQueue<Patient> patientQueue = new PriorityQueue<>();

        // Add patients with different severity levels
        patientQueue.offer(new Patient("John", 3));
        patientQueue.offer(new Patient("Alice", 5));
        patientQueue.offer(new Patient("Bob", 2));

        System.out.println("Patients will be treated in the following order:");

        // Process patients in order of severity
        while (!patientQueue.isEmpty()) {
            Patient currentPatient = patientQueue.poll();
            System.out.println("Treating patient: " + currentPatient);
        }
    }
}