package users;

import java.util.ArrayList;
import fidelitycard.FidelityCards;
import other.Order;
import other.OrderItem;
import sellable.Meal;
import sellable.Sellable;


public class Customer extends Users{
	
	private Point2D address;
	private String email;
	private String phoneNumber;
	private FidelityCards fidelityCard;
	private ArrayList<Order> orderHistory;
	private boolean notificationConsent;
	private int fidelityPoints;
	

	public Customer(String name, String username, int id, String surname, String password, Point2D address, String email, String phoneNumber, FidelityCards fidelitycard, ArrayList<Order> orderHistory, boolean notificationConsent, int fidelityPoints) {
		super(name, username, id, surname, password);
		this.address=address;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.orderHistory = orderHistory;
		this.notificationConsent = notificationConsent;
		this.fidelityPoints=fidelityPoints;
	}
	
	public Customer(String name, String username, int id , String surname , Point2D address, String email, String phoneNumber) {
		super(name, username, id, surname, "");
		this.address=address;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.orderHistory = new ArrayList<Order>();
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
	
	
	public void setNotificationConsent(boolean notificationConsent) {
		this.notificationConsent = notificationConsent;
		
		//Ajouter le système pour notifier les restaurants que le customer veut ou non recevoir avec l'observer
	}
	
	public void setFidelityCard(FidelityCards fidelityCard) {
		this.fidelityCard = fidelityCard;
	}
	
	public void unregisterFidelityCard() {
		this.fidelityCard = null;
	}
	
	//////////////////////////////////
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
	public String toString() {
		return "Customer " + surname +" "+ name + ", adress: " + address + ", email: " + email + ", contact: "
				+ phoneNumber + ", fidelityCard: " + fidelityCard + ", fidelityPoints: " + fidelityPoints + ", notificationConsent: " + notificationConsent + ", has previously ordered "
				+ orderHistory.size()+" times.";
	}
	
	
	
	
	
	
	
	

}
