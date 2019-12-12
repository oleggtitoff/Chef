package ua.training.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VegetableTest {
    private Vegetable vegetable;

    @Before
    public void createVegetable() {
        vegetable = new Vegetable("Potato", 0.1, 1000);
    }

    @Test
    public void testCalculateCaloriesInMass() {
        double caloriesInThisMass
                = vegetable.calculateCaloriesInMass(0.1, 1000);

        Assert.assertEquals(100.0, caloriesInThisMass,
                TestConstants.DOUBLES_COMPARISON_DELTA);
    }

    @Test
    public void testAddMore() {
        vegetable.addMore(0.15);
        double mass = vegetable.getMass();

        Assert.assertEquals(0.25, mass,
                TestConstants.DOUBLES_COMPARISON_DELTA);
    }

    @Test
    public void testCompareToIfNotEquals() {
        Vegetable vegetable2 = new Vegetable("Carrot", 0.3, 1000.1);
        int result = vegetable.compareTo(vegetable2);

        Assert.assertEquals(-1, result);
    }

    @Test
    public void testCompareToIfEquals() {
        Vegetable vegetable2 = new Vegetable("Carrot", 0.04, 1000);
        int result = vegetable.compareTo(vegetable2);

        Assert.assertEquals(0, result);
    }

    @Test
    public void testCheckIfIsClean() {
        boolean isClean = vegetable.checkIfIsClean();

        Assert.assertFalse(isClean);
    }

    @Test
    public void testClean() {
        vegetable.clean();
        boolean isClean = vegetable.checkIfIsClean();

        Assert.assertTrue(isClean);
    }

    @Test
    public void testCheckAndClean() {
        vegetable.checkAndClean();
        boolean isClean = vegetable.checkIfIsClean();

        Assert.assertTrue(isClean);
    }

}