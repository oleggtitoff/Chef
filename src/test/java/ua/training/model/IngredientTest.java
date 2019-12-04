package ua.training.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IngredientTest {
    private Ingredient ingredient;

    @Before
    public void createIngredient() {
        ingredient = new Ingredient("Tomato", 0.1, 1000);
    }

    @Test
    public void testCalculateCaloriesInMass() {
        double caloriesInThisMass
                = ingredient.calculateCaloriesInMass(0.1, 1000);

        Assert.assertEquals(100.0, caloriesInThisMass,
                TestConstants.DOUBLES_COMPARISON_DELTA);
    }

    @Test
    public void testAddMore() {
        ingredient.addMore(0.15);
        double mass = ingredient.getMass();

        Assert.assertEquals(0.25, mass,
                TestConstants.DOUBLES_COMPARISON_DELTA);
    }

    @Test
    public void testCompareToIfNotEquals() {
        Ingredient ingredient2 = new Ingredient("Carrot", 0.3, 1000.1);
        int result = ingredient.compareTo(ingredient2);

        Assert.assertEquals(-1, result);
    }

    @Test
    public void testCompareToIfEquals() {
        Ingredient ingredient2 = new Ingredient("Carrot", 0.04, 1000);
        int result = ingredient.compareTo(ingredient2);

        Assert.assertEquals(0, result);
    }

}