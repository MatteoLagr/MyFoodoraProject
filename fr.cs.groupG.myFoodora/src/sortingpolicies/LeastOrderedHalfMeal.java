package sortingpolicies;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import other.MyFoodoraSystem;
import other.Order;
import other.OrderItem;
import sellable.Meal;
import sellable.Sellable;

public class LeastOrderedHalfMeal {

    public List<Sellable> sortItems() {
        ArrayList<OrderItem> orderItemHistory = new ArrayList<>();

        MyFoodoraSystem system = MyFoodoraSystem.getInstance();
        ArrayList<Order> orderHistory = system.getOrderHistory();

        // Récupérer tous les orderItems de toutes les commandes
        for (Order order : orderHistory) {
            for (OrderItem orderItem : order.getItems()) {
                orderItemHistory.add(orderItem);
            }
        }

        // Filtrer uniquement les meals half meal ("halfMealStarter" ou "halfMealDessert") avec copie
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

        // Compter la quantité totale vendue par meal
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
