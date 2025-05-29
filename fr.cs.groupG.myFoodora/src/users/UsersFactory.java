package users;

import other.AbstractFactory;
import other.DeliveryPolicies;
import other.FidelityCards;
import other.Sellable;
import other.ShippedOrderSortingPolicies;
import other.TargetProfitPolicies;

public class UsersFactory extends AbstractFactory {
	
	
	
	
	
	
	@Override
	public Users getUserType(String userType) {
		
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
		return null;
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
