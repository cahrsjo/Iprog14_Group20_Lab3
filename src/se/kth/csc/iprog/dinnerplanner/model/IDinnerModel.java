package se.kth.csc.iprog.dinnerplanner.model;

import java.util.Set;

public interface IDinnerModel {

	public int getNumberOfGuests();
	public void setNumberOfGuests(int numberOfGuests);
    public void setSelectedDishes(Dish d);
	
	/**
	 * Returns the dish that is on the menu for selected type (1 = Menu, 2 = main, 3 = desert).
	 */
	public Dish getSelectedDish(int type);
	
	/**
	 * Returns all the dishes on the menu.
	 */
	public Set<Dish> getFullMenu();
	
	/**
	 * Returns all ingredients for all the dishes on the menu.
	 */
	public Set<Ingredient> getAllIngredients();
	
	/**
	 * Returns the total price of the menu (all the ingredients multiplied by number of guests).
	 */
	public float getTotalMenuPrice();
}
