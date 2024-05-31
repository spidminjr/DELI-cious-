package com.pluralsight;

import com.pluralsight.Interface.CustomOrder;

public abstract class OrderItem implements CustomOrder
{
    private String name;
    private double price;

    public OrderItem(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double calculatePrice()
    {
        return price;
    }

    @Override
    public String getName()
    {
        return  name;
    }
}

