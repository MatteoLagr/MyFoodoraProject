package sellable;

import java.util.ArrayList;

import other.AbstractFactory;
import deliverypolicies.DeliveryPolicies;
import fidelitycard.FidelityCards;
import sortingpolicies.ShippedOrderSortingPolicies;
import targetprofitpolicies.TargetProfitPolicies;
import users.Users;

public class SellableFactory extends AbstractFactory{
	private ArrayList<Dish> dishes;
	private ArrayList<Meal> meals;
	
	public SellableFactory(ArrayList<Dish> dishes,ArrayList<Meal> meals) {
		this.dishes = dishes;
		this.meals = meals;
	}
	
	
	public Sellable getSellable(String sellableType) {
		for (Dish dish:dishes) {
			if (dish.getSellableType().equalsIgnoreCase(sellableType)){
				return new Dish(dish.getName(),dish.getPrice(),dish.isVegetarian(),dish.isGlutenFree(),dish.getCategory());
			}
		}
		
		for (Meal meal:meals) {
			if (meal.getSellableType().equalsIgnoreCase(sellableType)){
				return new Meal(meal.getName(),meal.getDishes(),meal.isMealOfWeek(),meal.getDiscountPercentage());
			}
		}
		
		throw new IllegalArgumentException("Unknown sellable type: " + sellableType);
	}
	
	
	
	@Override
	public Users getUser(String userType) {
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
