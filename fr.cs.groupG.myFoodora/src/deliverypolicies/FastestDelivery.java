package deliverypolicies;

import other.MyFoodoraSystem;
import other.Order;
import users.Courier;

public class FastestDelivery implements DeliveryPolicies{
	
	
	
//	public Courier selectCourier(List<Courier>) {
//		return
//	}
	
	public FastestDelivery() {
		
	}
	
	@Override
	public String toString() {
		return "FastestDelivery";
	}
	
	@Override 
	public Courier selectCourier(Order order) {
		MyFoodoraSystem system = MyFoodoraSystem.getInstance();
	    Courier chosenCourier = null;
	    for (Courier courier : system.getCouriers()) {
	    	if (courier.isOnDuty()) {
	    		if (order.getRestaurant.getLocation.distanceTo(courier.getPosition() < order.getRestaurant.getLocation.distanceTo(chosenCourier.getPosition()))){
	    			chosenCourier = courier; //Cette fois pas de comparaison dans le cas où la distance est égale car
	    									 //cela est bien moins probable, d'autant plus que les livreurs se déplace
	    		}
	    	}
	    }
	}
}
