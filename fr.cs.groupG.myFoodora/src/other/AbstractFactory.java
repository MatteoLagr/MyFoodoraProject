package other;

import deliverypolicies.DeliveryPolicies;
import fidelitycard.FidelityCards;
import sellable.Sellable;
import sortingpolicies.ShippedOrderSortingPolicies;
import targetprofitpolicies.TargetProfitPolicies;
import users.Users;


public abstract class AbstractFactory {
	
	public abstract Users getUser(String userType);
	public abstract Sellable getSellable(String sellableType);
	public abstract TargetProfitPolicies getTargetProfitPolicies(String targetProfitPoliciesType);
	public abstract DeliveryPolicies getDeliveryPolicies(String deliveryPoliciesType);
	public abstract ShippedOrderSortingPolicies getSortingPolicies(String sortingPoliciesType);
	public abstract FidelityCards getFidelityCards(String fidelityCardType);
	
	
	
	
	

}
