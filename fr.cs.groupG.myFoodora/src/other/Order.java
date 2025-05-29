package other;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import fidelitycard.LotteryFidelityCard;
import fidelitycard.PointFidelityCard;
import sellable.Meal;
import users.Courier;
import users.Customer;
import users.Restaurants;

public class Order {
	
	private double finalPrice;
	private ArrayList<OrderItem> items;
	private Date dateOrderPlaced;
	private Customer customer;
	private Courier assignedCourier;
	private String orderId;
	private Restaurants restaurant;
	private String status;
	private MyFoodoraSystem system;
	
	
	//Constructeur 
	
	public Order(double finalPrice, ArrayList<OrderItem> items, Date dateOrderPlaced, Customer customer, Courier assignedCourier, String orderId, Restaurants restaurant, String status,MyFoodoraSystem system) {
		this.finalPrice = finalPrice;
		this.items = items;
		this.dateOrderPlaced = dateOrderPlaced;
		this.customer = customer;
		this.assignedCourier = assignedCourier;
		this.orderId = orderId;
		this.restaurant=restaurant;
		this.status =status;
		this.system = system;
	}
	
	
	public Order(Customer customer, Restaurants restaurant) {
		this.customer = customer;
		this.restaurant = restaurant;
		this.items = new ArrayList<>();
		this.dateOrderPlaced = new Date();
		this.orderId = UUID.randomUUID().toString();
		this.status = "pending";
	}
	
	//Getters 
	
	public double getFinalPrice() {return finalPrice;}
	
	public ArrayList<OrderItem> getItems(){return items;}
	
	public Date getDateOrderPlaced() {return dateOrderPlaced;}
	
	public Customer getCustomer() {return customer;}
	
	public Courier getAssignedCourier() {return assignedCourier;}
	
	public String getOrderId() {return orderId;}
	
	public Restaurants getRestaurant() {return restaurant;}
	
	public String getStatus() {return status;}
	
	public MyFoodoraSystem getSystem() {return system;}
	
	//Setters
	
	public void assignCourier(Courier courier) {
		this.assignedCourier=courier;
	}
	
	public void setStatus(String status) {
		this.status=status;
	}
	
	public void setSystem(MyFoodoraSystem system) {
		this.system = system;
	}
	
	//Autres méthodes
	
	// Méthode qui calcul le prix de la commande sans réduction avec les cartes de fidélités mais avec les réductions meal of the week
	public double calculateOriginalPrice() {
		double total = 0.0;
        for (OrderItem item : items) {
            double itemPrice = item.calculatePrice();
            
            // On vérifie si l'item est le meal of the week du restaurant en question 
            if (item.getItem() instanceof Meal) {
                Meal meal = (Meal) item.getItem();
                if (restaurant.getMealOfWeek() != null && 
                    meal.getName().equals(restaurant.getMealOfWeek().getName())) {
                	//Si c'est le cas, on applique le special discount factor du restaurant pour le meal of the week
                    double specialDiscount = restaurant.getSpecialDiscount();
                    itemPrice = itemPrice * (1 - specialDiscount);
                }
            }
            total += itemPrice;
        }
	    return total;
	}
	
	public double calculateFinalPrice() {
		double originalPrice = this.calculateOriginalPrice();
		double result = originalPrice;
	    
	    if (customer.getFidelityCard() != null) {
	        String cardType = customer.getFidelityCard().getTypeOfCard();
	        
	        if (cardType.equals("PointFidelityCard")) {
	            // On caste vers la classe PointFidelityCard pour accéder aux méthodes spécifiques (getNumberPoints ici)
	            PointFidelityCard pointCard = (PointFidelityCard) customer.getFidelityCard();
	            int points = pointCard.getNumberPoints();
	            if (points >= 100) {
	            	pointCard.setPoints(points - 100);
	            	result = originalPrice * 0.9;
	            }   	
	         }
	        else if (cardType.equals("LotteryFidelityCard")) {
	        	LotteryFidelityCard lotteryCard = (LotteryFidelityCard) customer.getFidelityCard();
	        	double randomValue = Math.random();
	        	if (randomValue < lotteryCard.getProbaWin()) {
	        		result = 0;
	        	}
	        }
	    }
	    this.finalPrice = result;
	    return result;
	}
	
	
	/////////////////////////////////////////////////////////
	// Je crée 2nouvelles méthodes qui prennent en compte qu'on ajoute markup, frais de service et de livraison à la commande
	
	public double calculateOriginalPriceFees() {
		double total = 0.0;
		MyFoodoraSystem system = this.getSystem();
		double totalAfterFees;
        for (OrderItem item : items) {
            double itemPrice = item.calculatePrice();
            
            // On vérifie si l'item est le meal of the week du restaurant en question 
            if (item.getItem() instanceof Meal) {
                Meal meal = (Meal) item.getItem();
                if (restaurant.getMealOfWeek() != null && 
                    meal.getName().equals(restaurant.getMealOfWeek().getName())) {
                	//Si c'est le cas, on applique le special discount factor du restaurant pour le meal of the week
                    double specialDiscount = restaurant.getSpecialDiscount();
                    itemPrice = itemPrice * (1 - specialDiscount);
                }
            }
            total += itemPrice;
        }
        totalAfterFees = total*(1+system.getMarkupPercentage()) + system.getServiceFee() + system.getDeliveryCost();
        return totalAfterFees;
	}
	
	public double calculateFinalPriceFees() {
		double originalPrice = this.calculateOriginalPriceFees();
		double result = originalPrice;
	    
	    if (customer.getFidelityCard() != null) {
	        String cardType = customer.getFidelityCard().getTypeOfCard();
	        
	        if (cardType.equals("PointFidelityCard")) {
	            // On caste vers la classe PointFidelityCard pour accéder aux méthodes spécifiques (getNumberPoints ici)
	            PointFidelityCard pointCard = (PointFidelityCard) customer.getFidelityCard();
	            int points = pointCard.getNumberPoints();
	            if (points >= 100) {
	            	pointCard.setPoints(points - 100);
	            	result = originalPrice * 0.9;
	            }   	
	         }
	        else if (cardType.equals("LotteryFidelityCard")) {
	        	LotteryFidelityCard lotteryCard = (LotteryFidelityCard) customer.getFidelityCard();
	        	double randomValue = Math.random();
	        	if (randomValue < lotteryCard.getProbaWin()) {
	        		result = 0;
	        	}
	        }
	    }
	    this.finalPrice = result;
	    return result;
	}
	
	
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	
	
	
	
	@Override
	public String toString() {
	    return "Order{" +
	           "orderId='" + orderId + '\'' +
	           ", customer=" + customer.getName() +
	           ", restaurant=" + restaurant.getName() +
	           ", items=" + items.size() +
	           ", finalPrice=" + finalPrice +
	           ", status='" + status + '\'' +
	           '}';
	}


	

	
	// Max : j'ai utilisé order.getItems()
}
