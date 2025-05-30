package targetprofitpolicies;

public class TargetProfitDeliveryCostTest {
    public static void main(String[] args) {
        double targetProfit     = 2000.0;   // profit que l'on veut atteindre
        double serviceFee       = 2.5;      // frais de service par commande
        double markupPercentage = 1.0;      // pourcentage de marge appliqué (en euros ici)
        int    numberOfOrders   = 500;      // nombre de commandes estimé

        // Création de la politique basée sur le calcul du deliveryCost
        TargetProfitDeliveryCost policy = new TargetProfitDeliveryCost(
                targetProfit, serviceFee, markupPercentage, numberOfOrders);

        // Calcul du coût de livraison nécessaire pour atteindre le profit cible
        double computedDeliveryCost = policy.computeParameters();

        // Affichage des informations
        System.out.println(policy); // utilise toString()
        System.out.printf("Computed deliveryCost: %.2f €%n", computedDeliveryCost);
    }
}

