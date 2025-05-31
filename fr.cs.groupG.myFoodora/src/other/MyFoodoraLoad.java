package other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sellable.Dish;
import sellable.Meal;
import users.Courier;
import users.Customer;
import users.Manager;
import users.Point2D;
import users.Restaurants;

public class MyFoodoraLoad {
	static MyFoodoraSystem system = MyFoodoraSystem.getInstance();
	
	public static void loadConfig(String filename) {
	    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
	        String line;
	        String currentSection = null;
	        ArrayList<String> currentValues = new ArrayList<>();

	        while ((line = br.readLine()) != null) {
	            line = line.trim();
	            if (line.isEmpty() || line.startsWith(";")) continue;


	            if (line.startsWith("[") && line.endsWith("]")) {

	                if (currentSection != null) {
	                    dispatchSection(currentSection, currentValues);
	                    currentValues.clear();
	                }
	                currentSection = line.substring(1, line.length() - 1);
	            } else {
	                String[] parts = line.split("=", 2);
	                if (parts.length == 2 && currentSection != null) {
	                    currentValues.add(parts[1].trim());
	                }
	            }
	        }

	        if (currentSection != null) {
	            dispatchSection(currentSection, currentValues);
	        }

	    } catch (IOException e) {
	        System.err.println("Erreur lors de la lecture du fichier config : " + e.getMessage());
	    }
	}

	private static void dispatchSection(String section, List<String> values) {
	    switch (section) {
	        case "Manager":    processManager(values); break;
	        case "Restaurant": processRestaurant(values); break;
	        case "Customer":   processCustomer(values); break;
	        case "Courier":    processCourier(values); break;
	        case "Dish":   processDish(values); break;
	        case "Meal":   processMeal(values); break;
	        default:
	            System.out.println("Section inconnue : " + section);
	    }
	}
	
	private static void processMeal(List<String> arguments) {
	    if (arguments.size() != 6) {
	        System.out.println("Error: 5 expected values for [Meal] : restaurantName, mealName, mealSize, starter, main, dessert");
	        return;
	    }
	    
	    String restaurantName = arguments.get(0);
	    String mealName = arguments.get(1);
	    String mealSize = arguments.get(2);
	    String starterName = arguments.get(3);
	    String mainName = arguments.get(4);
	    String dessertName = arguments.get(5);

	    for (Restaurants resto : MyFoodoraSystem.getInstance().getRestaurants()) {
	        if (resto.getName().equalsIgnoreCase(restaurantName)) {
	            Dish starter = "null".equalsIgnoreCase(starterName) ? null : resto.getDishFromMenu(starterName);
	            Dish main = "null".equalsIgnoreCase(mainName) ? null : resto.getDishFromMenu(mainName);
	            Dish dessert = "null".equalsIgnoreCase(dessertName) ? null : resto.getDishFromMenu(dessertName);

	            
	            if ("FullMeal".equalsIgnoreCase(mealSize)) {
	                if (starter == null || main == null || dessert == null) {
	                    System.out.println("Error : FullMeal not complete (" + mealName + ")");
	                    return;
	                }
	                List<Dish> dishes = new ArrayList<>();
	                dishes.add(starter);
	                dishes.add(main);
	                dishes.add(dessert);
	                Meal fullMeal = new Meal(mealName, dishes);
	                resto.addMeal(fullMeal);
	                System.out.println("FullMeal " + mealName + "added to " + restaurantName);
	                return;

	            } else if ("HalfMeal".equalsIgnoreCase(mealSize)) {
	                if ((starter == null && dessert == null) || main == null) {
	                    System.out.println("Error : HalfMeal not valid. it needs a  main + started **or** dessert.");
	                    return;
	                }
	                List<Dish> dishes = new ArrayList<>();
	                dishes.add(starter);
	                dishes.add(main);
	                dishes.add(dessert);
	                Meal halfMeal = new Meal(mealName, dishes); 
	                resto.addMeal(halfMeal);
	                System.out.println("HalfMeal " + mealName + " added to " + restaurantName);
	                return;

	            } else {
	                System.out.println("Error : mealSize not valid. Expected : 'FullMeal' or 'HalfMeal'");
	                return;
	            }
	        }
	    }

	    System.out.println("Restaurant '" + restaurantName + "' not found.");
	}

	
	
	private static void processDish(List<String> arguments) {
		if (arguments.size() == 5) {
			String restaurantName = arguments.get(0);
			String name = arguments.get(1);
			String category = arguments.get(2);
			boolean vegetarian = false; 
			boolean glutenFree = false;
			String foodCategory = arguments.get(3);
			if (foodCategory.equalsIgnoreCase("Vegetarian")) {
			    vegetarian = true;
			} else if (foodCategory.equalsIgnoreCase("GlutenFree")) {
			    glutenFree = true;
			}
			double price = Double.parseDouble(arguments.get(4));
			Dish dish = new Dish(name, price, vegetarian, glutenFree, category);
			
			boolean found = false;
			for (Restaurants restaurant : system.getRestaurants()) {
				if (restaurant.getName().equalsIgnoreCase(restaurantName)) {
					restaurant.addDishMenu(dish);
					found = true;
					break;
				}
			}
			if (!found) {
	            System.out.println(" Restaurant '" + restaurantName + "' not found.");
	        }
		} else {
	        System.out.println("Error: 5 expected values for [Dish] (restaurantName, dishName, dishCategory, foodCategory, unitPrice)");
	    }
	}
	
	
	private static void processCourier(List<String> arguments) {
		if (arguments.size() == 5) {
			String name = arguments.get(0);
			String surname = arguments.get(1);
			String username = arguments.get(2);
			String locate = arguments.get(3);
			String password = arguments.get(4);
			String[] coords = locate.split(",");
	        if (coords.length != 2) {
	            System.out.println("Error: invalid courier contact information : " + locate);
	            return;
	        }
	        double x = Double.parseDouble(coords[0].trim());
	        double y = Double.parseDouble(coords[1].trim());
	        Point2D location = new Point2D(x, y);
			Courier courier = new Courier(name, surname, username, location, password);
			system.addCourier(courier);
		} else {
	        System.out.println("Error: 5 expected values for [Courier] (firstName, lastName, username, location, password)");
	    }
	}
	
	private static void processCustomer(List<String> arguments) {
		if (arguments.size() == 5) {
			String name = arguments.get(0);
			String surname = arguments.get(1);
			String username = arguments.get(2);
			String locate = arguments.get(3);
			String password = arguments.get(4);
			String[] coords = locate.split(",");
	        if (coords.length != 2) {
	            System.out.println("Error: invalid customer contact information : " + locate);
	            return;
	        }
	        double x = Double.parseDouble(coords[0].trim());
	        double y = Double.parseDouble(coords[1].trim());
	        Point2D address = new Point2D(x, y);
			Customer customer = new Customer(name, surname, username, address, password);
			system.addCustomer(customer);
		} else {
	        System.out.println("Error: 5 expected values for [Customer] (firstName, lastName, username, address, password)");
	    }
	}
	
	private static void processManager(List<String> arguments) {
		if (arguments.size() == 4) {
			String name = arguments.get(0);
			String surname = arguments.get(1);
			String username = arguments.get(2);
			String password = arguments.get(3);
			Manager manager = new Manager(name, surname, username, password);
			system.addManager(manager);						
		}	else {
	        System.out.println("Error: 4 expected values for [Manager] (name, surname, username, password)");
	    }
	}
	
	
	private static void processRestaurant(List<String> arguments) {
	    if (arguments.size() == 4) {
	        String name = arguments.get(0);
	        String address = arguments.get(1);
	        String[] coords = address.split(",");
	        if (coords.length != 2) {
	            System.out.println("Error: invalid restaurant contact information : " + address);
	            return;
	        }
	        double x = Double.parseDouble(coords[0].trim());
	        double y = Double.parseDouble(coords[1].trim());
	        Point2D location = new Point2D(x, y);
	        String username = arguments.get(2);
	        String password = arguments.get(3);
	        Restaurants restaurant = new Restaurants(name, username, location, password);
	        system.addRestaurant(restaurant);
	    } else {
	        System.out.println("Error: 4 expected values for [Restaurant] (name, address, username, password)");
	    }
	}


	


}
