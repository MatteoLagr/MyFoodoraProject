package other;

import sellable.Meal;

public interface Observer {
	
	public void update(Observable observable, Meal mealOfWeek );
}
