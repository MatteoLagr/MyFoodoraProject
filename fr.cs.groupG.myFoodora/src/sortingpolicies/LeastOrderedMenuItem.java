package sortingpolicies;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import other.MyFoodoraSystem;
import other.Order;
import other.OrderItem;
import sellable.Sellable;

public class LeastOrderedMenuItem {
	
	public List<Sellable> sortItems(){
		ArrayList<OrderItem> orderItemHistory = new ArrayList<>();
		
		MyFoodoraSystem system = MyFoodoraSystem.getInstance();
		ArrayList<Order> orderHistory = system.getOrderHistory();
		
		// Récupérer tous les orderItems de toutes les commandes
		for (Order order : orderHistory) {
			for (OrderItem orderItem : order.getItems()) {
				orderItemHistory.add(orderItem);
			}
		}
		
		// Filtrer uniquement les plats ("dish") avec une copie pour ne pas modifier l'original
		ArrayList<OrderItem> orderItemHistoryDish = new ArrayList<>();
		for (OrderItem orderItem : orderItemHistory) {
			if (orderItem.getItem().getSellableType().equalsIgnoreCase("dish")) {
				orderItemHistoryDish.add(new OrderItem(orderItem.getItem(), orderItem.getQuantity(), orderItem.getPriceUnit()));
			}
		}
		
		// Compter la quantité totale vendue par plat
		ArrayList<OrderItem> countedOrderItems = new ArrayList<>();
		for (OrderItem orderItem : orderItemHistoryDish) {
			boolean found = false;
			for (OrderItem counted : countedOrderItems) {
				if (counted.getItem().equals(orderItem.getItem())) {
					counted.setQuantity(counted.getQuantity() + orderItem.getQuantity());
					found = true;
					break;
				}
			}
			if (!found) {
				countedOrderItems.add(orderItem);
			}
		}
		
		// Trier par quantité croissante (le moins vendu en premier)
		countedOrderItems.sort(Comparator.comparingInt(OrderItem::getQuantity));
		
		// Extraire la liste des Sellable triée
		List<Sellable> sortedSellables = new ArrayList<>();
		for (OrderItem orderItem : countedOrderItems) {
			sortedSellables.add(orderItem.getItem());
		}
		
		return sortedSellables;
	}
}
