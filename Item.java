package gameproject;

public class Item {
    private String name;
    private int price;
    private int effect;

    public Item(String name, int price, int effect) {
        this.name = name;
        this.price = price;
        this.effect = effect;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getEffect() { return effect; }
}
