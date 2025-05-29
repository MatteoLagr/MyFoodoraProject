package other;

import java.util.ArrayList;
import java.util.List;
import users.Courier;
import users.Manager;
import users.Restaurants;
import users.Customer;


public class MyFoodoraSystem implements Observer{
	private List<Manager> managers;
	private List<Restaurants> restaurants;
	private List<Customer> customers;
	private List<Courier> couriers;
	private ArrayList<Order> orderHistory;
	private double serviceFee;
	private double markupPercentage;
	private double deliveryCost;
	
	private static MyFoodoraSystem instance = null; //Utilisation d'un Singleton Pattern pour MyFoodoraSystem
	
	// productFactory : AbstractFactory
	
	private MyFoodoraSystem() {
		this.managers = new ArrayList<>();
        this.restaurants = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.couriers = new ArrayList<>();
        this.orderHistory = new ArrayList<>();
        this.serviceFee = 0.0;
        this.markupPercentage = 0.0;
        this.deliveryCost = 0.0;
	}
	
	public static MyFoodoraSystem getInstance() {
		if (instance==null) {
			instance = new MyFoodoraSystem();
		}
		return instance;
	}
	
	// getters
	public List<Manager> getManagers() {
	    return managers;
	}

	public List<Restaurants> getRestaurants() {
	    return restaurants;
	}

	public List<Customer> getCustomers() {
	    return customers;
	}

	public List<Courier> getCouriers() {
	    return couriers;
	}

	public ArrayList<Order> getOrderHistory() {
	    return orderHistory;
	}

	public double getServiceFee() {
	    return serviceFee;
	}

	public double getMarkupPercentage() {
	    return markupPercentage;
	}

	public double getDeliveryCost() {
	    return deliveryCost;
	}

	// setters
	public void setManagers(List<Manager> managers) {
	    this.managers = managers;
	}

	public void setRestaurants(List<Restaurants> restaurants) {
	    this.restaurants = restaurants;
	}

	public void setCustomers(List<Customer> customers) {
	    this.customers = customers;
	}

	public void setCouriers(List<Courier> couriers) {
	    this.couriers = couriers;
	}

	public void setOrderHistory(ArrayList<Order> orderHistory) {
	    this.orderHistory = orderHistory;
	}

	public void setServiceFee(double serviceFee) {
	    this.serviceFee = serviceFee;
	}

	public void setMarkupPercentage(double markupPercentage) {
	    this.markupPercentage = markupPercentage;
	}

	public void setDeliveryCost(double deliveryCost) {
	    this.deliveryCost = deliveryCost;
	}

	
	// Constructeur
	
	
	public double computeTotalIncome() {
		return 0;
	}
	
	public double computeTotalProfit() {
		return 0;
	}
	
	public void setTargetProfitPolicy() {
		
	}
	
	public void allocateCourierToOrder() {
		
	}
	
	public void notifySpecialOffer(){
		
	}
	
	public void update(){
		
	}
}
