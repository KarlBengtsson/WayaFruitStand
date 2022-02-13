package model;

public enum FruitName{
    PEACH("Peach"),
    CHERRY("Cherry"),
    PEAR("pear");


    private final String type;

    FruitName(String type) {
        this.type = type;
    }

    public String getFruitType() {
        return type;
    }
}
