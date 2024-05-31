package com.pluralsight;

import com.pluralsight.Interface.CustomOrder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order
{
    private int orderId;
    private Customer customer;
    private List<CustomOrder> items;
    private double totalPrice;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public int getOrderId()
    {
        return orderId;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public List<CustomOrder> getItems()
    {
        return items;
    }

    public double getTotalPrice()
    {
        return totalPrice;
    }

    public void addItem(CustomOrder item)
    {
        items.add(item);
        totalPrice += item.calculatePrice();
    }

    public void saveReceipt()
    {
        File folder = new File("receipts/");
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String folderName = "receipts/";
        String fileName = folderName + dateTime + ".txt";



        try (FileWriter writer = new FileWriter(fileName))
        {
            writer.write("Order ID: " + orderId + "\n");
            writer.write("Customer: " + customer.getName() + " (" + customer.getContactInfo() + ")\n\n");
            for (CustomOrder item : items)
            {
                if (item instanceof Sandwich) {
                    Sandwich sandwich = (Sandwich) item;
                    writer.write(sandwich.getSize() + " Sandwich on " + sandwich.getBreadType() + " - $" + sandwich.calculatePrice() + "\n");
                    for (Ingredient topping : sandwich.getToppings())
                    {
                        writer.write("  + " + topping.getName() + (topping.isPremium() ? " (Premium)" : "") + "\n");
                    }
                } else {
                    writer.write(item.getName() + " - $" + item.calculatePrice() + "\n");
                }
            }
            writer.write("\nTotal Price: $" + totalPrice);
        } catch (IOException e)
        {
            System.out.println("Invalid entry");
        }
    }
}
