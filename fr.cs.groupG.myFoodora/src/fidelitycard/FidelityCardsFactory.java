package fidelitycard;

import deliverypolicies.DeliveryPolicies;
import other.AbstractFactory;
import sellable.Sellable;
import sortingpolicies.ShippedOrderSortingPolicies;
import targetprofitpolicies.TargetProfitPolicies;
import users.Users;

public class FidelityCardsFactory extends AbstractFactory {
	
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
	public DeliveryPolicies getDeliveryPolicies(String deliveryPoliciesType){
		return null;
	}
	
	@Override
	public ShippedOrderSortingPolicies getSortingPolicies(String sortingPoliciesType) {
		return null;
	}
	
	@Override
	public FidelityCards getFidelityCards(String fidelityCardType) {
		if (fidelityCardType.equalsIgnoreCase("BasicFidelityCard")) {
			return new BasicFidelityCard();
		}
		else if (fidelityCardType.equalsIgnoreCase("PointFidelityCard")) {
			return new PointFidelityCard();
		}
		else if (fidelityCardType.equalsIgnoreCase("LotteryFidelityCard")) {
			return new LotteryFidelityCard();
		}
		throw new IllegalArgumentException("Unknown fidelity card:" + fidelityCardType);
	}
	
	
	

}
