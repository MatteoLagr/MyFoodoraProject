package targetprofitpolicies;

public class TargetProfitDeliveryCostTest {
    public static void main(String[] args) {
        double targetProfit     = 2000.0;
        double serviceFee       = 2.5;
        double markupPercentage = 1.0;
        int    numberOfOrders   = 500;

        TargetProfitDeliveryCost policy = new TargetProfitDeliveryCost(
                targetProfit, serviceFee, markupPercentage, numberOfOrders);

        double deliveryCost = policy.computeParameters();

        System.out.println(policy);
        System.out.printf("Computed deliveryCost: %.2f €%n", deliveryCost);
    }
}

