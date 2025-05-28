package sellable;

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
	
	// getters
	
	public List<Dish> getStarters(){
		return starters;
	}
	
	public List<Dish> getMainDishes(){
		return mainDishes;
	}
	
	public List<Dish> getDesserts(){
		return desserts;
	}
	
	
	
	//////////////////
	public List<Dish> getAllDishes(){
		return starters;
	}
	
	public void addDish(Dish dish) {
		
	}
	
	public void removeDish(Dish dish) {
		
	}

}
