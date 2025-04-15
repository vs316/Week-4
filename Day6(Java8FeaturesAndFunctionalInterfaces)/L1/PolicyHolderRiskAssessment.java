package java8Features;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java8Features.RiskAssessment.assessRisk;
import static java8Features.RiskAssessment.categorizeRisk;

class PolicyHolder {
    private String holderId;
    private String name;
    private int age;
    private String policyType;
    private double premiumAmount;

    public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }

    public String getHolderId() {
        return holderId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPolicyType() {
        return policyType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }
}

class RiskAssessment {
    private String holderId;
    private String name;
    private double riskScore;

    public double getRiskScore() {
        return riskScore;
    }

    public RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    @Override
    public String toString() {
        return String.format("RiskAssessment { holderId: '%s', name: '%s', riskScore: %.2f }", holderId, name, riskScore);
    }


    public static List<RiskAssessment> assessRisk(List<PolicyHolder> holders) {
        return holders.stream()
                .filter(holder -> holder.getPolicyType().equals("Life") && holder.getAge() > 60)
                .map(holder -> new RiskAssessment(
                        holder.getHolderId(),
                        holder.getName(),
                        holder.getPremiumAmount() / holder.getAge()))
                .sorted(Comparator.comparingDouble(RiskAssessment::getRiskScore).reversed())
                .toList();
    }

    public static Map<String, List<RiskAssessment>> categorizeRisk(List<RiskAssessment> assessments) {
        return assessments.stream()
                .collect(Collectors.groupingBy(assessment -> assessment.getRiskScore() > 0.5 ? "High Risk" : "Low Risk"));
    }
}
public class PolicyHolderRiskAssessment {
    public static void main(String[] args) {
        List<PolicyHolder> holders = List.of(
                new PolicyHolder("H1", "Alice", 65, "Life", 12000),
                new PolicyHolder("H2", "Bob", 58, "Health", 9000),
                new PolicyHolder("H3", "Charlie", 62, "Life", 10000),
                new PolicyHolder("H4", "David", 70, "Life", 15000),
                new PolicyHolder("H5", "Eve", 45, "Car", 8000)
        );

        // Step 1: Filter and calculate risk assessments
        List<RiskAssessment> riskAssessments = assessRisk(holders);
        System.out.println("Risk Assessments (Sorted by Risk Score):");
        riskAssessments.forEach(System.out::println);

        // Step 2: Categorize by risk
        Map<String, List<RiskAssessment>> categorizedRisk = categorizeRisk(riskAssessments);
        System.out.println("\nRisk Categories:");
        categorizedRisk.forEach((category, assessments) -> {
            System.out.println("Category: " + category);
            assessments.forEach(System.out::println);
        });
    }
}
