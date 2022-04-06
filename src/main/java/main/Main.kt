package main

import model.FruitStand
import util.FruitStandCalculator
import util.ResultGenerator

class Main {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val fruitStandCalculator = FruitStandCalculator()
        val bestFruitStand: FruitStand = fruitStandCalculator.calculateAndRemoveBestFruitStand(ArrayList<FruitStand>())
        val secondBestFruitStand: FruitStand = fruitStandCalculator.calculateBestFruitStand(ArrayList<FruitStand>())
        System.out.println(ResultGenerator.generateDetailedResult(bestFruitStand, "lowest"))
        System.out.println(ResultGenerator.generateDetailedResult(secondBestFruitStand, "second lowest"))
    }
}