package targetprofitpolicies;

/**
 * Politique : on ajuste le markupPercentage pour atteindre un profit cible.
 *
 * Formule utilisée :
 *   profit = N × (serviceFee + markupPercentage - deliveryCost)
 *   ⇒ markupPercentage = (targetProfit / N) - serviceFee + deliveryCost
 */
public class TargetProfitMarkup implements TargetProfitPolicies {

    /* ─── Attributs ─────────────────────────────────────────────── */
    private final double targetProfit;
    private final double serviceFee;
    private final double deliveryCost;
    private final int numberOfOrders;

    /* ─── Constructeur ──────────────────────────────────────────── */
    public TargetProfitMarkup(double targetProfit,
                              double serviceFee,
                              double deliveryCost,
                              int numberOfOrders) {
        if (numberOfOrders <= 0) throw new IllegalArgumentException("numberOfOrders must be > 0");
        this.targetProfit = targetProfit;
        this.serviceFee = serviceFee;
        this.deliveryCost = deliveryCost;
        this.numberOfOrders = numberOfOrders;
    }

    public TargetProfitMarkup() {
		this.targetProfit = -1;
		this.deliveryCost = -1;
		this.serviceFee = -1;
		this.numberOfOrders = -1;
		}
    
    /* ─── Getters ──────────────────────────────────────────────── */
    public double getTargetProfit()   { return targetProfit; }
    public double getServiceFee()     { return serviceFee; }
    public double getDeliveryCost()   { return deliveryCost; }
    public int getNumberOfOrders()    { return numberOfOrders; }

    @Override
    public String getPolicyName() {
        return "Target Profit based on Markup Percentage";
    }

    /* ─── Méthode imposée par l’interface ──────────────────────── */
    @Override
    public double computeParameters() {
        return (targetProfit / numberOfOrders) - serviceFee + deliveryCost;
    }

    /* ─── toString() ───────────────────────────────────────────── */
    @Override
    public String toString() {
        return "TargetProfitMarkup{" +
               "targetProfit=" + targetProfit +
               ", serviceFee=" + serviceFee +
               ", deliveryCost=" + deliveryCost +
               ", numberOfOrders=" + numberOfOrders +
               ", computedMarkupPercentage=" + String.format("%.2f", computeParameters());
}
}