package fidelitycard;

// donne accès à proba d'une commande gratuite mais pas mealOfWeek

import other.Order;
import other.OrderItem;
import users.Customer;
import users.Restaurants;

public class LotteryFidelityCard implements FidelityCards {

	private Customer customer;
	private double probaWin;
	private boolean hasWon;
	
	// Constructeur
	public LotteryFidelityCard(Customer customer, double probaWin) {
		this.customer = customer;
		this.probaWin = probaWin;
	}
	
	public LotteryFidelityCard() {
		
	}
	// getters
	public Customer getCustomer() {
		if (customer == null) {
	        throw new IllegalStateException("Customer not set on fidelity card");
	    }
		return customer;
		}
	public double getProbaWin() {return probaWin;}
	
	// setter
	public void setProbaWin(double probaWin) {this.probaWin = probaWin;}
	
	// on redéfinit les méthodes de l'interface
	
	
	@Override
	public String getTypeOfCard() {return "LotteryFidelityCard";} //Pareil que pour point fidelity card
	
	

	
	

}
