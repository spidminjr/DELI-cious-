package com.pluralsight;


import com.pluralsight.Interface.CustomOrder;

import java.util.Scanner;

public class Main
{
    private static POS pos = new POS();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        while (true)
        {
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1)
            {
                handleNewOrder();
            } else if (choice == 0)
            {
                break;
            }
        }
    }

    private static void handleNewOrder()
    {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer contact info: ");
        String contactInfo = scanner.nextLine();

        Customer customer = pos.createCustomer(name, contactInfo);
        Order order = customer.createOrder(pos.getOrders().size() + 1);

        while (true)
        {
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1)
            {
                handleAddSandwich(order);
            } else if (choice == 2)
            {
                handleAddDrink(order);
            } else if (choice == 3)
            {
                handleAddChips(order);
            } else if (choice == 4)
            {
                handleCheckout(order);
                break;
            } else if (choice == 0)
            {
                break;
            }
        }
    }

    private static void handleAddSandwich(Order order)
    {
        System.out.println("Select your bread:");
        for (int i = 0; i < Sandwich.BREAD_TYPES.length; i++)
        {
            System.out.println((i + 1) + ") " + Sandwich.BREAD_TYPES[i]);
        }
        int breadChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Select sandwich size:");
        for (int i = 0; i < Sandwich.SIZES.length; i++)
        {
            System.out.println((i + 1) + ") " + Sandwich.SIZES[i]);
        }
        int sizeChoice = scanner.nextInt();
        scanner.nextLine();


        if (sizeChoice >= 1 && sizeChoice <= Sandwich.SIZES.length &&
                breadChoice >= 1 && breadChoice <= Sandwich.BREAD_TYPES.length)
        {
            Sandwich sandwich = new Sandwich("Sandwich", Sandwich.SIZES[sizeChoice - 1], Sandwich.BREAD_TYPES[breadChoice - 1]);

            System.out.println("Add toppings:");
            for (int i = 0; i < pos.getMenu().getAvailableIngredients().size(); i++)
            {
                Ingredient ingredient = pos.getMenu().getAvailableIngredients().get(i);
                System.out.println((i + 1) + ") " + ingredient.getName() + (ingredient.isPremium() ? " (Premium)" : ""));
            }
            while (true)
            {
                int toppingChoice = scanner.nextInt();
                scanner.nextLine();
                if (toppingChoice == 0) {
                    break;
                } else {
                    Ingredient topping = pos.getMenu().getAvailableIngredients().get(toppingChoice - 1);
                    sandwich.addTopping(topping);
                }
            }

            System.out.println("Would you like the sandwich toasted? (yes/no)");
            String toastedChoice = scanner.nextLine();
            sandwich.setToasted(toastedChoice.equalsIgnoreCase("yes"));

            order.addItem(sandwich);
        } else {
            System.out.println("Invalid choice. Please select a valid option.");
        }
    }

    private static void handleAddDrink(Order order)
    {
        System.out.println("Select drink:");
        for (int i = 0; i < pos.getMenu().getAvailableDrinks().size(); i++)
        {
            Drink drink = pos.getMenu().getAvailableDrinks().get(i);
            System.out.println((i + 1) + ") " + drink.getName());
        }
        int drinkChoice = scanner.nextInt();
        scanner.nextLine();

        Drink drink = pos.getMenu().getAvailableDrinks().get(drinkChoice - 1);
        order.addItem(drink);
    }

    private static void handleAddChips(Order order)
    {
        System.out.println("Select chips:");
        for (int i = 0; i < pos.getMenu().getAvailableChips().size(); i++)
        {
            Chips chips = pos.getMenu().getAvailableChips().get(i);
            System.out.println((i + 1) + ") " + chips.getName());
        }
        int chipsChoice = scanner.nextInt();
        scanner.nextLine();

        Chips chips = pos.getMenu().getAvailableChips().get(chipsChoice - 1);
        order.addItem(chips);
    }

    private static void handleCheckout(Order order)
    {
        System.out.println("Order details:");
        for (CustomOrder item : order.getItems())
        {
            if (item instanceof Sandwich)
            {
                Sandwich sandwich = (Sandwich) item;
                System.out.println(sandwich.getSize() + " Sandwich on " + sandwich.getBreadType() + " - $" + sandwich.calculatePrice());
                System.out.println("Toppings:");
                for (Ingredient topping : sandwich.getToppings()) {
                    System.out.println(" - " + topping.getName());
                }
                System.out.println("Toasted: " + (sandwich.isToasted() ? "Yes" : "No"));
            } else if (item instanceof Drink)
            {
                Drink drink = (Drink) item;
                System.out.println(drink.getName() + " - $" + drink.getPrice());
            } else if (item instanceof Chips)
            {
                Chips chips = (Chips) item;
                System.out.println(chips.getName() + " - $" + chips.getPrice());
            }
        }
        System.out.println("Total: $" + order.getTotalPrice());

        order.saveReceipt();
        System.out.println("Transaction saved");
    }
}