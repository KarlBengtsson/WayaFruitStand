package util;

import model.Fruit;
import model.FruitName;
import model.FruitStand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class FruitStandTestBuilder {

    static FruitStand buildFruitStand(int standNumber, Fruit... fruits) {
        Set<Fruit> fruitSet = new HashSet<>(Arrays.asList(fruits));
        return new FruitStand(fruitSet, standNumber);
    }

    static FruitStand builder(int standNumber, Map<FruitName, Double> fruitMap) {
        Set<Fruit> fruits = fruitMap.entrySet()
                .stream()
                .map(e -> new Fruit(e.getKey(), e.getValue()))
                .collect(Collectors.toSet());
        return new FruitStand(fruits, standNumber);
    }
}

