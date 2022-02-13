package model;

public class Fruit {

    private double price;
    private FruitName name;

    public Fruit(FruitName name, double price) {
        this.price = price;
        this.name = name;
    }

    double getPrice() {
        return price;
    }

    String getName() {
        return name.getFruitType();
    }
}
