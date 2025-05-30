package sortingpolicies;

import other.AbstractFactory;
import deliverypolicies.DeliveryPolicies;
import fidelitycard.FidelityCards;
import sellable.Sellable;
import targetprofitpolicies.TargetProfitPolicies;
import users.Users;

/**
 * Fabrique de politiques de tri d’OrderItem expédiés.
 * Elle ne crée que des implémentations de ShippedOrderSortingPolicies.
 */
public class ShippedOrderSortingPoliciesFactory extends AbstractFactory {

    @Override
    public ShippedOrderSortingPolicies getSortingPolicies(String sortingPoliciesType) {
        if (sortingPoliciesType == null || sortingPoliciesType.trim().isEmpty()) {
            throw new IllegalArgumentException("sortingPoliciesType must not be null or empty");
        }

        switch (sortingPoliciesType.trim().toLowerCase()) {
            case "mostorderedhalfmeal":
                return (ShippedOrderSortingPolicies) new MostOrderedHalfMeal();
            case "leastorderedhalfmeal":
                return (ShippedOrderSortingPolicies) new LeastOrderedHalfMeal();
            case "mostorderedmenuitem":
                return (ShippedOrderSortingPolicies) new MostOrderedMenuItem();
            case "leastorderedmenuitem":
                return (ShippedOrderSortingPolicies) new LeastOrderedMenuItem();
            default:
                throw new IllegalArgumentException("Unknown sorting policy type: " + sortingPoliciesType);
        }
    }

    /* ────────────────────────────────────────────────────────────
       Les autres méthodes ne sont pas supportées par cette factory
       ──────────────────────────────────────────────────────────── */
    @Override public Users getUser(String userType)                        { throw new UnsupportedOperationException("Not supported by ShippedOrderSortingPoliciesFactory"); }
    @Override public Sellable getSellable(String sellableType)            { throw new UnsupportedOperationException("Not supported by ShippedOrderSortingPoliciesFactory"); }
    @Override public TargetProfitPolicies getTargetProfitPolicies(String type) { throw new UnsupportedOperationException("Not supported by ShippedOrderSortingPoliciesFactory"); }
    @Override public DeliveryPolicies getDeliveryPolicies(String type)    { throw new UnsupportedOperationException("Not supported by ShippedOrderSortingPoliciesFactory"); }
    @Override public FidelityCards getFidelityCards(String type)          { throw new UnsupportedOperationException("Not supported by ShippedOrderSortingPoliciesFactory"); }
}
