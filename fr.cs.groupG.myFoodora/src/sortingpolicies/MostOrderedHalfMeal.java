package sortingpolicies;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import other.MyFoodoraSystem;
import other.Order;
import other.OrderItem;
import sellable.Meal;
import sellable.Sellable;

public class MostOrderedHalfMeal {
	
	public List<Sellable> sortItems() {
	    ArrayList<OrderItem> orderItemHistory = new ArrayList<>();

	    MyFoodoraSystem system = MyFoodoraSystem.getInstance();
	    ArrayList<Order> orderHistory = system.getOrderHistory();

	    for (Order order : orderHistory) {
	        for (OrderItem orderItem : order.getItems()) {
	            orderItemHistory.add(orderItem);
	        }
	    }

	    ArrayList<OrderItem> orderItemHistoryHalfMeal = new ArrayList<>();
	    for (OrderItem orderItem : orderItemHistory) {
	        if (orderItem.getItem().getSellableType().equalsIgnoreCase("meal")) {
	            Meal meal = (Meal) orderItem.getItem();
	            String size = meal.getMealSize();
	            if ("halfMealStarter".equals(size) || "halfMealDessert".equals(size)) {
	                orderItemHistoryHalfMeal.add(new OrderItem(meal, orderItem.getQuantity(), orderItem.getPriceUnit()));
	            }
	        }
	    }

	    ArrayList<OrderItem> countedOrderItems = new ArrayList<>();
	    for (OrderItem orderItem : orderItemHistoryHalfMeal) {
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

	    // Tri décroissant (quantité la plus grande en premier)
	    countedOrderItems.sort(Comparator.comparingInt(OrderItem::getQuantity).reversed());

	    List<Sellable> sortedSellables = new ArrayList<>();
	    for (OrderItem orderItem : countedOrderItems) {
	        sortedSellables.add(orderItem.getItem());
	    }

	    return sortedSellables;
	}
}
