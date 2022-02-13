package main;

import model.FruitStand;
import util.BestStandCalculator;

import java.util.ArrayList;

public class Main {

    public static void main (String[] args) throws Exception {
        BestStandCalculator bestStandCalculator = new BestStandCalculator();

        FruitStand fruitStand = bestStandCalculator.calculateBestFruitStand(new ArrayList<>());
        System.out.println("The FruitStand with the lowest price is " + fruitStand.getStandNumber() +
                ". The total price of the the fruit was " + fruitStand.getTotalPrice());
    }
}
