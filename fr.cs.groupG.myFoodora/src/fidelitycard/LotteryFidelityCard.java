package fidelitycard;

import other.Order;
import other.OrderItem;
import users.Customer;
import users.Restaurants;

public class LotteryFidelityCard {

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
		double normalPrice =0;
		for (OrderItem orderItem : order.getItems()) { normalPrice += orderItem.getPriceUnit()*orderItem.getQuantity();}		
	}

	
	
	@Override
	public double computeFidelityPrice(Order order) {
		Restaurants restaurant = order.getRestaurant();
		double randomValue = Math.random();
		if (randomValue < this.probaWin) {System.out.println("You have won ! This order is free !");return 0;}
		else {System.out.println("Try again next time !");return getNormalPrice(order);}
	}
	
	public String getTypeOfCard() {return "The user has a lottery fidelity card";}
	
	

	
	

}
