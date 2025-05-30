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
		
		public Courier(String name, String username, int id, String surname, String password) {
			super(name, username, id, surname, password);
			this.position = null;
			this.phoneNumber = null;
			this.deliveredOrdersCount = 0;
			this.onDuty = false;
			this.available = false;
		}
		
	// getters
		
	/**
	 * Méthode permettant d'obtenir le type de user 
	 */
	@Override
	public String getUserType() {
		return "Courier";
	}
	
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

	/**
	 * Cette méthode permet au livreur de dire s'il est
	 * on duty ou off duty
	 * @param onDuty
	 */
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
	
	/**
	 * La méthode acceptDeliveryCall est appelée lorsque 
	 * le courier décide d'accepter ou non une commande qui lui est proposé.
	 * @param order
	 **/
	
	public boolean acceptDelivery(Order order) {
		if (!this.isOnDuty()) {
			System.out.println("Courier" + getUsername() + "is offDuty");
			return false;
		}
		return true;
	}
	
	/**
	 * La méthode completeDelivery permet d'incrémenter de 1
	 * le compteur de livraison effectuées par le livreur 
	 * @param order
	 */
	
	public void completeDelivery(Order order) {
	    System.out.println("Courier " + getUsername() + " completed delivery for order: " + order.getOrderId());
	    incrementDeliveredOrdersCount();
	}
	
	/**
	 * Méthode permettant d'incrémenter le nombre
	 * de livraison effectuées par un livreur
	 */
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
