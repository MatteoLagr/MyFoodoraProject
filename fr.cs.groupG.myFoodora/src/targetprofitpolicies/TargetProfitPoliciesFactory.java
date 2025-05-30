package targetprofitpolicies;

import other.AbstractFactory;
import deliverypolicies.DeliveryPolicies;
import fidelitycard.FidelityCards;
import sellable.Sellable;
import sortingpolicies.ShippedOrderSortingPolicies;
import users.Users;

public class TargetProfitPoliciesFactory extends AbstractFactory {

    @Override
    public TargetProfitPolicies getTargetProfitPolicies(String targetProfitPoliciesType) {
        if (targetProfitPoliciesType == null) {
            throw new IllegalArgumentException("Target profit policy type cannot be null.");
        }

        switch (targetProfitPoliciesType.toLowerCase()) {
            case "deliverycost":
                return new TargetProfitDeliveryCost();
            case "servicefee":
                return new TargetProfitServiceFee();
            case "markup":
                return new TargetProfitMarkup();
            default:
                throw new IllegalArgumentException("Unknown target profit policy type: " + targetProfitPoliciesType);
        }
    }

    // Les autres méthodes ne sont pas pertinentes ici : on les rend explicites
    @Override
    public Users getUser(String userType) {
        throw new UnsupportedOperationException("Not supported by TargetProfitPoliciesFactory");
    }

    @Override
    public Sellable getSellable(String sellableType) {
        throw new UnsupportedOperationException("Not supported by TargetProfitPoliciesFactory");
    }

    @Override
    public DeliveryPolicies getDeliveryPolicies(String deliveryPoliciesType) {
        throw new UnsupportedOperationException("Not supported by TargetProfitPoliciesFactory");
    }

    @Override
    public ShippedOrderSortingPolicies getSortingPolicies(String sortingPoliciesType) {
        throw new UnsupportedOperationException("Not supported by TargetProfitPoliciesFactory");
    }

    @Override
    public FidelityCards getFidelityCards(String fidelityCardType) {
        throw new UnsupportedOperationException("Not supported by TargetProfitPoliciesFactory");
    }
}
