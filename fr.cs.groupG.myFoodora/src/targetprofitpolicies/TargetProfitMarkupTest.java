package targetprofitpolicies;

public class TargetProfitMarkupTest {
    public static void main(String[] args) {
        double targetProfit   = 1000.0;
        double serviceFee     = 2.0;
        double deliveryCost   = 1.5;
        int    numberOfOrders = 300;

        TargetProfitMarkup policy = new TargetProfitMarkup(
                targetProfit, serviceFee, deliveryCost, numberOfOrders);

        double markup = policy.computeParameters();

        System.out.println(policy);
        System.out.printf("Computed markupPercentage: %.2f €%n", markup);
    }
}

