package users;

import other.AbstractFactory;
import other.DeliveryPolicies;
import other.FidelityCards;
import other.Sellable;
import other.ShippedOrderSortingPolicies;
import other.TargetProfitPolicies;
import java.util.ArrayList;


public class UsersFactory extends AbstractFactory {
	
	private ArrayList<Customer> customers;
	private ArrayList<Restaurants> restaurants;
	
	
	
	
	
	
	@Override
	public Users getUserType(String userType) {
		for (Customer customer:customers) {
			if (customer.getUserType().equalsIgnoreCase(userType)) {
				return new Customer(customer.getName(), customer.getUsername(),customer.getId(), customer.getSurname(),customer.getPassword(),customer.getAddress(),customer.getEmail(),customer.getPhoneNumber(),customer.getFidelityCard(), customer.getOrderHistory(),customer.isNotificationConsent(),customer.getFidelityPoints());
			}		
		}
		
		for (Restaurants restaurant:restaurants) {
			if (restaurant.getUserType().equalsIgnoreCase(userType)) {
				
			}
		}
		
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
