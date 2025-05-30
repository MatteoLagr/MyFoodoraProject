package targetprofitpolicies;

/**
 * Politique : on ajuste le serviceFee pour atteindre un profit cible.
 *
 * Formule :
 *   profit = N × (serviceFee + markupPercentage + deliveryCost)
package targetprofitpolicies;

/**
 * Politique : on ajuste le serviceFee pour atteindre un profit cible.
 * 
 * Formule utilisée :
 *   profit = nbrOrders × (serviceFee + markupPercentage - deliveryCost)
 *
 * D’où :
 *   serviceFee = (targetProfit / nbrOrders) - markupPercentage + deliveryCost
 */
public class TargetProfitServiceFee implements TargetProfitPolicies {

    private final double targetProfit;
    private final double deliveryCost;
    private final double markupPercentage;
    private final int numberOfOrders;

    public TargetProfitServiceFee(double targetProfit,
                                  double deliveryCost,
                                  double markupPercentage,
                                  int numberOfOrders) {
        if (numberOfOrders <= 0) {
            throw new IllegalArgumentException("numberOfOrders must be > 0");
        }
        this.targetProfit = targetProfit;
        this.deliveryCost = deliveryCost;
        this.markupPercentage = markupPercentage;
        this.numberOfOrders = numberOfOrders;
    }

    public double getTargetProfit()     { return targetProfit; }
    public double getDeliveryCost()     { return deliveryCost; }
    public double getMarkupPercentage() { return markupPercentage; }
    public int getNumberOfOrders()      { return numberOfOrders; }

    @Override
    public String getPolicyName() {
        return "Target Profit based on Service Fee";
    }

    @Override
    public double computeParameters() {
        return (targetProfit / numberOfOrders) - markupPercentage + deliveryCost;
    }

    @Override
    public String toString() {
        return "TargetProfitServiceFee{" +
                "targetProfit=" + targetProfit +
                ", deliveryCost=" + deliveryCost +
                ", markupPercentage=" + markupPercentage +
                ", numberOfOrders=" + numberOfOrders +
                ", computedServiceFee=" + String.format("%.2f", computeParameters()) +
                '}';
    }
}
