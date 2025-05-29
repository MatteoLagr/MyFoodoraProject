package fidelitycard;

import other.Order;

public interface FidelityCards {
	public double getNormalPrice(Order order);
	public double computeFidelityPrice(Order order);

}
