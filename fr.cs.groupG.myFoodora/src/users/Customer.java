package users;

import java.util.ArrayList;


public class Customer extends Users{
	
	private Point2D address;
	private String email;
	private String phoneNumber;
	private FidelityCard fidelityCard;
	private List<Order> orderHistory;
	private boolean notificationConsent;
	private int fidelityPoints;
	
	
	public Customer(String name, String username, String surname, int id, Point2D address, String email, String phoneNumber) {
		super(name, username, surname, id, "");
		this.address=address;
		this.email=email;
		this.phoneNumber=phoneNumber;
		this.orderHistory = new ArrayList<>();
		this.notificationConsent = false;
		this.fidelityPoints = 0;
	}
	
	
	
	

}
