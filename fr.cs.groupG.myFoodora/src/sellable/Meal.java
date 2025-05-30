package sellable;


import java.util.List;

public class Meal implements Sellable {

	private String name;
	private List<Dish> dishes;
	private String mealType;
	private String mealSize;
	private boolean mealOfWeek;
	private double discountPercentage;
	private double priceMeal;
	
	
	
	
	
	// Getters
	public String getName() { return name; }
	public List<Dish> getDishes() { return dishes; }
	public String getMealType() { return mealType; }
	public String getMealSize() { return mealSize; }
	public boolean isMealOfWeek() { return mealOfWeek; }
	public double getPrice() { return priceMeal; }
	public double getDiscountPercentage() { return discountPercentage; }
	public double getPriceMeal() { return priceMeal; }

	// Setters
	public void setMealOfWeek(boolean mealOfWeek) { this.mealOfWeek = mealOfWeek; }
	public void setDiscountPercentage(double discountPercentage) { this.discountPercentage = discountPercentage; }

	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////
	public String defineMealType(List<Dish> dishes) {
		final int nbDishes = dishes.size();
		boolean vege = true;
		boolean glutenfree = true; // exprès de pas mettre de majuscule
		
		for (Dish dish : dishes) {
		    vege = vege && dish.isVegetarian();
		    glutenfree = glutenfree && dish.isGlutenFree();
		}
		
		if (vege && !glutenfree) {return "This is a Vegetarian Meal";}
		else if (!vege && glutenfree) {return "This is a Gluten Free Meal";}
		else if (vege && glutenfree) {return "This is a Vegetarian and Gluten Free Meal";}
		else {return "This is a Standard Meal (not Vegetarian nor Gluten Free)";}
	}
	
	
	public String defineMealSize(List<Dish> dishes) {
	    boolean starter = false, mainDish = false, dessert = false;
	    for (Dish dish : dishes) {
	        String c = dish.getCategory();
	        if (c.equals("starter")) starter = true;
	        else if (c.equals("main")) mainDish = true;
	        else if (c.equals("dessert")) dessert = true;
	    }
	    int count = (starter ? 1 : 0) + (mainDish ? 1 : 0) + (dessert ? 1 : 0);
	    if (dishes.size() != 2 && dishes.size() != 3) return "invalid Meal : a meal must contain 2 or 3 dishes";
	    if (!mainDish) return "invalid Meal : a meal must contain a main dish";
	    if (dishes.size() == 3) return count == 3 ? "fullMeal" : "invalid Meal : a 3-dish meal must contain starter, main and dessert";
	    if (count == 2) return starter ? "halfMealStarter" : dessert ? "halfMealDessert" : "invalid Meal : a 2-dish meal must contain starter or dessert besides main";
	    return "invalid Meal : a 2-dish meal must contain exactly two categories";
	}
	
	public double computeMealPrice(List<Dish> dishes) {
		double priceSumDishes = 0;
		for (Dish dish : dishes) {priceSumDishes += dish.getPrice();}
		return priceSumDishes * (1-this.getDiscountPercentage());
	}

	
	// On va construire dynamiquement price, priceMeal, mealSize, mealType donc penser à mettre les méthodes
	
	
	
	// Constructeur
		public Meal(String name, List<Dish> dishes,boolean mealOfWeek, double discountPercentage) {
			this.name = name;
			this.dishes = dishes;
			this.mealOfWeek = mealOfWeek;
			this.discountPercentage = discountPercentage;
			this.mealSize = defineMealSize(dishes);
			this.mealType = defineMealType(dishes);
			this.priceMeal = computeMealPrice(dishes);
		}
		
	// Méthode toString d'affichage du Meal
		@Override
		public String toString() {
		    StringBuilder sb = new StringBuilder();
		    sb.append("=== Meal Summary ===\n");
		    sb.append("Name           : ").append(name).append("\n");
		    sb.append("Meal Size      : ").append(mealSize).append("\n");
		    sb.append("Meal Type      : ").append(mealType).append("\n");
		    sb.append("Meal of Week   : ").append(mealOfWeek ? "Yes" : "No").append("\n");
		    sb.append("Discount       : ").append(discountPercentage * 100).append("%\n");
		    sb.append("Total Price    : ").append(String.format("%.2f", priceMeal)).append(" €\n");
		    sb.append("Dishes         :\n");

		    for (Dish dish : dishes) {
		        sb.append("  - ").append(dish.getName())
		          .append(" (").append(dish.getCategory()).append(", ")
		          .append(String.format("%.2f", dish.getPrice())).append(" €, ")
		          .append(dish.isVegetarian() ? "Vegetarian" : "Non-Vegetarian").append(", ")
		          .append(dish.isGlutenFree() ? "Gluten Free" : "Contains Gluten")
		          .append(")\n");
		    }

		    return sb.toString();}

		@Override
		public String getSellableType() {
			return "meal";
		}
}
