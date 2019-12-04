package ua.training.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VegetableTest {
    private Vegetable vegetable;

    @Before
    public void createVegetable() {
        vegetable = new Vegetable(0.1, 1000);
    }

    @Test
    public void testCheckIfIsClean() {
        boolean isClean = vegetable.checkIfIsClean();
        Assert.assertFalse(isClean);
    }

}