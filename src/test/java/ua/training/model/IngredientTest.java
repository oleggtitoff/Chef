package ua.training.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IngredientTest {
    private Ingredient ingredient;
    private double doublesComparisonDelta = 0.0000000000001;

    @Before
    public void createIngredient() {
        ingredient = new Ingredient(0.1, 1000);
    }

    @Test
    public void testCalculateCaloriesInMass() {
        double caloriesInThisMass
                = ingredient.calculateCaloriesInMass(0.1, 1000);

        Assert.assertEquals(100.0, caloriesInThisMass, doublesComparisonDelta);
    }

}