package fidelitycard;

import other.Order;
import other.OrderItem;
import users.Customer;
import users.Restaurants;

// la BasicFidelityCard donne accès aux réductions special (mealOfWeek) de chaque restaurant. 

public class BasicFidelityCard implements FidelityCards{
	
	private Customer customer;
	
	// Constructeur
	public BasicFidelityCard(Customer customer) {
		this.customer = customer;
	}
	
	public BasicFidelityCard() {
		
	}
	// getter
	public Customer getCustomer() {
		if (customer == null) {
	        throw new IllegalStateException("Customer not set on fidelity card");
	    }
		return customer;
		}
	
	
	@Override
	public String getTypeOfCard() {return "BasicFidelityCard";} //Pareil que pour point fidelity card
	
	

	
	
}
