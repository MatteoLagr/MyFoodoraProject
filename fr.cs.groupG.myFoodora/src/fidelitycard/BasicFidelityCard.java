package fidelitycard;

import other.Order;
import other.OrderItem;
import users.Customer;
import users.Restaurants;

// la BasicFidelityCard donne accès aux réductions generic de chaque restaurant. On part du principe qu'il y a
// une réduction sur tous les plats, dont le % change en fonction du restaurant

public class BasicFidelityCard implements FidelityCards{
	
	private Customer customer;
	
	// Constructeur
	public BasicFidelityCard(Customer customer) {
		this.customer = customer;
	}
	// getter
	public Customer getCustomer() {return customer;}
	
	
	// on redéfinit les méthodes de l'interface
	
	@Override
	public double getNormalPrice(Order order) {
		return order.calculateOriginalPrice();
	}
	
	
	
	@Override
	public double computeFidelityPrice(Order order) {
		Restaurants restaurant = order.getRestaurant();
		double genericDiscountPercentage = restaurant.getGenericDiscount();
		return getNormalPrice(order)*(1-genericDiscountPercentage);
	}
	
	@Override
	public String getTypeOfCard() {return "BasicFidelityCard";} //Pareil que pour point fidelity card
	
	

	
	
}
