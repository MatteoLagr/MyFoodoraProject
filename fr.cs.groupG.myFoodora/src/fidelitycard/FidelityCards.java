package fidelitycard;

// on compute les prix dans order et on conserve juste les infos ic

import other.Order;

public interface FidelityCards {
	public String getTypeOfCard(); //J'ai ajouté ça pour pouvoir l'utiliser dans Order pour appliquer les discounts des cartes

}
