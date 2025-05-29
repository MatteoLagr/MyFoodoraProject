package users;

import java.util.List;

import sellable.Meal;
import sellable.Menu;

public class Restaurants extends Users{
	
	private Point2D location;
	private Menu menu;
	private List<Meal> meals;
	private double genericDiscount;
	private double specialDiscount;
	private Meal mealOfWeek;
	
	public Restaurants(String name, String username, int id, String password, Point2D location, Menu menu, List<Meal> meals, double genericDiscount, double specialDiscount, Meal mealOfWeek) {
		super(name, username, id, "", password); //Les restaurants n'ont pas de username
	    this.location = location;
	    this.menu = menu;
	    this.meals = meals;
	    this.genericDiscount = genericDiscount;
	    this.specialDiscount = specialDiscount;
	    this.mealOfWeek = mealOfWeek;
	}
	
	public Restaurants(String name, String username, int id, Point2D location) {
		super(name, username, id, "","");
		this.location = location;
		this.menu = new Menu();
		this.meals = new ArrayList<Meal>();
		this.genericDiscount = 0.05;
		this.specialDiscount = 0.1;
		this.mealOfWeek = new Meal();
	}
	
	
	@Override
	public String getUserType() {
		return "Restaurant";
	}
	
	public Point2D getLocation() {
		return location;
	}
	public void setLocation(Point2D location) {
		this.location = location;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public List<Meal> getMeals() {
		return meals;
	}
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
	public double getGenericDiscount() {
		return genericDiscount;
	}
	public void setGenericDiscount(double genericDiscount) {
		this.genericDiscount = genericDiscount;
	}
	public double getSpecialDiscount() {
		return specialDiscount;
	}
	public void setSpecialDiscount(double specialDiscount) {
		this.specialDiscount = specialDiscount;
	}
	public Meal getMealOfWeek() {
		return mealOfWeek;
	}
	public void setMealOfWeek(Meal mealOfWeek) {
		this.mealOfWeek = mealOfWeek;
	}
	
	
	// notificationManager : NotificationManager
	
	
	
	public void addDishMenu(Dish dish) {
		
	}
	
	public void removeDishMenu(Dish dish) {
		
	}
	
	public void addMeal(Meal meal) {
		
	}
	
	public void removeMeal(Meal meal) {
		
	}
	
	public Meal createMeal(String name,List<Dish> dishes) {
		
	}
	
	

}
