public class Policy {
    private int policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String smokingStatus;
    private double height;
    private double weight;
    
    public Policy() {
        this.policyNumber = 0;
        this.providerName = "";
        this.policyholderFirstName = "";
        this.policyholderLastName = "";
        this.policyholderAge = 0;
        this.smokingStatus = "";
        this.height = 0;
        this.weight = 0;
    }

    /*
     * @param policyNumber Policy Number
     * @param providerName Provider Name
     * @param policyholderFirstName Policyholder's First Name
     * @param policyholderLastName Policyholder's Last Name
     * @param policyholderAge Policyholder's Age
     * @param smokingStatus Policyholder's Smoking Status ("smoker" or "non-smoker")
     * @param height Policyholder's Height (in inches)
     * @param weight Policyholder's Weight (in pounds)
     */
    public Policy(int policyNumber, String providerName, String policyholderFirstName,
                  String policyholderLastName, int policyholderAge, String smokingStatus,
                  double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = policyholderFirstName;
        this.policyholderLastName = policyholderLastName;
        this.policyholderAge = policyholderAge;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    /*
     * Get the policy number
     * @return Policy number
     */
    public int getPolicyNumber() {
        return policyNumber;
    }
    
    /*
     * Set the policy number
     * @param policyNumber Policy number to set
     */
    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }
    
    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getPolicyholderFirstName() {
        return policyholderFirstName;
    }

    public void setPolicyholderFirstName(String policyholderFirstName) {
        this.policyholderFirstName = policyholderFirstName;
    }

    public String getPolicyholderLastName() {
        return policyholderLastName;
    }

    public void setPolicyholderLastName(String policyholderLastName) {
        this.policyholderLastName = policyholderLastName;
    }

    public int getPolicyholderAge() {
        return policyholderAge;
    }

    public void setPolicyholderAge(int policyholderAge) {
        this.policyholderAge = policyholderAge;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    /*
     * Calculate the BMI
     * @return BMI value
     */
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

    /*
     * Calculate the price of the insurance policy
     * @return Price of the insurance policy
     */
    public double calculatePolicyPrice() {
        double baseFee = 600;
        double additionalFee = 0;

        if (policyholderAge > 50) {
            additionalFee += 75;
        }

        if (smokingStatus.equalsIgnoreCase("smoker")) {
            additionalFee += 100;
        }

        double bmi = calculateBMI();
        if (bmi > 35) {
            additionalFee += (bmi - 35) * 20;
        }

        return baseFee + additionalFee;
    }
}