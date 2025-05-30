package users;

import other.AbstractFactory;
import deliverypolicies.DeliveryPolicies;
import fidelitycard.FidelityCards;
import sellable.Sellable;
import sortingpolicies.ShippedOrderSortingPolicies;
import targetprofitpolicies.TargetProfitPolicies;
import java.util.ArrayList;


public class UsersFactory extends AbstractFactory {
	
	private ArrayList<Customer> customers;
	private ArrayList<Restaurants> restaurants;
	private ArrayList<Courier> couriers;
	private ArrayList<Manager> managers;
	
	public UsersFactory() {
		this.couriers = new ArrayList<Courier>();
		this.customers = new ArrayList<Customer>();
		this.managers = new ArrayList<Manager>();
		this.restaurants = new ArrayList<Restaurants>();
	}
	
	public UsersFactory(ArrayList<Courier> couriers,ArrayList<Customer> customers,ArrayList<Manager> managers,ArrayList<Restaurants> restaurants) {
		this.couriers=couriers;
		this.customers=customers;
		this.managers=managers;
		this.restaurants=restaurants;
	}
	
	@Override
	public Users getUser(String userType) {
		for (Customer customer:customers) {
			if (customer.getUserType().equalsIgnoreCase(userType)) {
				return new Customer(customer.getName(), customer.getUsername(),customer.getId(), customer.getSurname(),customer.getPassword(),customer.getAddress(),customer.getEmail(),customer.getPhoneNumber(),customer.getFidelityCard(), customer.getOrderHistory(),customer.isNotificationConsent(),customer.getFidelityPoints());
			}		
		}
		
		for (Restaurants restaurant:restaurants) {
			if (restaurant.getUserType().equalsIgnoreCase(userType)) {
				return new Restaurants(restaurant.getName(), restaurant.getUsername(), restaurant.getId(),restaurant.getPassword(),restaurant.getLocation(),restaurant.getMenu(),restaurant.getMeals(),restaurant.getGenericDiscount(),restaurant.getSpecialDiscount(),restaurant.getMealOfWeek());	
			}
		}
		
		for (Courier courier : couriers) {
			if (courier.getUserType().equalsIgnoreCase(userType)) {
				return new Courier(courier.getName(), courier.getUsername(),courier.getId(),courier.getSurname(),courier.getPassword(),courier.getPosition(),courier.getPhoneNumber(),courier.isOnDuty(),courier.getDeliveredOrdersCount(),courier.isAvailable());
			}
		}
		
		for (Manager manager : managers) {
			if (manager.getUserType().equalsIgnoreCase(userType)) {
				return new Manager(manager.getName(),manager.getSurname(),manager.getId(),manager.getUsername());
			}
		}
		throw new IllegalArgumentException("Unknown user type: " + userType);
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
