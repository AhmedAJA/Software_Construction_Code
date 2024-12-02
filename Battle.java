package gameproject;

import java.util.Scanner;
import java.util.Random;

public class Battle {
    private Player player;
    private Enemy enemy;
    private Random rand = new Random();

    public Battle(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public boolean startBattle(Scanner console) {
        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            System.out.println("\nYour HP: " + player.getHealth() + " | Enemy HP: " + enemy.getHealth());
            System.out.println("1. Attack\n2. Use Potion\n3. Run");
            String choice = console.nextLine();

            switch (choice) {
                case "1":
                    int playerDamage = rand.nextInt(player.getAttackDamage());
                    int enemyDamage = rand.nextInt(enemy.getAttackDamage());
                    enemy.takeDamage(playerDamage);
                    player.takeDamage(enemyDamage);
                    System.out.println("You dealt " + playerDamage + " damage.");
                    System.out.println("Enemy dealt " + enemyDamage + " damage.");
                    break;
                case "2":
                    player.usePotion();
                    break;
                case "3":
                    System.out.println("You ran away!");
                    return true;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        if (player.getHealth() <= 0) {
            return false;
        } else {
            System.out.println("You defeated the " + enemy.getName() + "!");
            player.gainGold(enemy.getGoldDrop());
            if (rand.nextInt(100) < enemy.getPotionDropChance()) {
                player.gainPotion();
                System.out.println("The enemy dropped a potion!");
            }
            return true;
        }
    }
}
