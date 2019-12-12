package ua.training.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdditionalIngredientTest {
    private AdditionalIngredient additionalIngredient;

    @Before
    public void createAdditionalIngredient() {
        additionalIngredient = new AdditionalIngredient("Mayonnaise", 0.080, 6000, "SAUCES");
    }

    @Test
    public void testCalculateCaloriesInMass() {
        double caloriesInThisMass
                = additionalIngredient.calculateCaloriesInMass(0.1, 1000);

        Assert.assertEquals(100.0, caloriesInThisMass,
                TestConstants.DOUBLES_COMPARISON_DELTA);
    }

    @Test
    public void testAddMore() {
        additionalIngredient.addMore(0.020);
        double mass = additionalIngredient.getMass();

        Assert.assertEquals(0.1, mass,
                TestConstants.DOUBLES_COMPARISON_DELTA);
    }

}