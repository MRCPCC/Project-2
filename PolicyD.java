import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PolicyD {
    public static void main(String[] args) {
 
        ArrayList<Policy> policies = readPolicyInformationFromFile("CSC251Project\\PolicyInformation.txt");


        for (Policy policy : policies) {
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder's First Name: " + policy.getPolicyholderFirstName());
            System.out.println("Policyholder's Last Name: " + policy.getPolicyholderLastName());
            System.out.println("Policyholder's Age: " + policy.getPolicyholderAge());
            System.out.println("Policyholder's Smoking Status: " + policy.getSmokingStatus());
            System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
            System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
            System.out.printf("BMI: %.2f\n" , policy.calculateBMI());
            System.out.println("Policy Price: $" + policy.calculatePolicyPrice());
            System.out.println();
        }


        int smokers = 0;
        int nonSmokers = 0;
        for (Policy policy : policies) {
            if (policy.getSmokingStatus().equalsIgnoreCase("smoker")) {
                smokers++;
            } else {
                nonSmokers++;
            }
        }


        System.out.println("Number of smokers: " + smokers);
        System.out.println("Number of non-smokers: " + nonSmokers);
    }

        private static ArrayList<Policy> readPolicyInformationFromFile(String filename) {
         ArrayList<Policy> policies = new ArrayList<>();

        try {
          Scanner scanner = new Scanner(new File(filename));
          while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                int policyNumber = Integer.parseInt(line);
                String providerName = scanner.nextLine().trim();
                String policyholderFirstName = scanner.nextLine().trim();
                String policyholderLastName = scanner.nextLine().trim();
                int policyholderAge = Integer.parseInt(scanner.nextLine().trim());
                String smokingStatus = scanner.nextLine().trim();
                double height = Double.parseDouble(scanner.nextLine().trim());
                double weight = Double.parseDouble(scanner.nextLine().trim());

                Policy policy = new Policy(policyNumber, providerName, policyholderFirstName, policyholderLastName,
                        policyholderAge, smokingStatus, height, weight);
                policies.add(policy);
            }
        }
        scanner.close();
    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Error parsing integer or double: " + e.getMessage());
    }

    return policies;
}
}