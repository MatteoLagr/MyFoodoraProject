package deliverypolicies;

import other.AbstractFactory;
import other.DeliveryPolicies;
import other.FidelityCards;
import other.Sellable;
import other.ShippedOrderSortingPolicies;
import other.TargetProfitPolicies;
import users.Users;

public class DeliveryPoliciesFactory extends AbstractFactory {
	
	
	@Override
	public Users getUserType(String userType) {
		return null;
	}
	
	@Override 
	public Sellable getSellableType(String sellableType) {
		return null;
	}
	
	@Override
	public TargetProfitPolicies getTargetProfitPoliciesType(String targetProfitPoliciesType) {
		return null;
	}
	
	@Override
	public DeliveryPolicies getDeliveryPoliciesType(String deliveryPoliciesType) {
		if (deliveryPoliciesType.equalsIgnoreCase("FairOccupationDelivery")) {
			return new FairOccupationDelivery();
		}
		if (deliveryPoliciesType.equalsIgnoreCase("FastestDelivery")) {
			return new FastestDelivery();
		}
	}
	
	
	@Override
	public ShippedOrderSortingPolicies getSortingPoliciesType(String sortingPoliciesType) {
		return null;
	}
	
	@Override 
	public FidelityCards getFidelityCardsType(String fidelityCardType) {
		return null;
	}
	
	

}
