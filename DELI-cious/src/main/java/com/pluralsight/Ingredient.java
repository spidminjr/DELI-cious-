package com.pluralsight;

public class Ingredient extends OrderItem
{
    private boolean isPremium;

    public Ingredient(String name, double price, boolean isPremium)
    {
        super(name, price);
        this.isPremium = isPremium;
    }

    public boolean isPremium()
    {
        return isPremium;
    }

    @Override
    public double calculatePrice()
    {
        return getPrice();
    }
}
