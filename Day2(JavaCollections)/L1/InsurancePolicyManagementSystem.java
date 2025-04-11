package JavaCollections.SetInterface;

import java.util.List;

public class InsurancePolicyManagementSystem {
    private int policyNumber;
    private String policyHolderName;
    private List<String> converageType;
    private double premiumAmount;

    public InsurancePolicyManagementSystem(int policyNumber, String policyHolderName, List<String> converageType,
            double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.converageType = converageType;
        this.premiumAmount = premiumAmount;
    }

    public static void main(String[] args) {

    }

}