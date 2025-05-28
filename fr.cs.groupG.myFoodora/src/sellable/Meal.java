package sellable;


import java.util.List;

public class Meal implements Sellable {

	private String name;
	private List<Dish> dishes;
	private String mealType;
	private String mealSize;
	private boolean mealOfWeek;
	private double price;
	private double discountPercentage;
	private double priceMeal;
	
	
	// Constructeur
	public Meal(String name, List<Dish> dishes,String mealType, String mealSize,boolean mealOfWeek, double price, double discountPercentage,double priceMeal) {
		this.name = name;
		this.dishes = dishes;
		this.mealOfWeek = mealOfWeek;
		this.discountPercentage = discountPercentage;
	}
	
	
	//getters
	public String getName() {
		return name;
	}
	
	public List<Dish> getDishes(){
		return dishes;
	}
	
	public String getMealType() {
		return mealType;
	}
	
	public String getMealSize() {
		return mealSize;
	}
	
	public boolean getMealOfWeek() {
		return mealOfWeek;
	}
	
	public double getPrice() {
		return price;
	}
	
	private double getDiscountPercentage() {
		return discountPercentage;
	}
	
	private double getPriceMeal() {
		return priceMeal;
	}
	
	
	// Setters
	public void setMealOfWeek() {
		this.mealOfWeek = mealOfWeek;
	}
	
	public void discountPercentage() {
		this.discountPercentage = discountPercentage;
	}
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////
	public String defineMealType(List<Dish> dishes) {
		return "à def";
	}
	
	public String defineMealSize(List<Dish> dishes) {
		return "à def";
	}
	
	// On va construire dynamiquement price, priceMeal, mealSize, mealType donc penser à mettre les méthodes
}
