package model;

import java.util.Set;

public class FruitStand {

    private Set<Fruit> fruitSet;
    private int standNumber;

    public FruitStand(Set<Fruit> fruitSet, int standNumber) {
        this.fruitSet = fruitSet;
        this.standNumber = standNumber;
    }

    public boolean containsPear() {
        return fruitSet.stream().anyMatch(fruit -> fruit.getName().equals(FruitName.PEAR.getFruitType()));
    }

    public boolean containsTwoFruits() {
        return fruitSet.size() == 2;
    }

    public int getStandNumber() {
        return standNumber;
    }

    public double getTotalPrice() {
        return fruitSet.stream().mapToDouble(Fruit::getPrice).sum();
    }
}
