package ua.training.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SaladTest {
    private Salad salad;
    private double doublesComparisonDelta = 0.0000000000001;

    @Before
    public void createSalad() {
        salad = new Salad();
    }

    @Test
    public void testTotalKCaloriesCalculation() {
        salad.addVegetable("Potato", 0.5, 400);
        salad.addAdditionalIngredient("Sauce", 0.1, 500, "SAUCE");
        double totalKCalories = salad.getTotalKCalories();

        Assert.assertEquals(250, totalKCalories, doublesComparisonDelta);
    }

}