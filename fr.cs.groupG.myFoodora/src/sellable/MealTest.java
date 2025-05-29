package sellable;

import java.util.ArrayList;
import java.util.List;

public class MealTest {

    public static void main(String[] args) {
        // Création de quelques plats
        Dish starter = new Dish("Salade", 5.0, true, true, "starter");
        Dish main = new Dish("Pâtes", 10.0, false, true, "main");
        Dish dessert = new Dish("Tarte", 4.0, true, false, "dessert");

        // Test 1 : Meal complet (entrée, plat, dessert)
        List<Dish> fullMealDishes = new ArrayList<>();
        fullMealDishes.add(starter);
        fullMealDishes.add(main);
        fullMealDishes.add(dessert);
        Meal fullMeal = new Meal("Menu Gourmand", fullMealDishes, false, 0.1);
        System.out.println(fullMeal.toString());

        System.out.println("Test 1 - fullMeal:");
        System.out.println("Meal size: " + fullMeal.getMealSize()); // fullMeal
        System.out.println("Meal type: " + fullMeal.getMealType());
        System.out.println("Meal price: " + fullMeal.getPrice());

        // Test 2 : Meal avec entrée + plat
        List<Dish> halfStarterDishes = new ArrayList<>();
        halfStarterDishes.add(starter);
        halfStarterDishes.add(main);
        Meal halfStarterMeal = new Meal("Menu Midi", halfStarterDishes, false, 0.2);

        System.out.println("\nTest 2 - halfMealStarter:");
        System.out.println("Meal size: " + halfStarterMeal.getMealSize()); // halfMealStarter
        System.out.println("Meal type: " + halfStarterMeal.getMealType());
        System.out.println("Meal price: " + halfStarterMeal.getPrice());

        // Test 3 : Meal invalide (2 desserts)
        List<Dish> invalidMealDishes = new ArrayList<>();
        invalidMealDishes.add(dessert);
        invalidMealDishes.add(dessert);
        Meal invalidMeal = new Meal("Menu Sucré", invalidMealDishes, false, 0);

        System.out.println("\nTest 3 - invalid meal:");
        System.out.println("Meal size: " + invalidMeal.getMealSize()); // invalid
        System.out.println("Meal type: " + invalidMeal.getMealType());
        System.out.println("Meal price: " + invalidMeal.getPrice());
    }
}
