package util;

import model.Fruit;
import model.FruitName;
import model.FruitStand;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class BestStandCalculatorTest{
    private BestStandCalculator bestStandCalculator = new BestStandCalculator();
    private List<FruitStand> fruitStands = new ArrayList<>();

    @Rule
    public final ExpectedException exception = ExpectedException.none();


    @Before
    public void setUp() {
        FruitStand fruitStand1 = FruitStandTestBuilder.buildPeachCherryFruitStand(1, 13, 40);
        FruitStand fruitStand2 = FruitStandTestBuilder.buildPeachCherryFruitStand(2, 12, 29);
        FruitStand fruitStand3 = FruitStandTestBuilder.buildPeachPearFruitStand(3, 54, 67);
        FruitStand fruitStand4 = FruitStandTestBuilder.buildPeachPearFruitStand(4, 12, 29);
        FruitStand fruitStand5 = FruitStandTestBuilder.buildPeachPearFruitStand(5, 19, 34);
        FruitStand fruitStand6 = FruitStandTestBuilder.buildPearCherryFruitStand(6, 12, 29);
        FruitStand fruitStand7 = FruitStandTestBuilder.buildPearCherryFruitStand(7, 20, 65);
        fruitStands.addAll(Arrays.asList(
            fruitStand1, fruitStand2, fruitStand3, fruitStand4, fruitStand5, fruitStand6, fruitStand7
        ));
    }

    @Test
    public void testChooseCheapestStand() throws Exception {
        FruitStand cheapestStand = bestStandCalculator.calculateBestFruitStand(fruitStands);
        assert cheapestStand.getStandNumber() == 4;
    }

    @Test
    public void testNoFruitStands() throws Exception {
        List<FruitStand> stands = Collections.emptyList();
        FruitStand fruitStand = bestStandCalculator.calculateBestFruitStand(stands);
        assert fruitStand.getStandNumber() == 0;
    }

    @Test
    public void testOneFruitStand() throws Exception {
        FruitStand fruitStand1 = FruitStandTestBuilder.buildPearCherryFruitStand(1, 13, 40);
        List<FruitStand> stands = Collections.singletonList(fruitStand1);
        FruitStand fruitStand = bestStandCalculator.calculateBestFruitStand(stands);
        assert fruitStand.getStandNumber() == 1;
    }

    @Test
    public void testExceptionIsThrownWhenNoStandsHavePears() {
        Fruit fruit1 = new Fruit(FruitName.CHERRY, 10);
        Fruit fruit2 = new Fruit(FruitName.CHERRY, 15);
        Fruit fruit3 = new Fruit(FruitName.PEACH, 10);
        Fruit fruit4 = new Fruit(FruitName.PEACH, 15);
        Set<Fruit> fruits1 = new HashSet<>();
        fruits1.add(fruit1);
        fruits1.add(fruit2);
        Set<Fruit> fruits2 = new HashSet<>();
        fruits2.add(fruit3);
        fruits2.add(fruit4);
        FruitStand fruitStand1 = new FruitStand(fruits1, 1);
        FruitStand fruitStand2 = new FruitStand(fruits2, 2);
        List<FruitStand> stands = Arrays.asList(fruitStand1, fruitStand2);

        assertExceptionThrown(stands);
    }

    @Test
    public void testExceptionIsThrownWhenOnlyOneStandWIthAllFruits() {
        Fruit fruit1 = new Fruit(FruitName.CHERRY, 10);
        Set<Fruit> fruits1 = new HashSet<>();
        fruits1.add(fruit1);
        FruitStand fruitStand1 = new FruitStand(fruits1, 1);
        List<FruitStand> stands = Collections.singletonList(fruitStand1);

        assertExceptionThrown(stands);
    }

    @Test
    public void testExceptionIsThrownWhenOnlyOneStandWIthOneFruit() {
        FruitStand fruitStand1 = FruitStandTestBuilder.buildPeachCherryFruitStand(1, 13, 40);
        List<FruitStand> stands = Collections.singletonList(fruitStand1);

        assertExceptionThrown(stands);
    }

    private void assertExceptionThrown(List<FruitStand> fruitStands) {
        try {
            bestStandCalculator.calculateBestFruitStand(fruitStands);
        } catch (Exception expectedException){
            assertEquals(expectedException.getMessage(), "No FruitStand Matches Pelle and Kajsas Requirements");
        }
    }

}
