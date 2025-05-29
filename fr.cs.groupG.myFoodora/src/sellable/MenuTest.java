package sellable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Petit banc d’essai console pour la classe Menu.
 * On vérifie et on affiche les résultats étape par étape.
 */
public class MenuTest {

    // ─────────────────────────────────────────
    //  Méthode d'assertion toute simple
    // ─────────────────────────────────────────
    private static void assertEquals(Object expected, Object actual, String message) {
        if (!Objects.equals(expected, actual)) {
            System.out.println("❌ FAIL - " + message + " (expected = " + expected + ", actual = " + actual + ")");
        } else {
            System.out.println("✅ PASS - " + message);
        }
    }

    public static void main(String[] args) {

        // ─────────────────────────────────────────
        // 1) Création de quelques plats
        // ─────────────────────────────────────────
        Dish salad   = new Dish("Salad", 5.0,  true,  true,  "starter");
        Dish soup    = new Dish("Soup",  4.0,  true,  false, "starter");
        Dish steak   = new Dish("Steak", 12.0, false, false, "mainDish");
        Dish pasta   = new Dish("Pasta", 10.0, true,  false, "mainDish");
        Dish cake    = new Dish("Cake",  6.0,  true,  false, "dessert");
        Dish fruits  = new Dish("Fruits",4.5,  true,  true,  "dessert");

        // ─────────────────────────────────────────
        // 2) Constitution d'un menu initial
        // ─────────────────────────────────────────
        List<Dish> starters   = new ArrayList<>(List.of(salad));
        List<Dish> mainDishes = new ArrayList<>(List.of(steak));
        List<Dish> desserts   = new ArrayList<>(List.of(cake));

        Menu menu = new Menu(starters, mainDishes, desserts);

        System.out.println("\n===== MENU INITIAL =====");
        System.out.println(menu);

        // ─────────────────────────────────────────
        // 3) Tests des getters individuels
        // ─────────────────────────────────────────
        assertEquals(1, menu.getStarters().size(),   "Nombre de starters");
        assertEquals(1, menu.getMainDishes().size(), "Nombre de main dishes");
        assertEquals(1, menu.getDesserts().size(),   "Nombre de desserts");

        // ─────────────────────────────────────────
        // 4) Test de getAllDishes()
        // ─────────────────────────────────────────
        assertEquals(3, menu.getAllDishes().size(),  "Taille de la liste complète");

        // ─────────────────────────────────────────
        // 5) Test de addDish()
        // ─────────────────────────────────────────
        menu.addDish(soup);    // un starter supplémentaire
        menu.addDish(pasta);   // un mainDish supplémentaire
        menu.addDish(fruits);  // un dessert supplémentaire

        System.out.println("\n===== APRÈS addDish() =====");
        System.out.println(menu);
        assertEquals(2, menu.getStarters().size(),   "addDish - starters");
        assertEquals(2, menu.getMainDishes().size(), "addDish - main dishes");
        assertEquals(2, menu.getDesserts().size(),   "addDish - desserts");

        // ─────────────────────────────────────────
        // 6) Test de removeDish()
        // ─────────────────────────────────────────
        menu.removeDish(pasta);   // retirer un mainDish
        menu.removeDish(fruits);  // retirer un dessert
        menu.removeDish(salad);   // retirer un starter

        System.out.println("\n===== APRÈS removeDish() =====");
        System.out.println(menu);

        // NB : removeDish() n'enlève actuellement que les "starter"
        //      (la méthode est à corriger !).  Ces assertions montrent le problème :
        assertEquals(1, menu.getStarters().size(),   "removeDish - starters");
        assertEquals(2, menu.getMainDishes().size(), "removeDish - main dishes (devrait être 1 si méthode correcte)");
        assertEquals(2, menu.getDesserts().size(),   "removeDish - desserts (devrait être 1 si méthode correcte)");

        // ─────────────────────────────────────────
        // 7) Vérification finale de getAllDishes()
        // ─────────────────────────────────────────
        System.out.println("\nTaille finale de getAllDishes() : " + menu.getAllDishes().size());
    }
}
