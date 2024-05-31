package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Menu
{
    private List<Ingredient> ingredients;
    private List<Drink> drinks;
    private List<Chips> chips;

    public Menu()
    {
        this.ingredients = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
        populateMenu();
    }


    public List<Ingredient> getAvailableIngredients()
    {
        return ingredients;
    }

    public List<Drink> getAvailableDrinks()
    {
        return drinks;
    }

    public List<Chips> getAvailableChips()
    {
        return chips;
    }

    private void populateMenu()
    {
        ingredients.add(new Ingredient("Steak", 1.00, true));
        ingredients.add(new Ingredient("Ham", 1.00, true));
        ingredients.add(new Ingredient("Salami", 1.00, true));
        ingredients.add(new Ingredient("Roast Beef", 1.00, true));
        ingredients.add(new Ingredient("Chicken", 1.00, true));
        ingredients.add(new Ingredient("Bacon", 1.00, true));
        ingredients.add(new Ingredient("American Cheese", 0.75, true));
        ingredients.add(new Ingredient("Provolone Cheese", 0.75, true));
        ingredients.add(new Ingredient("Cheddar Cheese", 0.75, true));
        ingredients.add(new Ingredient("Swiss Cheese", 0.75, true));
        ingredients.add(new Ingredient("Lettuce", 0.00, false));
        ingredients.add(new Ingredient("Peppers", 0.00, false));
        ingredients.add(new Ingredient("Onions", 0.00, false));
        ingredients.add(new Ingredient("Tomatoes", 0.00, false));
        ingredients.add(new Ingredient("Jalapenos", 0.00, false));
        ingredients.add(new Ingredient("Cucumbers", 0.00, false));
        ingredients.add(new Ingredient("Pickles", 0.00, false));
        ingredients.add(new Ingredient("Guacamole", 0.00, false));
        ingredients.add(new Ingredient("Mushrooms", 0.00, false));
        ingredients.add(new Ingredient("Mayo", 0.00, false));
        ingredients.add(new Ingredient("Mustard", 0.00, false));
        ingredients.add(new Ingredient("Ketchup", 0.00, false));
        ingredients.add(new Ingredient("Ranch", 0.00, false));
        ingredients.add(new Ingredient("Thousand Islands", 0.00, false));
        ingredients.add(new Ingredient("Vinaigrette", 0.00, false));
        ingredients.add(new Ingredient("Au jus", 0.00, false));
        ingredients.add(new Ingredient("Sauce", 0.00, false));

        drinks.add(new Drink("SmallDrink", 2.00));
        drinks.add(new Drink("Medium Drink", 2.50));
        drinks.add(new Drink("Large Drink", 3.00));

        chips.add(new Chips("Chips", 1.50));
    }
}
