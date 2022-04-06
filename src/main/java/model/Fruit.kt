package model

class Fruit {
    private var price = 0.0
    private var name: FruitName? = null

    fun Fruit(name: FruitName?, price: Double) {
        this.price = price
        this.name = name
    }

    fun getPrice(): Double {
        return price
    }

    fun getName(): String? {
        return name!!.type
    }
}