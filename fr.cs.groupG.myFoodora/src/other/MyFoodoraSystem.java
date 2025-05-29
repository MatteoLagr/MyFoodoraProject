package other;

import java.util.ArrayList;
import java.util.List;

import targetprofitpolicies.TargetProfitPolicies;
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
	private TargetProfitPolicies policy;
	
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
        this.policy = new TargetProfitPolicies(); // jsp trop à quoi sert ce bloc : en plus la ligne marche pas
	}
	
	public static MyFoodoraSystem getInstance() {
		if (instance==null) {
			instance = new MyFoodoraSystem();
		}
		return instance;
	}
	
	//getters
	public List<Manager> getManagers() { return managers; }
	public List<Restaurants> getRestaurants() { return restaurants; }
	public List<Customer> getCustomers() { return customers; }
	public List<Courier> getCouriers() { return couriers; }
	public ArrayList<Order> getOrderHistory() { return orderHistory; }
	public double getServiceFee() { return serviceFee; }
	public double getMarkupPercentage() { return markupPercentage; }
	public double getDeliveryCost() { return deliveryCost; }

	//setters
	public void setManagers(List<Manager> managers) { this.managers = managers; }
	public void setRestaurants(List<Restaurants> restaurants) { this.restaurants = restaurants; }
	public void setCustomers(List<Customer> customers) { this.customers = customers; }
	public void setCouriers(List<Courier> couriers) { this.couriers = couriers; }
	public void setOrderHistory(ArrayList<Order> orderHistory) { this.orderHistory = orderHistory; }
	public void setServiceFee(double serviceFee) { this.serviceFee = serviceFee; }
	public void setMarkupPercentage(double markupPercentage) { this.markupPercentage = markupPercentage; }
	public void setDeliveryCost(double deliveryCost) { this.deliveryCost = deliveryCost; }


	
	// Constructeur : on a juste besoin de mettre 1 manager minimum et ensuite il modifie tout le reste. 
	// à l'origine il n'y avait pas de restaurants ...
	
	public MyFoodoraSystem(ArrayList<Manager> managers) {
		this.managers = managers;
        this.restaurants = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.couriers = new ArrayList<>();
        this.orderHistory = new ArrayList<>();
        this.serviceFee = 0.0;
        this.markupPercentage = 0.0;
        this.deliveryCost = 0.0;
	}
	
	// Calcule le revenu total de la plateforme depuis sa création 
	public double computeTotalIncome() {
		double totalIncome = 0;
		for (Order order : this.getOrderHistory()) {
			totalIncome += order.calculateFinalPrice();
		}
		return totalIncome;
	}
	
	
	// Profit total = serviceFee par commande * nombre de commandes
	public double computeTotalProfit() {
		double totalProfit =0;
		for (Order order : this.getOrderHistory()) {// car un manager peut décider de changer les frais à un moment donc on peut pas simplement multiplier mais faut check en temps réel
			double priceOrder = order.calculateFinalPriceFees();
			MyFoodoraSystem systemOrder = order.getSystem();
			if (priceOrder != 0) {
				totalProfit += systemOrder.getServiceFee();
				totalProfit += priceOrder * (1+systemOrder.getMarkupPercentage());
			}
		}
	return totalProfit;
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
