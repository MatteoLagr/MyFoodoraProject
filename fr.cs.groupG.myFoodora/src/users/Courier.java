package users;

import other.Order;

public class Courier {
	
	private Point2D position;
	private String phoneNumber;
	private boolean onDuty;
	private int deliveredOrdersCount;
	private boolean available;
	
	
	// getters
	public Point2D getPosition() {
	    return position;
	}

	public String getPhoneNumber() {
	    return phoneNumber;
	}

	public boolean isOnDuty() {
	    return onDuty;
	}

	public int getDeliveredOrdersCount() {
	    return deliveredOrdersCount;
	}

	public boolean isAvailable() {
	    return available;
	}

	// setters
	public void setPosition(Point2D position) {
	    this.position = position;
	}

	public void setPhoneNumber(String phoneNumber) {
	    this.phoneNumber = phoneNumber;
	}

	public void setOnDuty(boolean onDuty) {
	    this.onDuty = onDuty;
	}

	public void setDeliveredOrdersCount(int deliveredOrdersCount) {
	    this.deliveredOrdersCount = deliveredOrdersCount;
	}

	public void setAvailable(boolean available) {
	    this.available = available;
	}

	
	// Constructeur
	public Courier(Point2D position, String phoneNumber, boolean onDuty, int deliveredOrdersCount, boolean available) {
	    this.position = position;
	    this.phoneNumber = phoneNumber;
	    this.onDuty = onDuty;
	    this.deliveredOrdersCount = deliveredOrdersCount;
	    this.available = available;
	}
	
	
	// Méthodes : 
	
	public void acceptDelivery(Order order) {
		
	}
	
	public void refuseDelivery(Order order) {
		
	}
	
	public void completeDelivery(Order order) {
		
	}

}
