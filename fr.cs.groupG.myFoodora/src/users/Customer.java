package users;

import java.util.ArrayList;
import other.FidelityCards;



public class Customer extends Users{
	
	private Point2D address;
	private String email;
	private String phoneNumber;
	private FidelityCards fidelityCard;
	private List<Order> orderHistory;
	private boolean notificationConsent;
	private int fidelityPoints;
	

	public Customer(String name, String username, int id, String surname, String password, Point2D address, String email, String phoneNumber, FidelityCard fidelitycard, List<Order> orderHistory, boolean notificationConsent, int fidelityPoints) {
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
		return OrderHistory;
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
	public Order placeOrder(Restaurant restaurant, List<Object> items) {
		
	}
	
	
	
	@Override
	public String toString() {
		return "Customer " + surname +" "+ name + ", adress: " + address + ", email: " + email + ", contact: "
				+ phoneNumber + ", fidelityCard: " + fidelityCard + ", fidelityPoints: " + fidelityPoints + ", notificationConsent: " + notificationConsent + ", has previously ordered "
				+ orderHistory.size()+" times.";
	}
	
	
	
	
	
	
	
	

}
