package gameproject;

public class Player {
    private String name;
    private int health;
    private int attackDamage;
    private int gold;
    private int potions;

    public Player(String name, int health, int attackDamage, int gold, int potions) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.gold = gold;
        this.potions = potions;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getAttackDamage() { return attackDamage; }
    public int getGold() { return gold; }
    public int getPotions() { return potions; }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void heal(int amount) {
        health += amount;
    }

    public void usePotion() {
        if (potions > 0) {
            heal(30);
            potions--;
            System.out.println("You used a potion. Health: " + health);
        } else {
            System.out.println("No potions left!");
        }
    }

    public void gainGold(int amount) {
        gold += amount;
    }

    public void spendGold(int amount) {
        gold -= amount;
    }

    public void gainPotion() {
        potions++;
    }
}
