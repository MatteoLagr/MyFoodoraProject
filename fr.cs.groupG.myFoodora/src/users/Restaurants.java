package users;

import java.util.List;

import sellable.Meal;
import sellable.Menu;

public class Restaurants {
	
	private Point2D location;
	private Menu menu;
	private List<Meal> meals;
	private double genericDiscount;
	private double specialDiscount;
	private Meal mealOfWeek;
	
	
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
	
	public Restaurants(Point2D location, Menu menu, List<Meal> meals, double genericDiscount, double specialDiscount, Meal mealOfWeek) {
	    this.location = location;
	    this.menu = menu;
	    this.meals = meals;
	    this.genericDiscount = genericDiscount;
	    this.specialDiscount = specialDiscount;
	    this.mealOfWeek = mealOfWeek;
	}
	
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
