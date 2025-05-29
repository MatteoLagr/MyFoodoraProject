package targetprofitpolicies;

/**
 * Politique : on ajuste le deliveryCost pour atteindre un profit cible.
 *
 * Formule retenue (simplifiée, conforme aux énoncés du projet MyFoodora) :
 *   profit = nbrOrders × (serviceFee + markupPercentage – deliveryCost)
 *
 * D’où :
 *   deliveryCost = serviceFee + markupPercentage – targetProfit / nbrOrders
 *
 * S’il n’y a pas de commandes sur le mois, on lève une IllegalArgumentException.
 */
public class TargetProfitDeliveryCost implements TargetProfitPolicies {

    /* ─── Attributs ─────────────────────────────────────────────── */
    private final double targetProfit;        // profit cible (€)
    private final double serviceFee;          // frais fixe par commande (€)
    private final double markupPercentage;    // marge appliquée par MyFoodora (€)
    private final int    numberOfOrders;      // commandes passées le mois dernier

    /* ─── Constructeur ──────────────────────────────────────────── */
    public TargetProfitDeliveryCost(double targetProfit,double serviceFee, double markupPercentage, int numberOfOrders) {
        if (numberOfOrders <= 0) {throw new IllegalArgumentException("numberOfOrders must be > 0");}
        this.targetProfit     = targetProfit;
        this.serviceFee       = serviceFee;
        this.markupPercentage = markupPercentage;
        this.numberOfOrders   = numberOfOrders;
    }

    /* ─── Getters ──────────────────────────────────────────────── */
    public double getTargetProfit()     { return targetProfit; }
    public double getServiceFee()       { return serviceFee; }
    public double getMarkupPercentage() { return markupPercentage; }
    public int    getNumberOfOrders()   { return numberOfOrders; }
    
    public String getPolicyName() {return "Target Profit based on Delivery Cost";}

    /* ─── Méthode imposée par l’interface ──────────────────────── */
    /**
     * Calcule le deliveryCost nécessaire pour atteindre le profit cible.
     *
     * @return deliveryCost (€) à appliquer
     */
    @Override
    public double computeParameters() {return (targetProfit / numberOfOrders) - serviceFee - markupPercentage;}

    /* ─── toString() pour débogage / affichage ─────────────────── */
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

