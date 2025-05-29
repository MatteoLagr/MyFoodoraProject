package fidelitycard;

import other.Order;

public interface FidelityCards {
	public double getNormalPrice(Order order);
	public double computeFidelityPrice(Order order);
	public String getTypeOfCard(); //J'ai ajouté ça pour pouvoir l'utiliser dans Order pour appliquer les discounts des cartes

}
