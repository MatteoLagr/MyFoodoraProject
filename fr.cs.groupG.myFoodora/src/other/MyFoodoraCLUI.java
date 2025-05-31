package other;

import java.util.Scanner;

import sellable.Dish;
import users.Customer;
import users.Manager;
import users.Point2D;
import users.Restaurants;
import users.Users;
import users.Courier;

public class MyFoodoraCLUI {
	private MyFoodoraSystem system;
	private Scanner scanner;
	private Users currentUser;
	
	public MyFoodoraCLUI() {
        system = MyFoodoraSystem.getInstance(); // singleton
        scanner = new Scanner(System.in);
    }
	
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter the full path for the file .ini :");
	    String filePath = scanner.nextLine();

	    if (!filePath.endsWith(".ini")) {
	        System.out.println("WARNING : the path must end with '.ini'.");
	        return;  // on arrête le programme
	    }

	    try {
	    	MyFoodoraLoad.loadConfig(filePath);
	    } catch (Exception e) {
	        System.out.println("An error occurred while loading : " + e.getMessage());
	        return;
	    }

	    MyFoodoraCLUI clui = new MyFoodoraCLUI();
	    clui.start();
	}

	public void start() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Hello and welcome to MyFoodora! If you want to know the possible commands, type 'help'! ");

	    while (true) {
	        System.out.print("> ");
	        String input = scanner.nextLine();

	        if (input.trim().isEmpty()) {
	            continue; 
	        }

	        String[] parts = input.trim().split("\\s+"); 
	        String command = parts[0];
	        String[] commandArgs = new String[parts.length - 1];
	        System.arraycopy(parts, 1, commandArgs, 0, parts.length - 1);

	        try {
	            executeCommand(command, commandArgs);
	        } catch (Exception e) {
	            System.out.println("Erreur : " + e.getMessage());
	        }
	    }
	}


	
	public void executeCommand(String command, String[] args) {
		switch (command) {
	    case "login":
	        handleLogin(args);
	        break;
	    case "logout":
	        handleLogout(args);
	        break;
	    case "registerRestaurant":
	        handleRegisterRestaurant(args);
	        break;
	    case "registerCustomer":
	        handleRegisterCustomer(args);
	        break;
	    case "registerCourier":
	        handleRegisterCourier(args);
	        break;
	    case "addDishRestaurantMenu":
	        handleAddDishToRestaurantMenu(args);
	        break;
	    case "createMeal":
	        handleCreateMeal(args);
	        break;
	    case "addDish2Meal":
	        handleAddDishToMeal(args);
	        break;
	    case "showMeal":
	        handleShowMeal(args);
	        break;
	    case "saveMeal":
	        handleSaveMeal(args);
	        break;
	    case "setSpecialOffer":
	        handleSetSpecialOffer(args);
	        break;
	    case "removeFromSpecialOffer":
	        handleRemoveFromSpecialOffer(args);
	        break;
	    case "createOrder":
	        handleCreateOrder(args);
	        break;
	    case "addItem2Order":
	        handleAddItemToOrder(args);
	        break;
	    case "endOrder":
	        handleEndOrder(args);
	        break;
	    case "onDuty":
	        handleSetCourierOnDuty(args);
	        break;
	    case "offDuty":
	        handleSetCourierOffDuty(args);
	        break;
	    case "findDeliverer":
	        handleFindDeliverer(args);
	        break;
	    case "setDeliveryPolicy":
	        handleSetDeliveryPolicy(args);
	        break;
	    case "setProfitPolicy":
	        handleSetProfitPolicy(args);
	        break;
	    case "associateCard":
	        handleAssociateCard(args);
	        break;
	    case "showCourierDeliveries":
	        handleShowCourierDeliveries(args);
	        break;
	    case "showRestaurantTop":
	        handleShowRestaurantTop(args);
	        break;
	    case "showCustomers":
	        handleShowCustomers(args);
	        break;
	    case "showMenuItem":
	        handleShowMenuItem(args);
	        break;
	    case "showTotalProfit":
	        handleShowTotalProfit(args);
	        break;
	    case "runTest":
	        handleRunTest(args);
	        break;
	    case "help":
	        handleHelp(args);
	        break;
	    default:
	        System.out.println("Unrecognized command. If you want to know the possible commands, type 'help'! ");
		}
	}
	
	
	private void handleLogin(String[]args) {
		if (args.length != 2) {
			throw new IllegalArgumentException("Argument must take this form : login <username> <password>");
		}
		String username = args[0];
		String password = args[1];
		
		for (Customer customer : system.getCustomers()) {
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                System.out.println("Welcome, " + username + "!");
                this.currentUser = customer;
                return;
            }
        }

        for (Manager manager : system.getManagers()) {
            if (manager.getUsername().equals(username) && manager.getPassword().equals(password)) {
                System.out.println("Welcome, " + username + "!");
                this.currentUser = manager;
                return;
            }
        }

        for (Courier courier : system.getCouriers()) {
            if (courier.getUsername().equals(username) && courier.getPassword().equals(password)) {
                System.out.println("Welcome, " + username + "!");
                this.currentUser = courier;
                return;
            }
        }
        
        for(Restaurants restaurant : system.getRestaurants()) {
        	if(restaurant.getUsername().equals(username) && restaurant.getPassword().equals(password)) {
        		System.out.println("Welcome, " + username + "!");
        		this.currentUser = restaurant;
        		return;
        	}
        }       
        System.out.println("Error : incorrect username or password");		
	}
	
	private void handleLogout(String[] args) {
		if (this.currentUser == null) {
	        System.out.println("No user connected");
	        return;
	    }
		System.out.println("User \"" + currentUser.getUsername() + "\" is now disconnected");
		this.currentUser = null;
	}
	
	private void handleRegisterRestaurant(String[] args) {
		if (this.currentUser.getUserType() != "Manager") {
	    	System.out.println("You are not allowed do execute this command");
	    } else if (args.length == 4) {
	        String name = args[0];
	        String address = args[1];
	        String[] coords = address.split(",");
	        if (coords.length != 2) {
	            System.out.println("Error: invalid restaurant contact information : " + address);
	            return;
	        }
	        double x = Double.parseDouble(coords[0].trim());
	        double y = Double.parseDouble(coords[1].trim());
	        Point2D location = new Point2D(x, y);
	        String username = args[3];
	        String password = args[4];
	        Restaurants restaurant = new Restaurants(name, username, location, password);
	        system.addRestaurant(restaurant);
	    } else {
	        System.out.println("Error: 4 expected values for [registerRestaurant] (name, address, username, password)");
	    }
	}
	
	private void handleRegisterCustomer(String[] args) {
		if (this.currentUser.getUserType() != "Manager") {
	    	System.out.println("You are not allowed do execute this command");
		} else if (args.length == 5) {
			String name = args[0];
			String surname = args[1];
			String username = args[2];
			String locate = args[3];
			String password = args[4];
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
	        System.out.println("Error: 5 expected values for [registerCustomer] (firstName, lastName, username, address, password)");
	    }
	}
	
	private void handleRegisterCourier(String[] args) {
		if (this.currentUser.getUserType() != "Manager") {
	    	System.out.println("You are not allowed do execute this command");
		} else if (args.length == 5) {
			String name = args[0];
			String surname = args[1];
			String username = args[2];
			String locate = args[3];
			String password = args[4];
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
	        System.out.println("Error: 5 expected values for [registerCourier] (firstName, lastName, username, position, password)");
	    }
	}
	
	private void handleAddDishToRestaurantMenu(String[] args) {
		    if (!"Restaurant".equals(currentUser.getUserType())) {
		        System.out.println("Vous n'avez pas l'autorisation d'exécuter cette commande (réservée aux restaurants).");
		        return;
		    }

		    if (args.length != 4) {
		        System.out.println("Error: 5 expected values for [addDishRestaurantMenu] (restaurantName, dishName, dishCategory, foodCategory, unitPrice)");
		        return;
		    }

		    String name = args[0];
		    String category = args[1];
		    String foodCategory = args[2];
		    double price;

		    try {
		        price = Double.parseDouble(args[3]);
		    } catch (NumberFormatException e) {
		        System.out.println("Error on price : must be valid type.");
		        return;
		    }

		    boolean vegetarian = false;
		    boolean glutenFree = false;

		    if (foodCategory.equalsIgnoreCase("Vegetarian")) {
		        vegetarian = true;
		    } else if (foodCategory.equalsIgnoreCase("GlutenFree")) {
		        glutenFree = true;
		    } else if (!foodCategory.equalsIgnoreCase("Standard")) {
		        System.out.println("Error : foodCategory must be 'Standard', 'Vegetarian' or 'GlutenFree'.");
		        return;
		    }
		    
		    Dish dish = new Dish(name, price, vegetarian, glutenFree, category);
		    if (currentUser instanceof Restaurants) {
		        Restaurants restaurant = (Restaurants) currentUser;
		        restaurant.addDishMenu(dish);
		        System.out.println("Dish '" + name + "' has been added to the menu of the restaurant '" + restaurant.getName() + "'.");
		    } else {
		        System.out.println("Erreur interne : utilisateur non reconnu comme restaurant.");
		    }
		}
	
	private void handleCreateMeal(String[] args) {
		
	}
}
