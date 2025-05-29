package sellable;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	
	private List<Dish> starters;
	private List<Dish> mainDishes;
	private List<Dish> desserts;
	
	// Constructeur 
	
	public Menu(List<Dish> starters, List<Dish> mainDishes,List<Dish> desserts) {
		this.starters = starters;
		this.mainDishes = mainDishes;
		this.desserts = desserts;
	}
	
	public List<Dish> getStarters() { return starters; }
	public List<Dish> getMainDishes() { return mainDishes; }
	public List<Dish> getDesserts() { return desserts; }
	
	
	//////////////////
	public List<Dish> getAllDishes() {
	    List<Dish> allDishes = new ArrayList<>();
	    allDishes.addAll(starters);
	    allDishes.addAll(mainDishes);
	    allDishes.addAll(desserts);
	    return allDishes;
	}
	
	public void addDish(Dish dish) {
		String dishCategory = dish.getCategory();
		if (dishCategory == "starter") {starters.add(dish);} // j'en suis ici, finir de compléter
	}
	
	public void removeDish(Dish dish) {
		
	}

	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("=== Menu ===\n");

	    sb.append("\nStarters:\n");
	    if (starters.isEmpty()) sb.append("  (none)\n");
	    for (Dish dish : starters) {
	        sb.append("  - ").append(dish.getName()).append(" (")
	          .append(String.format("%.2f", dish.getPrice())).append(" €, ")
	          .append(dish.isVegetarian() ? "Vegetarian" : "Non-Vegetarian").append(", ")
	          .append(dish.isGlutenFree() ? "Gluten Free" : "Contains Gluten").append(")\n");
	    }

	    sb.append("\nMain Dishes:\n");
	    if (mainDishes.isEmpty()) sb.append("  (none)\n");
	    for (Dish dish : mainDishes) {
	        sb.append("  - ").append(dish.getName()).append(" (")
	          .append(String.format("%.2f", dish.getPrice())).append(" €, ")
	          .append(dish.isVegetarian() ? "Vegetarian" : "Non-Vegetarian").append(", ")
	          .append(dish.isGlutenFree() ? "Gluten Free" : "Contains Gluten").append(")\n");
	    }

	    sb.append("\nDesserts:\n");
	    if (desserts.isEmpty()) sb.append("  (none)\n");
	    for (Dish dish : desserts) {
	        sb.append("  - ").append(dish.getName()).append(" (")
	          .append(String.format("%.2f", dish.getPrice())).append(" €, ")
	          .append(dish.isVegetarian() ? "Vegetarian" : "Non-Vegetarian").append(", ")
	          .append(dish.isGlutenFree() ? "Gluten Free" : "Contains Gluten").append(")\n");
	    }

	    return sb.toString();
	}

	
}
