package sellable;

public class Dish implements Sellable{

	private String name;
	private double price;
	private boolean vegetarian;
	private boolean glutenFree;
	private String category;
	
// Constructeur
	public Dish(String name,double price, boolean vegetarian, boolean glutenFree, String category) {
		this.name = name;
		this.price = price;
		this.vegetarian = vegetarian;
		this.glutenFree = glutenFree;
		this.category = category;
	}
	
// Getters
	public String getName() {
		return name ;
	}
	
	public double getPrice() {
		return price;
	}
	
		
	public String getCategory() {
		return category;
	}
	
// Setters 
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
	    return "Dish{" +
	            "name='" + name + '\'' +
	            ", price=" + price +
	            ", vegetarian=" + vegetarian +
	            ", glutenFree=" + glutenFree +
	            ", category='" + category + '\'' +
	            '}';
	}
	
	/////////////////////////////////////////////////////////////////
	
	public boolean isVegetarian() {
		return vegetarian;
	}
	
	public boolean isGlutenFree() {
		return glutenFree;
	}
	
	public boolean isStandard() {
		boolean notStandard = this.isVegetarian() && this.isGlutenFree();
		return !notStandard;
	}
	
	@Override
	public String getSellableType() {
		return "dish";
	}
}
