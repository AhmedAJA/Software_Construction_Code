package gameproject;

public class Enemy {
    private String name;
    private int health;
    private int attackDamage;
    private int goldDrop;
    private int potionDropChance;

    public Enemy(String name, int health, int attackDamage, int goldDrop, int potionDropChance) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.goldDrop = goldDrop;
        this.potionDropChance = potionDropChance;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getAttackDamage() { return attackDamage; }
    public int getGoldDrop() { return goldDrop; }
    public int getPotionDropChance() { return potionDropChance; }

    public void takeDamage(int damage) {
        health -= damage;
    }
}
