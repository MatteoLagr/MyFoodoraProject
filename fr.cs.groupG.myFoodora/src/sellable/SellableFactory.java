package sellable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import other.AbstractFactory;
import deliverypolicies.DeliveryPolicies;
import fidelitycard.FidelityCards;
import sortingpolicies.ShippedOrderSortingPolicies;
import targetprofitpolicies.TargetProfitPolicies;
import users.Users;

public class SellableFactory extends AbstractFactory {
    private List<Dish> dishes;
    private List<Meal> meals;

    public SellableFactory(List<Dish> dishes, List<Meal> meals) {
        // Null safety: on utilise une liste vide si l'argument est null
        this.dishes = (dishes != null) ? dishes : Collections.emptyList();
        this.meals = (meals != null) ? meals : Collections.emptyList();
    }

    @Override
    public Sellable getSellable(String sellableType) {
        if (sellableType == null || sellableType.trim().isEmpty()) {
            throw new IllegalArgumentException("sellableType must not be null or empty");
        }

        for (Dish dish : dishes) {
            if (dish.getSellableType().equalsIgnoreCase(sellableType)) {
                return new Dish(
                    dish.getName(),
                    dish.getPrice(),
                    dish.isVegetarian(),
                    dish.isGlutenFree(),
                    dish.getCategory()
                );
            }
        }

        for (Meal meal : meals) {
            if (meal.getSellableType().equalsIgnoreCase(sellableType)) {
                return new Meal(
                    meal.getName(),
                    meal.getDishes(),
                    meal.isMealOfWeek(),
                    meal.getDiscountPercentage()
                );
            }
        }

        throw new IllegalArgumentException("Unknown sellable type: " + sellableType);
    }

    @Override
    public Users getUser(String userType) {
        throw new UnsupportedOperationException("Not supported by SellableFactory");
    }

    @Override
    public TargetProfitPolicies getTargetProfitPolicies(String targetProfitPoliciesType) {
        throw new UnsupportedOperationException("Not supported by SellableFactory");
    }

    @Override
    public DeliveryPolicies getDeliveryPolicies(String deliveryPoliciesType) {
        throw new UnsupportedOperationException("Not supported by SellableFactory");
    }

    @Override
    public ShippedOrderSortingPolicies getSortingPolicies(String sortingPoliciesType) {
        throw new UnsupportedOperationException("Not supported by SellableFactory");
    }

    @Override
    public FidelityCards getFidelityCards(String fidelityCardType) {
        throw new UnsupportedOperationException("Not supported by SellableFactory");
    }
}
