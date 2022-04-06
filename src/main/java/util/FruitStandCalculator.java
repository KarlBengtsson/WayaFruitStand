package util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FruitStandCalculator {

    public FruitStandCalculator() {}

    public FruitStand calculateAndRemoveBestFruitStand(List<FruitStand> fruitStands) throws Exception {
        FruitStand bestStand = calculateBestFruitStand(fruitStands);
        fruitStands.remove(bestStand);
        return bestStand;
    }

    public FruitStand calculateBestFruitStand(List<FruitStand> fruitStands) throws Exception {
        if (fruitStands.isEmpty()) {
            return new FruitStand(Collections.emptySet(), 0);
        }

        if (fruitStands.size() == 1) {
            if (fruitStands.get(0).containsPear() && fruitStands.get(0).containsTwoFruits()) {
                return fruitStands.get(0);
            }
            throw new Exception("No FruitStand Matches Pelle and Kajsas Requirements");
        }

        return fruitStands.stream().filter(FruitStand::containsPear)
                .filter(FruitStand::containsTwoFruits)
                .min(Comparator.comparing(FruitStand::getTotalPrice))
                .orElseThrow(() -> new Exception("No FruitStand Matches Pelle and Kajsas Requirements"));
    }
}
