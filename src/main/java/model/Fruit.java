package model;

public class Fruit {

    private double price;
    private FruitName name;

    public Fruit(FruitName name, double price) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name.getFruitType();
    }
}
