package deliverypolicies;

import other.AbstractFactory;
import fidelitycard.FidelityCards;
import sellable.Sellable;
import sortingpolicies.ShippedOrderSortingPolicies;
import targetprofitpolicies.TargetProfitPolicies;
import users.Users;

public class DeliveryPoliciesFactory extends AbstractFactory {
	
	
	@Override
	public Users getUser(String userType) {
		return null;
	}
	
	@Override 
	public Sellable getSellable(String sellableType) {
		return null;
	}
	
	@Override
	public TargetProfitPolicies getTargetProfitPolicies(String targetProfitPoliciesType) {
		return null;
	}
	
	@Override
	public DeliveryPolicies getDeliveryPolicies(String deliveryPoliciesType) {
		if (deliveryPoliciesType.equalsIgnoreCase("FairOccupationDelivery")) {
			return new FairOccupationDelivery();
		}
		if (deliveryPoliciesType.equalsIgnoreCase("FastestDelivery")) {
			return new FastestDelivery();
		}
		return null;
	}
	
	
	@Override
	public ShippedOrderSortingPolicies getSortingPolicies(String sortingPoliciesType) {
		return null;
	}
	
	@Override 
	public FidelityCards getFidelityCards(String fidelityCardType) {
		return null;
	}
	
	

}
