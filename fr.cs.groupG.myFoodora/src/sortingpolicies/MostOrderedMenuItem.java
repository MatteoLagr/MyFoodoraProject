package sortingpolicies;

import java.util.ArrayList;
import java.util.List;

import other.MyFoodoraSystem;
import other.Order;
import other.OrderItem;
import sellable.Sellable;

public class MostOrderedMenuItem {

    public List<Sellable> sortItems() {
        ArrayList<OrderItem> orderItemHistory = new ArrayList<>();

        MyFoodoraSystem system = MyFoodoraSystem.getInstance();
        ArrayList<Order> orderHistory = system.getOrderHistory();
        for (Order order : orderHistory) {
            orderItemHistory.addAll(order.getItems());
        }

        // Filtrer les plats (dish uniquement)
        ArrayList<OrderItem> orderItemHistoryDish = new ArrayList<>();
        for (OrderItem orderItem : orderItemHistory) {
            if (orderItem.getItem().getSellableType().equalsIgnoreCase("dish")) {
                orderItemHistoryDish.add(new OrderItem(
                    orderItem.getItem(),
                    orderItem.getQuantity(),
                    orderItem.getPriceUnit()
                ));
            }
        }

        // Regrouper les quantités par plat
        ArrayList<OrderItem> countOrderItemHistoryDish = new ArrayList<>();
        for (OrderItem orderItem : orderItemHistoryDish) {
            boolean found = false;
            for (OrderItem countedItem : countOrderItemHistoryDish) {
                if (countedItem.getItem().equals(orderItem.getItem())) {
                    countedItem.setQuantity(countedItem.getQuantity() + orderItem.getQuantity());
                    found = true;
                    break;
                }
            }
            if (!found) {
                countOrderItemHistoryDish.add(new OrderItem(
                    orderItem.getItem(),
                    orderItem.getQuantity(),
                    orderItem.getPriceUnit()
                ));
            }
        }

        // Trier par quantité décroissante
        countOrderItemHistoryDish.sort((o1, o2) -> Integer.compare(o2.getQuantity(), o1.getQuantity()));

        // Extraire les Sellable triés
        ArrayList<Sellable> sortedDishes = new ArrayList<>();
        for (OrderItem item : countOrderItemHistoryDish) {
            sortedDishes.add(item.getItem());
        }

        return sortedDishes;
    }
}




