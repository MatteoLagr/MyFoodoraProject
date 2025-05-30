package other;

import java.util.ArrayList;
import java.util.List;

import deliverypolicies.DeliveryPolicies;
import deliverypolicies.FastestDelivery;
import targetprofitpolicies.TargetProfitPolicies;
import targetprofitpolicies.TargetProfitServiceFee;
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
	private TargetProfitPolicies profitPolicy;
	private DeliveryPolicies deliveryPolicy;
	
	private static MyFoodoraSystem instance = null; //Utilisation d'un Singleton Pattern pour MyFoodoraSystem
	
	// productFactory : AbstractFactory
	
	// Constructeur pour le Singleton Pattern : il interdit toute création d'une instance en dehors d'ici
	// C'est ce qui ns assure que le système est unique et inaccessible
	private MyFoodoraSystem() { //on prend par défaut TargeProfitServiceFee(0,0,0,100) et FastestDelivery
		this.managers = new ArrayList<>();
        this.restaurants = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.couriers = new ArrayList<>();
        this.orderHistory = new ArrayList<>();
        this.serviceFee = 0.0;
        this.markupPercentage = 0.0;
        this.deliveryCost = 0.0;
        this.profitPolicy = new TargetProfitServiceFee(0,0,0,100);
        this.deliveryPolicy = new FastestDelivery();
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
	public TargetProfitPolicies getProfitPolicy() {return profitPolicy;}
	public DeliveryPolicies getDeliveryPolicy() {return deliveryPolicy;}

	//setters
	public void setManagers(List<Manager> managers) { this.managers = managers; }
	public void setRestaurants(List<Restaurants> restaurants) { this.restaurants = restaurants; }
	public void setCustomers(List<Customer> customers) { this.customers = customers; }
	public void setCouriers(List<Courier> couriers) { this.couriers = couriers; }
	public void setOrderHistory(ArrayList<Order> orderHistory) { this.orderHistory = orderHistory; }
	public void setServiceFee(double serviceFee) { this.serviceFee = serviceFee; }
	public void setMarkupPercentage(double markupPercentage) { this.markupPercentage = markupPercentage; }
	public void setDeliveryCost(double deliveryCost) { this.deliveryCost = deliveryCost; }
	public void setProfitPolicy(TargetProfitPolicies profitPolicy) {this.profitPolicy = profitPolicy;}
	public void setDeliveryPolicy(DeliveryPolicies deliveryPolicy) {this.deliveryPolicy = deliveryPolicy;}


	
	
	
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
				totalProfit += priceOrder * (systemOrder.getMarkupPercentage());
			}
		}
	return totalProfit;
	}
	
	
	public void allocateCourierToOrder(Order order) {
		
	}
	
	public void notifySpecialOffer(){
		
	}
	
	public void update(){
		
	}
}
