package targetprofitpolicies;

public class TargetProfitServiceFeeTest {
    public static void main(String[] args) {
        double targetProfit     = 1500.0;
        double deliveryCost     = 1.5;
        double markupPercentage = 1.0;
        int    numberOfOrders   = 400;

        TargetProfitServiceFee policy = new TargetProfitServiceFee(
                targetProfit, deliveryCost, markupPercentage, numberOfOrders);

        double serviceFee = policy.computeParameters();

        System.out.println(policy);
        System.out.printf("Computed serviceFee: %.2f €%n", serviceFee);
    }
}
