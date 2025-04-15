package java8Features;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Claim {
    private String claimId;
    private String policyNumber;
    private double claimAmount;
    private LocalDate claimDate;
    private String status;

    public Claim(String claimId, String policyNumber, double claimAmount, LocalDate claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public String getStatus() {
        return status;
    }


    public static List<Claim> filterApprovedClaims(List<Claim> claims) {
        return claims.stream()
                .filter(claim -> claim.getStatus().equals("Approved") && claim.getClaimAmount() > 5000)
                .toList();
    }

    public static Map<String, List<Claim>> groupByPolicyNumber(List<Claim> claims) {
        return claims.stream()
                .collect(Collectors.groupingBy(Claim::getPolicyNumber));
    }

    public static Map<String, Map<String, Double>> aggregateClaims(Map<String, List<Claim>> groupedClaims) {
        return groupedClaims.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> {
                    List<Claim> claimList = entry.getValue();
                    double total = claimList.stream().mapToDouble(Claim::getClaimAmount).sum();
                    double average = total / claimList.size();
                    Map<String, Double> aggregates = new HashMap<>();
                    aggregates.put("Total", total);
                    aggregates.put("Average", average);
                    return aggregates;
                }));
    }

    public static List<String> topNPolicies(Map<String, Map<String, Double>> aggregatedClaims, int n) {
        return aggregatedClaims.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue().get("Total"), e1.getValue().get("Total")))
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }
    @Override
    public String toString() {
        return String.format("Claim { Claim ID: '%s', Policy Number: '%s', Claim Amount: '%.2f', Claim Date: '%tF', Status: '%s' }", claimId, policyNumber, claimAmount, claimDate, status );
    }

    public static void main(String[] args) {
        List<Claim> claims = List.of(
                new Claim("C1", "P1", 6000, LocalDate.of(2023, 1, 5), "Approved"),
                new Claim("C2", "P2", 8000, LocalDate.of(2023, 2, 10), "Denied"),
                new Claim("C3", "P1", 12000, LocalDate.of(2023, 3, 15), "Approved"),
                new Claim("C4", "P3", 3000, LocalDate.of(2023, 4, 20), "Approved"),
                new Claim("C5", "P2", 7000, LocalDate.of(2023, 5, 25), "Approved")
        );

        // Step 1: Filter claims
        List<Claim> filteredClaims = filterApprovedClaims(claims);
        System.out.println("Filtered Claims:");
        filteredClaims.forEach(System.out::println);

        // Step 2: Group by policy number
        Map<String, List<Claim>> groupedClaims = groupByPolicyNumber(filteredClaims);
        System.out.println("\nGrouped Claims:");
        groupedClaims.forEach((policy, claimsList) -> {
            System.out.println("Policy Number: " + policy);
            claimsList.forEach(System.out::println);
        });

        // Step 3: Aggregate claims
        Map<String, Map<String, Double>> aggregatedClaims = aggregateClaims(groupedClaims);
        System.out.println("\nAggregated Claims:");
        aggregatedClaims.forEach((policy, aggregates) -> {
            System.out.println("Policy Number: " + policy + ", Total: " + aggregates.get("Total") + ", Average: " + aggregates.get("Average"));
        });

        // Step 4: Top N policies
        List<String> topPolicies = topNPolicies(aggregatedClaims, 3);
        System.out.println("\nTop 3 Policies with Highest Total Claim Amounts:");
        topPolicies.forEach(System.out::println);
    }
}