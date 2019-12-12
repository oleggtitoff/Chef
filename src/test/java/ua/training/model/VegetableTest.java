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