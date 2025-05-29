package fidelitycard;

import other.Order;
import other.OrderItem;
import users.Customer;
import users.Restaurants;

// la BasicFidelityCard donne accès aux réductions generic de chaque restaurant. On part du principe qu'il y a
// une réduction sur tous les plats, dont le % change en fonction du restaurant

public class BasicFidelityCard {
	
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
		double normalPrice =0;
		for (OrderItem orderItem : order.getItems()) { normalPrice += orderItem.getPriceUnit()*orderItem.getQuantity();}		
	}
	
	
	@Override
	public double computeFidelityPrice(Order order) {
		Restaurants restaurant = order.getRestaurant();
		double genericDiscountPercentage = restaurant.getGenericDiscount();
		return getNormalPrice(order)*(1-genericDiscountPercentage);
	}
	
	public String getTypeOfCard() {return "The user has a basic fidelity card";}
	
	

	
	
}
