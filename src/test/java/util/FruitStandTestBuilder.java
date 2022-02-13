package util;

import model.Fruit;
import model.FruitName;
import model.FruitStand;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class FruitStandTestBuilder {

    static FruitStand buildPeachCherryFruitStand(int standNumber, double peachPrice, double cherryPrice) {
        Fruit peach = new Fruit(FruitName.PEACH, peachPrice);
        Fruit cherry = new Fruit(FruitName.CHERRY, cherryPrice);
        Set<Fruit> fruits = new HashSet<>(Arrays.asList(peach, cherry));
        return new FruitStand(fruits, standNumber);
    }

    static FruitStand buildPeachPearFruitStand(int standNumber, double peachPrice, double pearPrice) {
        Fruit peach = new Fruit(FruitName.PEACH, peachPrice);
        Fruit pear = new Fruit(FruitName.PEAR, pearPrice);
        Set<Fruit> fruits = new HashSet<>(Arrays.asList(peach, pear));
        return new FruitStand(fruits, standNumber);
    }

    static FruitStand buildPearCherryFruitStand(int standNumber, double pearPrice, double cherryPrice) {
        Fruit pear = new Fruit(FruitName.PEAR, pearPrice);
        Fruit cherry = new Fruit(FruitName.CHERRY, cherryPrice);
        Set<Fruit> fruits = new HashSet<>(Arrays.asList(pear, cherry));
        return new FruitStand(fruits, standNumber);
    }
}

