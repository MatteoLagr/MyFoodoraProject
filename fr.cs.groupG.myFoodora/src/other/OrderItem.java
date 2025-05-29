package other;

import sellable.Sellable;

public class OrderItem {
	
	private Sellable item;
	private int quantity;
	private double priceUnit;
	
	//Constructeur
	public OrderItem(Sellable item, int quantity, double priceUnit) {
		this.item = item;
		this.quantity = quantity;
		this.priceUnit = priceUnit;
	}
	
	//Getters
	public Sellable getItem() {
		return item;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public double getPriceUnit() {
		return priceUnit;
	}
	
	//Setters
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void setPriceUnit(double priceUnit) {
		this.priceUnit = priceUnit;
	}
	
	
	public double calculatePrice() {
		return this.quantity * this.priceUnit;
	}
	
	

}
