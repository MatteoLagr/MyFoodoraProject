package deliverypolicies;

import other.MyFoodoraSystem;
import other.Order;
import users.Courier;

public class FairOccupationDelivery implements DeliveryPolicies{
	
//	public Courier selectCourier(List<Courier>) {
//	return
//}
	
	public FairOccupationDelivery() {
		
	}

	@Override
	public String toString() {
		return "FairOccupationDelivery";
	}
	
	@Override
	public Courier selectCourier(Order order) {
	    MyFoodoraSystem system = MyFoodoraSystem.getInstance();
	    Courier chosenCourier = null;
	    for (Courier courier : system.getCouriers()) {
	        if (courier.isOnDuty()){
	            if (chosenCourier == null || courier.getDeliveredOrdersCount() < chosenCourier.getDeliveredOrdersCount()) {
	                chosenCourier = courier;
	            }
	            
	            else if (courier.getDeliveredOrdersCount() == chosenCourier.getDeliveredOrdersCount()) {
	            	if (order.getRestaurant().getLocation().distanceTo(courier.getPosition()) < order.getRestaurant().getLocation().distanceTo(chosenCourier.getPosition())) {
	            		chosenCourier = courier; //En cas d'égalité sur le nombre de livraisons effectuées, 
	            								 //nous passons à une comparaison sur le distance (FastestDelivery)
	            	}
	            }
	        }
	    }

	    return chosenCourier;
	}
	
	
	

}
