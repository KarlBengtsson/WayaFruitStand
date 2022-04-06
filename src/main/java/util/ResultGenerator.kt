package util

import model.FruitStand

class ResultGenerator {


    //Print out number of first fruit stand, and lowest possible price
    fun generateBasicResult(fruitStand: FruitStand): String? {
        return "The FruitStand with the lowest price is " + fruitStand.getStandNumber().toString() +
                ". The total price of the the fruit was " + fruitStand.getTotalPrice()
    }

    //Print out stands, price, what fruits were purchased and by how many
    //stands the selection was made.
    fun generateDetailedResult(fruitStand: FruitStand, standOrder: String): String? {
        val standContents = StringBuilder()
        fruitStand.getFruitSet().forEach { fruit ->
            standContents.append(fruit.getName()).append(": ").append(fruit.getPrice())
        }
        return "The FruitStand with the " + standOrder + " price is " + fruitStand.getStandNumber() +
                ". The FruitStand contains the following fruits and prices: " + standContents.toString()
    }

}
