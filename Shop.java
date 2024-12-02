package gameproject;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    private ArrayList<Item> inventory;

    public Shop() {
        inventory = new ArrayList<>();
        inventory.add(new Item("Health Potion", 50, 30));
        inventory.add(new Item("Strength Potion", 100, 2));
    }

    public void openShop(Player player, Scanner console) {
        System.out.println("Welcome to the shop!");
        while (true) {
            System.out.println("\nYour Gold: " + player.getGold());
            System.out.println("Items for sale:");
            for (int i = 0; i < inventory.size(); i++) {
                Item item = inventory.get(i);
                System.out.println((i + 1) + ". " + item.getName() + " - " + item.getPrice() + " gold");
            }
            System.out.println((inventory.size() + 1) + ". Exit Shop");

            String choice = console.nextLine();
            int index = Integer.parseInt(choice) - 1;

            if (index == inventory.size()) break;
            if (index >= 0 && index < inventory.size()) {
                Item item = inventory.get(index);
                if (player.getGold() >= item.getPrice()) {
                    player.spendGold(item.getPrice());
                    if (item.getName().equals("Health Potion")) {
                        player.gainPotion();
                    }
                    System.out.println("You purchased " + item.getName() + "!");
                } else {
                    System.out.println("Not enough gold!");
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
