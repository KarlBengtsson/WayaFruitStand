package model

enum class FruitName {

    var PEACH: FruitName? = null,
    var CHERRY: FruitName? = null,
    var PEAR: FruitName? = null


    private val type: String? = null

    open fun FruitName(type: String?) {
        this.type = type
    }

    open fun getFruitType(): String? {
        return type
    }
}
