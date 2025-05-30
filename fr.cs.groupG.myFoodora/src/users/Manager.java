package users;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import deliverypolicies.DeliveryPolicies;
import other.MyFoodoraSystem;
import other.Order;

public class Manager extends Users{

	// Méthodes
	
	public Manager(String name, String surname, int id, String username) {
		super(name, surname, id, username, "");
	}


	@Override
	public String getUserType() {
		return "Manager";
	}
	
	/**
	 * Cette méthode ajoute l'user en paramètre au système MyFoodora,
	 * en faisant en sorte de l'ajouter dans la bonne catégorie.
	 * Cette méthode fait aussi attention à ce que le type de ce user
	 * soit géré par le système.
	 * @param user
	 */
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
	
	/**
	 * Cette méthode supprime l'user en paramètre au système MyFoodora.
	 * Cette méthode fait aussi attention à ce que le type de ce user
	 * soit géré par le système.
	 * @param user
	 */
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
	
	/**
	 * Cette méthode permet au manager de modifier le service fee du système
	 * MyFoodora, à condition que le nouveau service fee ne soit pas négatif.
	 * @param serviceFee
	 */
	public void changeServiceFee(double serviceFee) {
		MyFoodoraSystem system = MyFoodoraSystem.getInstance();
		if (serviceFee >= 0) {
			system.setServiceFee(serviceFee);
		}
		else {
			throw new IllegalArgumentException("Service Fee cannot be negative");
		}
	}
	
	/**
	 * Cette méthode permet au manager de modifier le markup percentage
	 * du système MyFoodora, à condition que ce markup soit dans le bon format
	 * , c'est-à-dire un double entre 0 et 1.
	 * @param markup
	 */
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
	
	/**
	 * Cette méthode permet au manager de modifier le delivery cost du
	 * système MyFoodora, à condition que le nouveau delivery cost ne
	 * soit pas négatif.
	 * @param deliveryCost
	 */
	public void changeDeliveryCost(double deliveryCost) {
		MyFoodoraSystem system = MyFoodoraSystem.getInstance();
		if (deliveryCost >= 0) {
			system.setServiceFee(deliveryCost);
		}
		else {
			throw new IllegalArgumentException("Delivery Cost cannot be negative");
		}
	}
	
	/**
	 * Cette méthode permet de convertir un String en une
	 * date, à condition que le String en paramètre soit dans le
	 * bon format : dd/MM/yyyy.
	 * @param date
	 * @return
	 */
	public static LocalDate stringToDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid format. Expected format : dd/MM/yyyy", e);
        }
    }
	
	public double computeTotalIncome(String startPeriod, String endPeriod) {
		MyFoodoraSystem system = MyFoodoraSystem.getInstance();
		ArrayList<Order> orderHistory = system.getOrderHistory();
		LocalDate startDate = stringToDate(startPeriod);
		LocalDate endDate = stringToDate(endPeriod);
		double totalIncome = 0;
		if (endDate.isBefore(startDate)) {
			throw new IllegalArgumentException("End date is before begin date");
		}
		else {
			for (Order order : orderHistory) {
				if ((order.getDateOrderPlaced().isEqual(startDate) || order.getDateOrderPlaced().isAfter(startDate)) &&
			            (order.getDateOrderPlaced().isEqual(endDate) || order.getDateOrderPlaced().isBefore(endDate))) {
					totalIncome+=order.calculateFinalPriceFees();
				}
			}
		}
		return totalIncome;
	}
	
	public double computeTotalProfit(String startPeriod, String endPeriod) {
		MyFoodoraSystem system = MyFoodoraSystem.getInstance();
		ArrayList<Order> orderHistory = system.getOrderHistory();
		LocalDate startDate = stringToDate(startPeriod);
		LocalDate endDate = stringToDate(endPeriod);
		double totalProfit = 0;
		if (endDate.isBefore(startDate)) {
			throw new IllegalArgumentException("End date is before begin date");
		}
		else {
			for (Order order : orderHistory) {
				if ((order.getDateOrderPlaced().isEqual(startDate) || order.getDateOrderPlaced().isAfter(startDate)) &&
			            (order.getDateOrderPlaced().isEqual(endDate) || order.getDateOrderPlaced().isBefore(endDate))) {
					totalProfit+=order.generatedProfit();
				}
			}
		}
		return totalProfit;
	}
		

	
	public double averageIncomeCustomer(String startPeriod, String endPeriod) {
		MyFoodoraSystem system = MyFoodoraSystem.getInstance();
		ArrayList<Order> orderHistory = system.getOrderHistory();
		LocalDate startDate = stringToDate(startPeriod);
		LocalDate endDate = stringToDate(endPeriod);
		double averageIncome = 0;
		int numberOfCustomer = 0;
		ArrayList<Integer> customers = new ArrayList<Integer>();
		if (endDate.isBefore(startDate)) {
			throw new IllegalArgumentException("End date is before begin date");
		}
		else {
			for (Order order : orderHistory) {
				if ((order.getDateOrderPlaced().isEqual(startDate) || order.getDateOrderPlaced().isAfter(startDate)) &&
			            (order.getDateOrderPlaced().isEqual(endDate) || order.getDateOrderPlaced().isBefore(endDate))) {
					if (!customers.contains(order.getCustomer().getId())) {
						customers.add(order.getCustomer().getId()); //On utilise Id car celui-ci est unique, on ne va donc pas compter deux fois le même customer
					}
				}
			}
			numberOfCustomer = customers.size();
			if (numberOfCustomer==0) {
				averageIncome=0;
			}
			else {
				averageIncome = computeTotalIncome(startPeriod, endPeriod)/numberOfCustomer;
			}
		}
		return averageIncome;
	}
	
	/**
	 * Cette méthode donne le restaurant ayant reçu le plus de commandes
	 * dans le système MyFoodora. Dans le où 2 ou plusieurs restaurants ont le plus
	 * de commande, la méthode renvoie le restaurant ayant reçu une commande en premier.
	 * @return
	 */
	public Restaurants getMostSellingRestaurant() {
		MyFoodoraSystem system = MyFoodoraSystem.getInstance();
		ArrayList<Order> orderHistory = system.getOrderHistory();
		ArrayList<Restaurants> bestRestaurant = new ArrayList<Restaurants>();
		HashMap<Restaurants, Integer> ordersPerRestaurant = new HashMap<Restaurants, Integer>();
		
		for (Order order : orderHistory) {
			Restaurants restaurant = order.getRestaurant();
			if (ordersPerRestaurant.containsKey(restaurant)) {
				ordersPerRestaurant.replace(restaurant, ordersPerRestaurant.get(restaurant)+1);
			}
			else {
				ordersPerRestaurant.put(restaurant, 1);
			}
		}
		int numberMaxOrder = Integer.MIN_VALUE;
		for (Map.Entry<Restaurants, Integer> entry : ordersPerRestaurant.entrySet()) {
            if (entry.getValue() > numberMaxOrder) {
            	bestRestaurant.clear();
            	numberMaxOrder = entry.getValue();
            	bestRestaurant.add(entry.getKey());	
            }
            else if (entry.getValue() == numberMaxOrder){
            	bestRestaurant.add(entry.getKey());
            }
        }	
		return bestRestaurant.isEmpty() ? null : bestRestaurant.get(0);	//On renvoie arbitrairement le premier restaurant de la liste	
	}
	
	/**
	 * Cette méthode donne le restaurant ayant reçu le moins de commandes
	 * dans le système MyFoodora. Dans le où 2 ou plusieurs restaurants ont le moins
	 * de commande, la méthode renvoie le restaurant ayant reçu une commande en premier.
	 * @return
	 */
	public Restaurants getLeastSellingRestaurant() {
		MyFoodoraSystem system = MyFoodoraSystem.getInstance();
		ArrayList<Order> orderHistory = system.getOrderHistory();
		ArrayList<Restaurants> leastRestaurant = new ArrayList<Restaurants>();
		HashMap<Restaurants, Integer> ordersPerRestaurant = new HashMap<Restaurants, Integer>();
		
		for (Order order : orderHistory) {
			Restaurants restaurant = order.getRestaurant();
			if (ordersPerRestaurant.containsKey(restaurant)) {
				ordersPerRestaurant.replace(restaurant, ordersPerRestaurant.get(restaurant)+1);
			}
			else {
				ordersPerRestaurant.put(restaurant, 1);
			}
		}
		int numberMinOrder = Integer.MAX_VALUE;
		for (Map.Entry<Restaurants, Integer> entry : ordersPerRestaurant.entrySet()) {
            if (entry.getValue() < numberMinOrder) {
            	leastRestaurant.clear();
            	numberMinOrder = entry.getValue();
            	leastRestaurant.add(entry.getKey());	
            }
            else if (entry.getValue() == numberMinOrder){
            	leastRestaurant.add(entry.getKey());
            }
        }	
		return leastRestaurant.isEmpty() ? null : leastRestaurant.get(0);	
		
	}
	
	/**
	 * Cette méthode donne le livreur ayant effectué le plus de commandes
	 * dans le système MyFoodora. Dans le où 2 ou plusieurs livreurs ont le plus
	 * de commande effectuées, la méthode renvoie le livreur ayant reçu une commande en premier.
	 * @return
	 */
	public Courier getMostActiveCourier() {
		MyFoodoraSystem system = MyFoodoraSystem.getInstance();
		ArrayList<Order> orderHistory = system.getOrderHistory();
		ArrayList<Courier> bestCourier = new ArrayList<Courier>();
		HashMap<Courier, Integer> ordersPerCourier = new HashMap<Courier, Integer>();
		
		for (Order order : orderHistory) {
			Courier courier = order.getAssignedCourier();
			if (ordersPerCourier.containsKey(courier)) {
				ordersPerCourier.replace(courier, ordersPerCourier.get(courier)+1);
			}
			else {
				ordersPerCourier.put(courier, 1);
			}
		}
		int numberMaxOrder = Integer.MIN_VALUE;
		for (Map.Entry<Courier, Integer> entry : ordersPerCourier.entrySet()) {
            if (entry.getValue() > numberMaxOrder) {
            	bestCourier.clear();
            	numberMaxOrder = entry.getValue();
            	bestCourier.add(entry.getKey());	
            }
            else if (entry.getValue() == numberMaxOrder){
            	bestCourier.add(entry.getKey());
            }
        }	
		return bestCourier.isEmpty() ? null : bestCourier.get(0);
	}
	
	/**
	 * Cette méthode donne le livreur ayant effectué le moins de commandes
	 * dans le système MyFoodora. Dans le où 2 ou plusieurs livreurs ont le moins
	 * de commande effectuées, la méthode renvoie le livreur ayant reçu une commande en premier.
	 * @return
	 * @return
	 */
	public Courier getLeastActiveCourier() {
		MyFoodoraSystem system = MyFoodoraSystem.getInstance();
		ArrayList<Order> orderHistory = system.getOrderHistory();
		ArrayList<Courier> worstCourier = new ArrayList<Courier>();
		HashMap<Courier, Integer> ordersPerCourier = new HashMap<Courier, Integer>();
		
		for (Order order : orderHistory) {
			Courier courier = order.getAssignedCourier();
			if (ordersPerCourier.containsKey(courier)) {
				ordersPerCourier.replace(courier, ordersPerCourier.get(courier)+1);
			}
			else {
				ordersPerCourier.put(courier, 1);
			}
		}
		int numberMinOrder = Integer.MIN_VALUE;
		for (Map.Entry<Courier, Integer> entry : ordersPerCourier.entrySet()) {
            if (entry.getValue() < numberMinOrder) {
            	worstCourier.clear();
            	numberMinOrder = entry.getValue();
            	worstCourier.add(entry.getKey());	
            }
            else if (entry.getValue() == numberMinOrder){
            	worstCourier.add(entry.getKey());
            }
        }	
		return worstCourier.isEmpty() ? null : worstCourier.get(0);
		
	}
	
	
	/**
	 * Cette méthode permet au manager de modifier
	 * la politique de livraison (assignation du "meilleur" livreur
	 * à une commande selon une politique précise) du système MyFoodora.
	 * La méthode fait attention à ce que la politique proposée en paramètre
	 * soit valable.
	 * @param policy
	 */
	public void setDeliveryPolicy(DeliveryPolicies policy) {
		MyFoodoraSystem system = MyFoodoraSystem.getInstance();
		if (policy.getDeliveryPolicyType() == "FairOccupationDelivery" || policy.getDeliveryPolicyType()=="FastestDelivery") {
			system.setDeliveryPolicy(policy);
		}
		else {
			throw new IllegalArgumentException("Unknown delivery policy: " + policy);
		}
		
	}
	

}
