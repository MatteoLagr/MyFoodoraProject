package deliverypolicies;

import other.Order;
import users.Courier;

public interface DeliveryPolicies {
	
	public Courier selectCourier(Order order);
	public String getDeliveryPolicyType();

}
