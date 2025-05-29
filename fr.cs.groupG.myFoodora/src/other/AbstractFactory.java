package other;

import deliverypolicies.DeliveryPolicies;
import fidelitycard.FidelityCards;
import sellable.Sellable;
import sortingpolicies.ShippedOrderSortingPolicies;
import targetprofitpolicies.TargetProfitPolicies;
import users.Users;


public abstract class AbstractFactory {
	
	public abstract Users getUserType(String userType);
	public abstract Sellable getSellableType(String sellableType);
	public abstract TargetProfitPolicies getTargetProfitPoliciesType(String targetProfitPoliciesType);
	public abstract DeliveryPolicies getDeliveryPoliciesType(String deliveryPoliciesType);
	public abstract ShippedOrderSortingPolicies getSortingPoliciesType(String sortingPoliciesType);
	public abstract FidelityCards getFidelityCardsType(String fidelityCardType);
	
	
	
	
	

}
