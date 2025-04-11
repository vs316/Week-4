package JavaCollections.MapInterface;

import java.time.LocalDate;
import java.util.Objects;

public class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;
    private double coverageAmount;
    private String policyType;

    public InsurancePolicy(String policyNumber, String policyHolderName, LocalDate expiryDate,
            double coverageAmount, String policyType) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageAmount = coverageAmount;
        this.policyType = policyType;
    }

    // Getters and setters
    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }

    public String getPolicyType() {
        return policyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        InsurancePolicy that = (InsurancePolicy) o;
        return Objects.equals(policyNumber, that.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "InsurancePolicy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyHolderName='" + policyHolderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageAmount=" + coverageAmount +
                ", policyType='" + policyType + '\'' +
                '}';
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }
}