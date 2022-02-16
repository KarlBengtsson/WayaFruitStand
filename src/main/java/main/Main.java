package main;

import model.FruitStand;
import util.FruitStandCalculator;
import util.ResultGenerator;

import java.util.ArrayList;

public class Main {

    public static void main (String[] args) throws Exception {
        FruitStandCalculator fruitStandCalculator = new FruitStandCalculator();

        FruitStand bestFruitStand = fruitStandCalculator.calculateAndRemoveBestFruitStand(new ArrayList<>());
        FruitStand secondBestFruitStand = fruitStandCalculator.calculateBestFruitStand(new ArrayList<>());

        System.out.println(ResultGenerator.generateDetailedResult(bestFruitStand, "lowest"));
        System.out.println(ResultGenerator.generateDetailedResult(secondBestFruitStand, "second lowest"));
    }
}
