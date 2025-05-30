package users;

import other.MyFoodoraSystem;

public class Manager extends Users{

	// Méthodes
	
	public Manager(String name, String surname, int id, String username) {
		super(name, surname, id, username, "");
	}


	@Override
	public String getUserType() {
		return "Manager";
	}
	
	
	public void addUser(Users user) {
		MyFoodoraSystem system = MyFoodoraSystem.getInstance();
		if (user.getUserType().equalsIgnoreCase("Restaurant")) {
			Restaurants restaurant = new Restaurants(user.getName(), user.getUsername(), user.getId(), user.getSurname(), user.getPassword());
			if (!system.getRestaurants().contains(restaurant)) {
				system.getRestaurants().add(restaurant);
			}
			else {
				throw new IllegalStateException("Warning : You can not add this restaurant as it is already in the system");
			}
		}
		
		
		else if (user.getUserType().equalsIgnoreCase("Customer")) {
			Customer customer = new Customer(user.getName(), user.getUsername(), user.getId(), user.getSurname(), user.getPassword());
			if (!system.getCustomers().contains(customer)) {
				system.getCustomers().add(customer);
			}
			else {
				throw new IllegalStateException("Warning : You can not add this customer as it is already in the system");
			}
		}
		
		
		else if (user.getUserType().equalsIgnoreCase("Courier")) {
			Courier courier = new Courier(user.getName(), user.getUsername(), user.getId(), user.getSurname(), user.getPassword());
			if (!system.getCouriers().contains(courier)) {
				system.getCouriers().add(courier);
			}
			else {
				throw new IllegalStateException("Warning : You can not add this courier as it is already in the system");
			}
		}
		else {
			throw new IllegalArgumentException("We do not recognize this user: " + user.getUsername());
		}
		
		
	}
	
	public void removerUser(Users user) {
		MyFoodoraSystem system = MyFoodoraSystem.getInstance();
		if (user.getUserType().equalsIgnoreCase("Restaurant")) {
			Restaurants restaurant = new Restaurants(user.getName(), user.getUsername(), user.getId(), user.getSurname(), user.getPassword());
			if (!system.getRestaurants().contains(restaurant)) {
				system.getRestaurants().remove(restaurant);
			}
			else {
				throw new IllegalStateException("Warning : You can not remove a restaurant that is not in the system");
			}
		}
		
		
		else if (user.getUserType().equalsIgnoreCase("Customer")) {
			Customer customer = new Customer(user.getName(), user.getUsername(), user.getId(), user.getSurname(), user.getPassword());
			if (!system.getCustomers().contains(customer)) {
				system.getCustomers().remove(customer);
			}
			else {
				throw new IllegalStateException("Warning : You can not remove a customer that is not in the system");
			}
		}
		
		
		else if (user.getUserType().equalsIgnoreCase("Courier")) {
			Courier courier = new Courier(user.getName(), user.getUsername(), user.getId(), user.getSurname(), user.getPassword());
			if (!system.getCouriers().contains(courier)) {
				system.getCouriers().remove(courier);
			}
			else {
				throw new IllegalStateException("Warning : You can not remove a courier that is not in the system");
			}
		}
		else {
			throw new IllegalArgumentException("We do not recognize this user: " + user.getUsername());
		}
		
			
	}
	
	public void activateUser(Users user) {
		
	}
	
	public void deactivateUser(Users user) {
		
	}
	
	public void changeServiceFee(double serviceFee) {
		MyFoodoraSystem system = MyFoodoraSystem.getInstance();
		if (serviceFee >= 0) {
			system.setServiceFee(serviceFee);
		}
		else {
			throw new IllegalArgumentException("Service Fee cannot be negative");
		}
	}
	
	public void changeMarkupPercentage(double markup) {
		MyFoodoraSystem system = MyFoodoraSystem.getInstance();
		if (markup >= 0 && markup <=1) {
			system.setServiceFee(markup);
		}
		else if (markup <0) {
			throw new IllegalArgumentException("MarkUp Percentage cannot be negative");
		}
		else {
			throw new IllegalArgumentException("MarkUp Percentage cannot be greater than 1");
		}
		
	}
	
	public void changeDeliveryCost(double deliveryCost) {
		MyFoodoraSystem system = MyFoodoraSystem.getInstance();
		if (deliveryCost >= 0) {
			system.setServiceFee(deliveryCost);
		}
		else {
			throw new IllegalArgumentException("Delivery Cost cannot be negative");
		}
	}
	
	public double computeTotalIncome(String startPeriod, String endPeriod) {
		// jssp trop ce qu'on lui donne (un resto peut etre)
	}
	
	public double computeTotalProfit(String startPeriod, String endPeriod) {
		
	}
	
	public double averageIncomeCustomer(String startPeriod, String endPeriod) {
		
	}
	
	public Restaurants getMostSellingRestaurant() {
		
	}
	
	public Restaurants getLeastSellingRestaurant() {
		
	}
	
	public Courier getMostActiveCourier() {
		
	}
	
	public Courier getLeastActiveCourier() {
		
	}
	
	public void setDeliveryPolicy(DeliveryPolicies policy) {
		
	}
	

}
