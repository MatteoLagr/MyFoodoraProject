package other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	        case "Menu":   processMenu(values); break;
	        default:
	            System.out.println("Section inconnue : " + section);
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
	            System.out.println("Error: invalid restaurant contact information : " + locate);
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
