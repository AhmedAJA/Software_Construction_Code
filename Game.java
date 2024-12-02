package gameproject;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Game {
    private Player player;
    private Shop shop;
    private ArrayList<Enemy> enemies;
    private Random rand = new Random();

    public Game() {
        player = new Player("Hero", 100, 50, 0, 0);
        shop = new Shop();
        enemies = new ArrayList<>();
        enemies.add(new Enemy("Kobold", 75, 25, 50, 25));
        enemies.add(new Enemy("Kobold Warrior", 100, 35, 70, 30));
        enemies.add(new Enemy("Kobold Archer", 90, 30, 60, 20));
        enemies.add(new Enemy("Kobold Overseer", 120, 40, 100, 50));
    }

    public void startGame() {
        System.out.println("Welcome to the Dungeon Crawler!");
        Scanner console = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Explore Dungeon\n2. Visit Shop\n3. Exit Game");
            String choice = console.nextLine();

            switch (choice) {
                case "1":
                    exploreDungeon(console);
                    break;
                case "2":
                    shop.openShop(player, console);
                    break;
                case "3":
                    System.out.println("Thanks for playing!");
                    console.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void exploreDungeon(Scanner console) {
        Enemy enemy = enemies.get(rand.nextInt(enemies.size()));
        System.out.println("You encounter a " + enemy.getName() + "!");
        Battle battle = new Battle(player, enemy);
        boolean survived = battle.startBattle(console);

        if (!survived) {
            System.out.println("You died! Game over.");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
