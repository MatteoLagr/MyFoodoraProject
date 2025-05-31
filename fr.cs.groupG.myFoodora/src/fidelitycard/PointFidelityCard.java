package fidelitycard;


// réduc avec les points mais pas mealOfWeek

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
	
	public PointFidelityCard() {
		
	}
	
	// getter
	public Customer getCustomer() {
		if (customer == null) {
	        throw new IllegalStateException("Customer not set on fidelity card");
	    }
		return customer;
		}
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
	public String getTypeOfCard() {return "PointFidelityCard";} //J'ai modifié en "PointFidelityCard" pour pouvoir l'utiliser plus facilement dans Order
	
	
}


