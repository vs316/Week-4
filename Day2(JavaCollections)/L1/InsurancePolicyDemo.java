package JavaCollections.MapInterface;

import java.time.LocalDate;

public class InsurancePolicyDemo {
    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        // Adding sample policies
        system.addPolicy(new InsurancePolicy("POL001", "John Doe",
                LocalDate.now().plusMonths(1), 50000.0, "Health"));
        system.addPolicy(new InsurancePolicy("POL002", "Jane Smith",
                LocalDate.now().plusDays(15), 75000.0, "Life"));
        system.addPolicy(new InsurancePolicy("POL003", "John Doe",
                LocalDate.now().minusDays(5), 30000.0, "Vehicle"));
        system.addPolicy(new InsurancePolicy("POL004", "Alice Brown",
                LocalDate.now().plusMonths(2), 100000.0, "Home"));

        // Demonstrate various operations
        System.out.println("Total policies: " + system.getTotalPolicyCount());

        System.out.println("\nPolicies expiring in next 30 days:");
        system.getPoliciesExpiringInNext30Days()
                .forEach(System.out::println);

        System.out.println("\nPolicies for John Doe:");
        system.getPoliciesForHolder("John Doe")
                .forEach(System.out::println);

        System.out.println("\nRemoving expired policies...");
        system.removeExpiredPolicies();
        System.out.println("Total policies after removal: " + system.getTotalPolicyCount());

        System.out.println("\nAll policies by insertion order:");
        system.getAllPoliciesByInsertionOrder()
                .forEach(System.out::println);

        System.out.println("\nAll policies by expiry date:");
        system.getAllPoliciesByExpiryDate()
                .forEach(System.out::println);

        System.out.println("\nLooking up policy POL002:");
        InsurancePolicy policy = system.getPolicyByNumber("POL002");
        System.out.println(policy);
    }
}