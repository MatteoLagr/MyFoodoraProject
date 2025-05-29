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
	    if (onDuty) {
	        System.out.println("Courier " + getName() + " is now on duty.");
	    } else {
	        System.out.println("Courier " + getName() + " is now off duty.");
	    }
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
			System.out.println("Courier" + getName() + "is offDuty");
			return false;
		}
		return true;
	}
	
	public void completeDelivery(Order order) {
	    System.out.println("Courier " + getName() + " completed delivery for order: " + order.getId());
	    incrementDeliveredOrdersCount();
	}
	    
	private void incrementDeliveredOrdersCount() {
	    this.deliveredOrdersCount++;
	}
	
	@Override
	public String toString() {
	    return "Courier{" +
	            "name='" + getName() + '\'' +
	            ", username='" + getUsername() + '\'' +
	            ", id=" + getId() +
	            ", surname='" + getSurname() + '\'' +
	            ", phoneNumber='" + phoneNumber + '\'' +
	            ", position=" + position +
	            ", onDuty=" + onDuty +
	            ", available=" + available +
	            ", deliveredOrdersCount=" + deliveredOrdersCount +
	            '}';
	}



}
