package util;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static model.FruitName.CHERRY;
import static model.FruitName.PEACH;
import static model.FruitName.PEAR;
import static org.junit.Assert.assertEquals;

public class FruitStandCalculatorTest {
    private FruitStandCalculator fruitStandCalculator = new FruitStandCalculator();

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testChooseCheapestStand() throws Exception {
        List<FruitStand> fruitStands = createTestData();
        FruitStand cheapestStand = fruitStandCalculator.calculateBestFruitStand(fruitStands);
        assert cheapestStand.getStandNumber() == 4;
    }

    @Test
    public void testChooseCheapestStandAndRemove() throws Exception {
        List<FruitStand> fruitStands = createTestData();
        FruitStand cheapestStand = fruitStandCalculator.calculateAndRemoveBestFruitStand(fruitStands);
        assert cheapestStand.getStandNumber() == 4;
        assert fruitStands.size() == 6;

        FruitStand secondCheapestStand = fruitStandCalculator.calculateBestFruitStand(fruitStands);
        assert  secondCheapestStand.getStandNumber() == 6;
    }

    @Test
    public void testNoFruitStands() throws Exception {
        List<FruitStand> fruitStands = Collections.emptyList();
        FruitStand fruitStand = fruitStandCalculator.calculateBestFruitStand(fruitStands);
        assert fruitStand.getStandNumber() == 0;
    }

    @Test
    public void testOneFruitStand() throws Exception {
        FruitStand fruitStand1 = FruitStandTestBuilder.buildFruitStand(1, new Fruit(PEAR,13), new Fruit(CHERRY, 40));
        List<FruitStand> fruitStands = Collections.singletonList(fruitStand1);
        FruitStand fruitStand = fruitStandCalculator.calculateBestFruitStand(fruitStands);
        assert fruitStand.getStandNumber() == 1;
    }

    @Test
    public void testExceptionIsThrownWhenNoStandsHavePears() {
        FruitStand fruitStand1 = FruitStandTestBuilder.buildFruitStand(1, new Fruit(PEACH, 13), new Fruit(CHERRY, 40));
        FruitStand fruitStand2 = FruitStandTestBuilder.buildFruitStand(2, new Fruit(PEACH, 15), new Fruit(CHERRY, 29));
        List<FruitStand> fruitStands = Arrays.asList(fruitStand1, fruitStand2);

        assertExceptionThrown(fruitStands);
    }

    @Test
    public void testExceptionIsThrownWhenOnlyOneStandWIthOneFruits() {
        FruitStand fruitStand1 = FruitStandTestBuilder.buildFruitStand(1, new Fruit(PEAR, 13));
        List<FruitStand> fruitStands = Collections.singletonList(fruitStand1);

        assertExceptionThrown(fruitStands);
    }

    @Test
    public void testExceptionIsThrownWhenOnlyOneStandWIthNoPear() {
        FruitStand fruitStand1 = FruitStandTestBuilder.buildFruitStand(1, new Fruit(PEACH,13), new Fruit(CHERRY, 40));
        List<FruitStand> fruitStands = Collections.singletonList(fruitStand1);

        assertExceptionThrown(fruitStands);
    }

    private void assertExceptionThrown(List<FruitStand> fruitStands) {
        try {
            fruitStandCalculator.calculateBestFruitStand(fruitStands);
        } catch (Exception expectedException){
            assertEquals(expectedException.getMessage(), "No FruitStand Matches Pelle and Kajsas Requirements");
        }
    }

    private List<FruitStand> createTestData() {
        FruitStand fruitStand1 = FruitStandTestBuilder.buildFruitStand(1, new Fruit(PEACH, 13), new Fruit(CHERRY, 40));
        FruitStand fruitStand2 = FruitStandTestBuilder.buildFruitStand(2, new Fruit(PEACH, 12), new Fruit(CHERRY, 29));
        FruitStand fruitStand3 = FruitStandTestBuilder.buildFruitStand(3, new Fruit(PEACH, 54), new Fruit(PEAR, 67));
        FruitStand fruitStand4 = FruitStandTestBuilder.buildFruitStand(4, new Fruit(PEACH, 12), new Fruit(PEAR, 29));
        FruitStand fruitStand5 = FruitStandTestBuilder.buildFruitStand(5, new Fruit(PEACH, 19), new Fruit(PEAR, 34));
        FruitStand fruitStand6 = FruitStandTestBuilder.buildFruitStand(6, new Fruit(PEAR, 12), new Fruit(CHERRY, 29));
        FruitStand fruitStand7 = FruitStandTestBuilder.buildFruitStand(7, new Fruit(PEAR, 20), new Fruit(CHERRY, 65));

        return new ArrayList<>(Arrays.asList(
                fruitStand1, fruitStand2, fruitStand3, fruitStand4, fruitStand5, fruitStand6, fruitStand7
        ));
    }

}
