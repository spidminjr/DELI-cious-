package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class POS
{
    private List<Order> orders;
    private Menu menu;

    public POS()
    {
        this.orders = new ArrayList<>();
        this.menu = new Menu();
    }

    public Menu getMenu()
    {
        return menu;
    }

    public void addOrder(Order order)
    {
       orders.add(order);
    }

    public List<Order> getOrders()
    {
        return orders;
    }
    public Customer createCustomer(String name, String contactInfo)
    {
        return new Customer(name, contactInfo);
    }

    public Order getOrderById(int orderId)
    {
        return orders.stream().filter(order -> order.getOrderId() == orderId).findFirst().orElse(null);
    }
}
