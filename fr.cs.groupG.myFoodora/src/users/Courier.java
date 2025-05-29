package users;

import other.Order;

public class Courier extends Users{
	
	private Point2D position;
	private String phoneNumber;
	private boolean onDuty;
	private int deliveredOrdersCount;
	private boolean available;
	
	// Constructeur
		public Courier(String name, String username, int id, String surname, String password,Point2D position, String phoneNumber, boolean onDuty, int deliveredOrdersCount, boolean available) {
		    super(name, username, id, surname, password);
			this.position = position;
		    this.phoneNumber = phoneNumber;
		    this.onDuty = onDuty;
		    this.deliveredOrdersCount = deliveredOrdersCount;
		    this.available = available;
		}
	
		public Courier(String name, String username, int id, String surname, Point2D position, String phoneNumber) {
			super(name, username, id, surname, "");
			this.position = position;
			this.phoneNumber = phoneNumber;
			this.deliveredOrdersCount = 0;
			this.onDuty = false;
			this.available = false;
		}
		
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

	
	
	// Méthodes : 
	
	public boolean acceptDelivery(Order order) {
		if (!this.isOnDuty()) {
			System.out.println("OffDuty");
			return false;
		}
		return true;
	}
	
	
	public void completeDelivery(Order order) {
		if (this.acceptDelivery(order)) {
			setDeliveredOrdersCount(this.deliveredOrdersCount + 1);
		}
	}

}
