package java_functional_interfaces;

import java.util.*;
import java.util.stream.Collectors;

public class InsuranceApplication {
    private String policyNumber;
    private String holderName;
    private double premiumAmount;

    public InsuranceApplication(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    @Override
    public String toString() {
        return String.format("Policy Number: %s, Holder Name: %s, Premium Amount: %.2f",
                policyNumber, holderName, premiumAmount);
    }

    public static List<InsuranceApplication> filterByPremiumAmount(List<InsuranceApplication> list) {
        return list.stream()
                .filter(application -> application.getPremiumAmount() > 1200)
                .toList();
    }

    public static List<InsuranceApplication> sortPoliciesByHolderName(List<InsuranceApplication> list) {
        return list.stream()
                .sorted((a, b) -> a.getHolderName().compareTo(b.getHolderName()))
                .toList();
    }

    public static double computeTotalPremium(List<InsuranceApplication> list) {
        return list.stream().mapToDouble(InsuranceApplication::getPremiumAmount)
                .sum();
    }

    public static double computeAveragePremium(List<InsuranceApplication> list) {
        return list.stream().mapToDouble(InsuranceApplication::getPremiumAmount)
                .average()
                .orElse(0);
    }

    public static void sortPoliciesByPremiumAmountAndPrint(List<InsuranceApplication> list) {
        System.out.println(list.stream()
                .sorted((a, b) -> Double.compare(a.getPremiumAmount(), b.getPremiumAmount()))
                .toList());
    }

    public static List<InsuranceApplication> filterByPremiumRange(List<InsuranceApplication> list) {
        return list.stream()
                .filter(application -> application.getPremiumAmount() >= 1000 && application.getPremiumAmount() <= 2000)
                .toList();
    }

    public static Optional<InsuranceApplication> findPolicyWithHighestPremium(List<InsuranceApplication> list) {
        return list.stream()
                .max(Comparator.comparingDouble(InsuranceApplication::getPremiumAmount));
    }

    public static Map<Character, List<InsuranceApplication>> groupPoliciesByHolderNameInitial(List<InsuranceApplication> list) {
        return list.stream()
                .collect(Collectors.groupingBy(policy -> policy.getHolderName().charAt(0)));
    }

    public static boolean checkIfAnyPolicyExceedsCertainPremium(List<InsuranceApplication> list, double threshold) {
        return list.stream()
                .anyMatch(policy -> policy.getPremiumAmount() > threshold);
    }

    public static Map<String, Long> countPoliciesForEachPremiumRange(List<InsuranceApplication> list) {
        return list.stream()
                .collect(Collectors.groupingBy(policy -> {
                    if (policy.getPremiumAmount() <= 1000) return "$0-$1,000";
                    else if (policy.getPremiumAmount() <= 2000) return "$1,001-$2,000";
                    else return ">$2,000";
                }, Collectors.counting()));
    }

    public static List<String> extractUniqueHolderNames(List<InsuranceApplication> list) {
        return list.stream()
                .map(InsuranceApplication::getHolderName)
                .distinct()
                .toList();
    }

    public static List<InsuranceApplication> findPoliciesByHolderNameSubstring(List<InsuranceApplication> list, String substring) {
        return list.stream()
                .filter(policy -> policy.getHolderName().contains(substring))
                .toList();
    }

    public static Map<String, Double> createMapOfPolicyNumbersToPremiumAmounts(List<InsuranceApplication> list) {
        return list.stream()
                .collect(Collectors.toMap(InsuranceApplication::getPolicyNumber, InsuranceApplication::getPremiumAmount));
    }

    public static void printPolicyDetails(List<InsuranceApplication> list) {
        list.forEach(policy -> System.out.printf("Policy Number: %s, Holder Name: %s, Premium Amount: %.2f%n",
                policy.getPolicyNumber(), policy.getHolderName(), policy.getPremiumAmount()));
    }

    public static void main(String[] args) {
        List<InsuranceApplication> policies = List.of(
                new InsuranceApplication("P001", "Alice", 1500),
                new InsuranceApplication("P002", "Bob", 800),
                new InsuranceApplication("P003", "Charlie", 2200),
                new InsuranceApplication("P004", "David", 1200),
                new InsuranceApplication("P005", "Eve", 1800)
        );

        System.out.println("Filtered by Premium Range:");
        System.out.println(filterByPremiumRange(policies));

        System.out.println("\nPolicy with Highest Premium:");
        System.out.println(findPolicyWithHighestPremium(policies).orElse(null));

        System.out.println("\nGrouped by Holder Name Initial:");
        System.out.println(groupPoliciesByHolderNameInitial(policies));

        System.out.println("\nCheck if Any Policy Exceeds $2000:");
        System.out.println(checkIfAnyPolicyExceedsCertainPremium(policies, 2000));

        System.out.println("\nCount Policies for Each Premium Range:");
        System.out.println(countPoliciesForEachPremiumRange(policies));

        System.out.println("\nUnique Holder Names:");
        System.out.println(extractUniqueHolderNames(policies));

        System.out.println("\nPolicies with Holder Name Containing 'a':");
        System.out.println(findPoliciesByHolderNameSubstring(policies, "a"));

        System.out.println("\nMap of Policy Numbers to Premium Amounts:");
        System.out.println(createMapOfPolicyNumbersToPremiumAmounts(policies));

        System.out.println("\nPolicy Details:");
        printPolicyDetails(policies);
    }
}
