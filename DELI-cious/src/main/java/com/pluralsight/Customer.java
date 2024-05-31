package com.pluralsight;

public class Customer
{
    private String name;
    private String contactInfo;

    public Customer(String name, String contactInfo)
    {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getName()
    {
        return name;
    }

    public String getContactInfo()
    {
        return contactInfo;
    }

    public Order createOrder(int orderId)
    {
        return new Order(orderId, this);
    }
}
