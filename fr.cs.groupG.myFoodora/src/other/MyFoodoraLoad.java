package other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class MyFoodoraLoad {
	
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
	        case "MenuItem":   processMenuItem(values); break;
	        case "HalfMeal":   processHalfMeal(values); break;
	        case "FullMeal":   processFullMeal(values); break;
	        default:
	            System.out.println("Section inconnue : " + section);
	    }
	}
	
	
	


}
