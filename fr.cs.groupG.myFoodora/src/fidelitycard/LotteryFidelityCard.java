package fidelitycard;

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
	// getters
	public Customer getCustomer() {return customer;}
	public double getProbaWin() {return probaWin;}
	
	// setter
	public void setProbaWin(double probaWin) {this.probaWin = probaWin;}
	
	// on redéfinit les méthodes de l'interface
	
	@Override
	public double getNormalPrice(Order order) {
		return order.calculateOriginalPrice();
	}

	
	@Override
	public double computeFidelityPrice(Order order) {
		Restaurants restaurant = order.getRestaurant();
		double randomValue = Math.random();
		if (randomValue < this.probaWin) {System.out.println("You have won ! This order is free !");return 0;}
		else {System.out.println("Try again next time !");return getNormalPrice(order);}
	}
	
	@Override
	public String getTypeOfCard() {return "LotteryFidelityCard";} //Pareil que pour point fidelity card
	
	

	
	

}
