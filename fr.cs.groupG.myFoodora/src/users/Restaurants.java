package users;

import java.util.ArrayList;
import java.util.List;

import other.Observable;
import other.Observer;
import sellable.Dish;
import sellable.Meal;
import sellable.Menu;

public class Restaurants extends Users implements Observable{
	
	private Point2D location;
	private Menu menu;
	private List<Meal> meals;
	private double genericDiscount;
	private double specialDiscount;
	private Meal mealOfWeek;
	private boolean newMealOfWeek;
	private Observer observer;
	//private ArrayList<Observer> observers = new ArrayList<Observer>();
	
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
		this.menu = new Menu(new ArrayList<Dish>(),new ArrayList<Dish>(),new ArrayList<Dish>());
		this.meals = new ArrayList<Meal>();
		this.genericDiscount = 0.05;
		this.specialDiscount = 0.1;
	}
	
	public Restaurants(String name, String username, int id, String surname, String password) {
		super(name, username, id, surname,password);
		this.location = null;
		this.menu = new Menu(new ArrayList<Dish>(),new ArrayList<Dish>(),new ArrayList<Dish>());
		this.meals = new ArrayList<Meal>();
		this.genericDiscount = 0.05;
		this.specialDiscount = 0.1;
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
		this.newMealOfWeek = true;
		this.notifyObserver();
	}
	
	public Observer getObserver(){
		return observer;
	}
	
	public void setObservers(Observer observer) {
		this.observer = observer;
	}
	
	
	public void addDishMenu(Dish dish) {
		menu.addDish(dish);
	}
	
	public void removeDishMenu(Dish dish) {
		menu.removeDish(dish);
	}
	
	public void addMeal(Meal meal) {
		if (!meals.contains(meal)) {
			meals.add(meal);
		}
	}
	
	public void removeMeal(Meal meal) {
		if (meals.contains(meal)) {
			meals.remove(meal);
		}
	}
	
	public Meal createMeal(String name,List<Dish> dishes) {
		Meal meal = new Meal(name,dishes,false,genericDiscount);
		if (!meals.contains(meal)) {
			meals.add(meal);
		}
		return meal;
	}
	
	/**
	@Override
	public void registerObserver(Observer obs) {
		observer.add(obs);
	}
	
	@Override 
	public void removeObserver(Observer obs) {
		observer.remove(obs);
	}
	*/
	
	/**
	@Override 
	public void notifyObserver() {
		if (this.newMealOfWeek) {
			for (Observer observer : observers) {
				observer.update(this,this.mealOfWeek);
			}
			this.newMealOfWeek = false;
			}		
		}
	*/
	
	@Override
	public void notifyObserver() {
	    if (this.newMealOfWeek && observer != null) {
	        observer.update(this, this.mealOfWeek);
	        this.newMealOfWeek = false;
	    }
	}
}
