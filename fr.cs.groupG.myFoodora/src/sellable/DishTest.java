package sellable;

public class DishTest {
	
	public static void main(String[] args) {
		Dish dish1 = new Dish("pate",12,true,false,"mainDish");
		Dish dish2 = new Dish("pizza",9.99,false,false,"starter");
		
		System.out.println(dish1);
		System.out.println(dish2);
		
		dish1.getCategory();
		
		dish2.setPrice(12.90);
		
		System.out.println(dish1.isGlutenFree());
		
		System.out.print(dish1.isStandard());
		
		System.out.print(dish2.isStandard());
	}

}
