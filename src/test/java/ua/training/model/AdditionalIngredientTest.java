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

    @Test
    public void testCompareToIfNotEquals() {
        AdditionalIngredient additionalIngredient2 = new AdditionalIngredient(
                "Salt", 0.003, 0, "SPECIES");
        int result = additionalIngredient.compareTo(additionalIngredient2);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testCompareToIfEquals() {
        AdditionalIngredient additionalIngredient2 = new AdditionalIngredient(
                "HomemadeMayonnaise", 0.050, 6000, "SAUCES");
        int result = additionalIngredient.compareTo(additionalIngredient2);

        Assert.assertEquals(0, result);
    }

}