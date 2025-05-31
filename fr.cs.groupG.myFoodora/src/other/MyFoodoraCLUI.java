package other;

import java.util.Scanner;

public class MyFoodoraCLUI {
	private MyFoodoraSystem system;
	private Scanner scanner;
	
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
	    case "addDishRestauarantMenu":
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

}
