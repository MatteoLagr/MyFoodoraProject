package targetprofitpolicies;

/**
 * Politique : on ajuste le serviceFee pour atteindre un profit cible.
 *
 * Formule :
 *   profit = N × (serviceFee + markupPercentage + deliveryCost)
 *   ⇒ serviceFee = targetProfit / N − markupPercentage − deliveryCost
 */
public class TargetProfitServiceFee implements TargetProfitPolicies {

    /* ─── Attributs ─────────────────────────────────────────────── */
    private final double targetProfit;
    private final double deliveryCost;
    private final double markupPercentage;
    private final int    numberOfOrders;

    /* ─── Constructeur ──────────────────────────────────────────── */
    public TargetProfitServiceFee(double targetProfit,
                                  double deliveryCost,
                                  double markupPercentage,
                                  int numberOfOrders) {
        if (numberOfOrders <= 0) throw new IllegalArgumentException("numberOfOrders must be > 0");
        this.targetProfit      = targetProfit;
        this.deliveryCost      = deliveryCost;
        this.markupPercentage  = markupPercentage;
        this.numberOfOrders    = numberOfOrders;
    }

    /* ─── Getters ──────────────────────────────────────────────── */
    public double getTargetProfit()     { return targetProfit; }
    public double getDeliveryCost()     { return deliveryCost; }
    public double getMarkupPercentage() { return markupPercentage; }
    public int    getNumberOfOrders()   { return numberOfOrders; }

    public String getPolicyName() { return "Target Profit based on Service Fee"; }

    /* ─── Méthode imposée par l’interface ──────────────────────── */
    @Override
    public double computeParameters() {
        return (targetProfit / numberOfOrders) - markupPercentage - deliveryCost;
    }

    /* ─── toString() ───────────────────────────────────────────── */
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
