package users;


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
		
	}
	
	public void removerUser(Users user) {
			
	}
	
	public void activateUser(Users user) {
		
	}
	
	public void deactivateUser(Users user) {
		
	}
	
	public void setServiceFee(double serviceFee) {
		
	}
	
	public void setMarkupPercentage(double markup) {
		
	}
	
	public void setDeliveryCost(double deliveryCost) {
		
	}
	
	public double computeTotalIncome() {
		// jssp trop ce qu'on lui donne (un resto peut etre)
	}
	
	public double computeTotalProfit() {
		
	}
	
	public double averageIncomeCustomer() {
		
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
