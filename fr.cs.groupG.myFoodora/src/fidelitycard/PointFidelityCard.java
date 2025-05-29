package fidelitycard;

import other.Order;
import other.OrderItem;
import users.Customer;
import users.Restaurants;


public class PointFidelityCard implements FidelityCards{

	
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
		return order.calculateOriginalPrice();
	}
	
	@Override
	public double computeFidelityPrice(Order order) {
		Restaurants restaurant = order.getRestaurant();
		double specialDiscountPercentage = restaurant.getSpecialDiscount(); 
		return getNormalPrice(order)*0.9; //On utilise pas specialDiscountPercentage ???
	}
	
	
	@Override
	public String getTypeOfCard() {return "PointFidelityCard";} //J'ai modifié en "PointFidelityCard" pour pouvoir l'utiliser plus facilement dans Order
	
	
}


