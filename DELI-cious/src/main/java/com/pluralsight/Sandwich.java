package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends OrderItem
{
    public static final double[] SIZE_PRICES = {5.50, 7.00, 8.50};
    public static final String[] SIZES = {"4\"", "8\"", "12\""};
    public static final String[] BREAD_TYPES = {"white", "wheat", "rye", "wrap"};

    private String size;
    private String breadType;
    private List<Ingredient> toppings;
    private boolean isToasted;

    public Sandwich(String name, String size, String breadType)
    {
        super(name, 0);
        this.size = size;
        this.breadType = breadType;
        this.toppings = new ArrayList<>();
        this.isToasted = false;
    }

    public String getSize()
    {
        return  size;
    }

    public String getBreadType()
    {
        return breadType;
    }
    public void setToasted(boolean toasted)
    {
        isToasted = toasted;
    }
    public boolean isToasted()
    {
        return isToasted;
    }

    public void addTopping(Ingredient topping)
    {
        toppings.add(topping);
    }

    public void removeTopping(Ingredient topping)
    {
        toppings.remove(topping);
    }

    public List<Ingredient> getToppings()
    {
        return toppings;
    }

    @Override
    public double calculatePrice()
    {
        double basePrice = SIZE_PRICES[List.of(SIZES).indexOf(size)];
        double toppingPrice = toppings.stream().mapToDouble(Ingredient::calculatePrice).sum();
        return basePrice + toppingPrice;
    }
}
