package fidelitycard;

import other.Order;
import other.OrderItem;
import users.Customer;
import users.Restaurants;


public class PointFidelityCard {

	
	private Customer customer;
	private int numberPoints;
	
	// Constructeur
	public PointFidelityCard(Customer customer) {
		this.customer = customer;
		this.numberPoints = 0;
		}
	
	// getter
	public Customer getCustomer() {return customer;}
	public int getNumberPoints() {return numberPoints;}
	
	// setter
	public void setPoints(int newTotalPoints) {this.numberPoints = newTotalPoints;}
	
	public void addPoints(int additionalPoints) {this.numberPoints += additionalPoints;}
	public void usePoints(int numberPointsToUse) {
		if (this.getNumberPoints() >= numberPointsToUse) {this.numberPoints -= numberPointsToUse;}
		else {System.out.println("Number of Points of the card insufficient");}
	}
	
	// on redéfinit les méthodes de l'interface
	@Override
	public double getNormalPrice(Order order) {
		double normalPrice =0;
		for (OrderItem orderItem : order.getItems()) { normalPrice += orderItem.getPriceUnit()*orderItem.getQuantity();}		
	}
	
	
	@Override
	public double computeFidelityPrice(Order order) {
		Restaurants restaurant = order.getRestaurant();
		double specialDiscountPercentage = restaurant.getSpecialDiscount();
		return getNormalPrice(order)*0.9;
	}
	
	
	
	public String getTypeOfCard() {return "The user has a points fidelity card";}
	
	
}


