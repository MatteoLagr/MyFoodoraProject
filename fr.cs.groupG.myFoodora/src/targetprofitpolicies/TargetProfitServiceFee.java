package targetprofitpolicies;

public class TargetProfitServiceFee implements TargetProfitPolicies {
	
/*	public TargetProfitPolicies getPolicyName() {
		return;
	}
	*/
	
	public double computeParameters() {
		return 0;
	}	
	
	
// Attributs 
	
	private double targetProfit;
	private double markupPercentage;
	private double deliveryCost;
	

// Getters
	
	public double getTargetProfit() {
		return targetProfit;
	}
	
	public double getDeliveryCost() {
		return deliveryCost;
	}
		
	public double getMarkupPercentage() {
		return markupPercentage;
	}	
	
		
// Setters
	
	public void setTargetProfit() {
		this.targetProfit = targetProfit;
	}
	
	public void setMarkupPercentage() {
		this.markupPercentage = markupPercentage;
	}
	
	public void setDeliveryCost() {
		this.deliveryCost = deliveryCost;
	}
	
	public TargetProfitServiceFee(double targetProfit,double serviceFee,double deliveryCost) {
		this.targetProfit = targetProfit;
		this.markupPercentage = markupPercentage;
		this.deliveryCost = deliveryCost;
	}
		
		
}
