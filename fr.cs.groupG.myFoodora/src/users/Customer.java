package users;

import java.util.ArrayList;
import fidelitycard.FidelityCards;
import other.MyFoodoraSystem;
import other.Observable;
import other.Observer;
import other.Order;
import other.OrderItem;
import sellable.Meal;
import sellable.Sellable;


public class Customer extends Users implements Observer {
	
	private Point2D address;
	private String email;
	private String phoneNumber;
	private FidelityCards fidelityCard;
	private ArrayList<Order> orderHistory;
	private boolean notificationConsent;
	private int fidelityPoints;
	

	public Customer(String name, String username, int id, String surname, String password, Point2D address, String email, String phoneNumber, FidelityCards fidelitycard, ArrayList<Order> orderHistory, boolean notificationConsent, int fidelityPoints) {
		super(name, username, id, surname, password);
		for (Customer customer : MyFoodoraSystem.getInstance().getCustomers()) {
			if (customer.getUsername()==username) {
				throw new IllegalArgumentException("This username has already been used");
			}
		}
		this.address=address;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.orderHistory = orderHistory;
		this.fidelityCard = null;
		this.notificationConsent = notificationConsent;
		this.fidelityPoints=fidelityPoints;
	}
	
	public Customer(String name, String username, int id , String surname , Point2D address, String email, String phoneNumber) {
		super(name, username, id, surname, "");
		for (Customer customer : MyFoodoraSystem.getInstance().getCustomers()) {
			if (customer.getUsername()==username) {
				throw new IllegalArgumentException("This username has already been used");
			}
		}
		this.address=address;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.orderHistory = new ArrayList<Order>();
		this.fidelityCard = null;
		this.notificationConsent = false;
		this.fidelityPoints = 0;
	}
	
	public Customer(String name, String username, int id, String surname, String password) {
		super(name, username, id, surname, password);
		for (Customer customer : MyFoodoraSystem.getInstance().getCustomers()) {
			if (customer.getUsername()==username) {
				throw new IllegalArgumentException("This username has already been used");
			}
		}
		this.address = new Point2D(0,0);
		this.email = null;
		this.phoneNumber = null;
		this.orderHistory = new ArrayList<Order>();
		this.fidelityCard = null;
		this.notificationConsent = false;
		this.fidelityPoints = 0;
	}
	
	@Override
	public String getUserType() {
		return "Customer";
	}
	
	public Point2D getAddress() {
		return address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public FidelityCards getFidelityCard() {
		return fidelityCard;
	}
	
	public ArrayList<Order> getOrderHistory(){
		return orderHistory;
	}
	
	public boolean isNotificationConsent() {
		return notificationConsent;
	}
	
	public int getFidelityPoints() {
		return fidelityPoints;
	}
	
	/**
	 * Permet au client de choisir s'il souhaite
	 * recevoir ou non des notifications des restaurants.
	 * Si le client accepte les notifications, il est enregistré en tant 
	 * qu'observateur après de tous les restaurants du système MyFoodora.
	 * Sinon, il ne recevra pas de notifications.
	 * @param notificationConsent
	 */
	public void setNotificationConsent(boolean notificationConsent) {
		this.notificationConsent = notificationConsent;
		for(Restaurants restaurant : MyFoodoraSystem.getInstance().getRestaurants()) {
			if (notificationConsent) {
				restaurant.registerObserver(this);
			}
			else {
				restaurant.removeObserver(this);
			}
		}
	}
	
	public void setFidelityCard(FidelityCards fidelityCard) {
		this.fidelityCard = fidelityCard;
	}
	
	/**
	 * Permet au client de quitter le plan
	 * de fidélité actuel
	 */
	public void unregisterFidelityCard() {
		this.fidelityCard = null;
	}
	
	/**
	 * Cette méthode permet de préparer une commande auprès d'un restaurant particulier,
	 * en vérifiant que les "items" demandés sont bien proposés par le restaurant.
	 * La méthode renvoie aussi le prix à payer pour la commande, ajoute la commande
	 * à l'historique et renvoie la commande.
	 * @param restaurant
	 * @param items
	 * @return
	 */
	public Order placeOrder(Restaurants restaurant, ArrayList<OrderItem> items) {
		Order order = new Order(this, restaurant);
		for (OrderItem item : items) {
			Sellable sellable = item.getItem();
			boolean isOffered = false;
			if (sellable instanceof Meal) {
				isOffered = restaurant.getMeals().contains(sellable);
			} else if (restaurant.getMenu() != null && restaurant.getMenu().getAllDishes() != null) {
				isOffered = restaurant.getMenu().getAllDishes().contains(sellable);
			}
			
			if (isOffered) {
				order.addItem(item);
			} else {
	            System.out.println("Item '" + sellable + "' not offered by restaurant: " + restaurant.getName());
			}
		}
		order.calculateFinalPrice();
		orderHistory.add(order);
		return order;
	}
	
	
	@Override
	public void update(Observable observable, Meal mealOfWeek) {
		if (observable instanceof Restaurants) {
			String returnString = "New meal of the week at the restaurant : ";
			Restaurants restaurant = (Restaurants) observable;
			returnString+=restaurant.getName()+"\n";
			System.out.println(returnString + mealOfWeek);
		}
	}

	
	@Override
	public String toString() {
		return "Customer " + surname +" "+ name + ", adress: " + address + ", email: " + email + ", contact: "
				+ phoneNumber + ", fidelityCard: " + fidelityCard + ", fidelityPoints: " + fidelityPoints + ", notificationConsent: " + notificationConsent + ", has previously ordered "
				+ orderHistory.size()+" times.";
	}
	
	
	
	
	
	
	
	

}
