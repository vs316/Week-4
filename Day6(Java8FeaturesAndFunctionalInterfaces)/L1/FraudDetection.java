package java8Features;

import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    private String transactionId;
    private String policyNumber;
    private double amount;
    private Date transactionDate;
    private boolean isFraudulent;

    public Transaction(String transactionId, String policyNumber, double amount, Date transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public boolean isFraudulent() {
        return isFraudulent;
    }

    // 1. Filter: Select fraudulent transactions with amount > $10,000
    public static List<Transaction> selectFraudulentTransactions(List<Transaction> transactions) {
        return transactions.stream()
                .filter(trans -> trans.isFraudulent() && trans.getAmount() > 10000)
                .toList();
    }

    // 2. Group: Group transactions by policy number
    public static Map<String, List<Transaction>> groupByPolicyNumber(List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getPolicyNumber));
    }

    // 3. Aggregate: Calculate total number of fraudulent transactions and total fraud amount
    public static Map<String, Map<String, Double>> aggregateFraud(Map<String, List<Transaction>> groupedTransactions) {
        return groupedTransactions.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> {
                    List<Transaction> transactions = entry.getValue();
                    double totalAmount = transactions.stream().mapToDouble(Transaction::getAmount).sum();
                    double fraudCount = transactions.size();
                    Map<String, Double> aggregates = new HashMap<>();
                    aggregates.put("TotalFraudAmount", totalAmount);
                    aggregates.put("FraudCount", fraudCount);
                    return aggregates;
                }));
    }

    // 4. Alert: Generate alerts for suspicious policies
    public static void generateAlerts(Map<String, Map<String, Double>> aggregatedFraud) {
        aggregatedFraud.entrySet().stream()
                .filter(entry -> entry.getValue().get("FraudCount") > 5 || entry.getValue().get("TotalFraudAmount") > 50000)
                .forEach(entry -> System.out.println("ALERT: Policy " + entry.getKey() + " has suspicious activity!"));
    }

    @Override
    public String toString() {
        return String.format(
                "Transaction { transactionId: '%s', policyNumber: '%s', amount: %.2f, transactionDate: '%tF', isFraudulent: %b }",
                transactionId, policyNumber, amount, transactionDate, isFraudulent
        );
    }

}

public class FraudDetection {
    public static void main(String[] args) {
        // Sample Transactions
        List<Transaction> transactions = List.of(
                new Transaction("T1", "P1", 15000, new Date(), true),
                new Transaction("T2", "P2", 5000, new Date(), false),
                new Transaction("T3", "P1", 25000, new Date(), true),
                new Transaction("T4", "P3", 8000, new Date(), true),
                new Transaction("T5", "P2", 12000, new Date(), true),
                new Transaction("T6", "P1", 30000, new Date(), true),
                new Transaction("T7", "P3", 7000, new Date(), false)
        );

        // Step 1: Filter fraudulent transactions
        List<Transaction> fraudulentTransactions = Transaction.selectFraudulentTransactions(transactions);
        System.out.println("Filtered Fraudulent Transactions:");
        fraudulentTransactions.forEach(trans ->
                System.out.println("TransactionID: " + trans.getTransactionId() + ", Amount: " + trans.getAmount())
        );

        // Step 2: Group by policy number
        Map<String, List<Transaction>> groupedTransactions = Transaction.groupByPolicyNumber(fraudulentTransactions);
        System.out.println("\nGrouped Transactions:");
        groupedTransactions.forEach((policy, txnList) -> {
            System.out.println("Policy Number: " + policy);
            txnList.forEach(System.out::println);
        });

        // Step 3: Aggregate fraud data
        Map<String, Map<String, Double>> aggregatedFraud = Transaction.aggregateFraud(groupedTransactions);
        System.out.println("\nAggregated Fraud Data:");
        aggregatedFraud.forEach((policy, aggregates) -> {
            System.out.println("Policy Number: " + policy + ", Total Fraud Amount: " +
                    aggregates.get("TotalFraudAmount") + ", Fraud Count: " + aggregates.get("FraudCount"));
        });

        // Step 4: Generate alerts
        System.out.println("\nAlerts:");
        Transaction.generateAlerts(aggregatedFraud);
    }
}