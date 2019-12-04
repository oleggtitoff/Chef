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

    @Test
    public void testAddMore() {
        ingredient.addMore(0.15);
        double mass = ingredient.getMass();

        Assert.assertEquals(0.25, mass, doublesComparisonDelta);
    }

    @Test
    public void testCompareToIfNotEquals() {
        Ingredient ingredient2 = new Ingredient(0.3, 1000.1);
        int result = ingredient.compareTo(ingredient2);

        Assert.assertEquals(-1, result);
    }

    @Test
    public void testCompareToIfEquals() {
        Ingredient ingredient2 = new Ingredient(0.04, 1000);
        int result = ingredient.compareTo(ingredient2);

        Assert.assertEquals(0, result);
    }

}