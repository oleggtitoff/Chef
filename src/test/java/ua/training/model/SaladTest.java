package ua.training.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SaladTest {
    private Salad salad;
    private final double DOUBLES_COMPARISON_DELTA = 0.0000000000001;
    private final double RANGE_MIN_VALUE = 400;
    private final double RANGE_MAX_VLAUE = 800;

    @Before
    public void createSalad() {
        salad = new Salad();
        salad.addVegetable("Carrot", 0.250, 310);
        salad.addVegetable("Potato", 0.5, 800);
        salad.addAdditionalIngredient("Sauce", 0.1, 500, "SAUCE");
        salad.addAdditionalIngredient("Salt", 0.005, 0, "SPICE");
        salad.sort();
    }

    @Test
    public void testGetTotalKCalories() {
        double totalKCalories = salad.getTotalKCalories();

        Assert.assertEquals(527.5, totalKCalories, DOUBLES_COMPARISON_DELTA);
    }

    @Test
    public void testGetIngredientsInKCaloriesRange() {
        List<Ingredient> ingredientsInRange
                = salad.getIngredientsInKCaloriesRange(RANGE_MIN_VALUE,
                RANGE_MAX_VLAUE);
        int listSize = ingredientsInRange.size();
        double element1KCalories = ingredientsInRange.get(0).getKCaloriesIn1KG();
        double element2KCalories = ingredientsInRange.get(1).getKCaloriesIn1KG();

        Assert.assertEquals(2, listSize);
        Assert.assertEquals(500, element1KCalories, DOUBLES_COMPARISON_DELTA);
        Assert.assertEquals(800, element2KCalories, DOUBLES_COMPARISON_DELTA);
    }

}