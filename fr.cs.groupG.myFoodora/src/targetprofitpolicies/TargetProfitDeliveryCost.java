package targetprofitpolicies;

/**
 * Politique : on ajuste le deliveryCost pour atteindre un profit cible.
 * 
 * Ici, deliveryCost est une dépense supportée par l’entreprise.
 *
 * Formule retenue :
 *   profit = nbrOrders × (serviceFee + markupPercentage) – nbrOrders × deliveryCost
 *
 * D’où :
 *   deliveryCost = (serviceFee + markupPercentage) – (targetProfit / nbrOrders)
 */
public class TargetProfitDeliveryCost implements TargetProfitPolicies {

    private final double targetProfit;
    private final double serviceFee;
    private final double markupPercentage;
    private final int numberOfOrders;

    public TargetProfitDeliveryCost(double targetProfit, double serviceFee, double markupPercentage, int numberOfOrders) {
        if (numberOfOrders <= 0) {
            throw new IllegalArgumentException("numberOfOrders must be > 0");
        }
        this.targetProfit = targetProfit;
        this.serviceFee = serviceFee;
        this.markupPercentage = markupPercentage;
        this.numberOfOrders = numberOfOrders;
    }
    
    public TargetProfitDeliveryCost() {
        this.targetProfit = -1;
        this.serviceFee = -1;
        this.markupPercentage = -1;
        this.numberOfOrders = -1;
    }

    public double getTargetProfit()     { return targetProfit; }
    public double getServiceFee()       { return serviceFee; }
    public double getMarkupPercentage() { return markupPercentage; }
    public int getNumberOfOrders()      { return numberOfOrders; }

    @Override
    public String getPolicyName() {
        return "Target Profit based on Delivery Cost";
    }

    @Override
    public double computeParameters() {
        return (serviceFee + markupPercentage) - (targetProfit / numberOfOrders);
    }

    @Override
    public String toString() {
        return "TargetProfitDeliveryCost{" +
                "targetProfit=" + targetProfit +
                ", serviceFee=" + serviceFee +
                ", markupPercentage=" + markupPercentage +
                ", numberOfOrders=" + numberOfOrders +
                ", computedDeliveryCost=" + String.format("%.2f", computeParameters()) +
                '}';
    }
}
