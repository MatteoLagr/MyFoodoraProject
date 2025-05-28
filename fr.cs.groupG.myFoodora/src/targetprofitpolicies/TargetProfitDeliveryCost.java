package targetprofitpolicies;

public class TargetProfitDeliveryCost implements TargetProfitPolicies {
	
/*	public TargetProfitPolicies getPolicyName() {
		return;
	}
	*/
	
	public double computeParameters() {
		return 0;
	}	
	
	
// Attributs 
	
	private double targetProfit;
	private double serviceFee;
	private double markupPercentage;
	

// Getters
	
	public double getTargetProfit() {
		return targetProfit;
	}
	
	public double getServiceFee() {
		return serviceFee;
	}
		
	public double getMarkupPercentage() {
		return markupPercentage;
	}	
	
		
// Setters
	
	public void setTargetProfit() {
		this.targetProfit = targetProfit;
	}
	
	public void setServiceFee() {
		this.serviceFee = serviceFee;
	}
	
	public void setMarkupPercentage() {
		this.markupPercentage = markupPercentage;
	}
	
	public TargetProfitDeliveryCost(double targetProfit,double serviceFee,double markupPercentage) {
		this.targetProfit = targetProfit;
		this.serviceFee = serviceFee;
		this.markupPercentage = markupPercentage;
	}
		
		
}
