package model

class FruitStand {
    private var fruitSet: Set<Fruit>? = null
    private var standNumber = 0

    fun FruitStand(fruitSet: Set<Fruit>?, standNumber: Int) {
        this.fruitSet = fruitSet
        this.standNumber = standNumber
    }

    fun containsPear(): Boolean {
        return fruitSet!!.stream().anyMatch { fruit: Fruit -> fruit.getName() == FruitName.PEAR.getFruitType() }
    }

    fun containsTwoFruits(): Boolean {
        return fruitSet!!.size == 2
    }

    fun getFruitSet(): Set<Fruit>? {
        return fruitSet
    }

    fun getStandNumber(): Int {
        return standNumber
    }

    fun getTotalPrice(): Double {
        return fruitSet!!.stream().mapToDouble { obj: Fruit -> obj.getPrice() }.sum()
    }
}
