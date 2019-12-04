package ua.training.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Salad {
    private List<Ingredient> ingredients = new ArrayList<>();
    private double totalKCalories;

    public void addVegetable(String name, double mass, double kCaloriesIn1KG) {
        Ingredient vegetable = new Vegetable(name, mass, kCaloriesIn1KG);
        addIngredient(vegetable);
    }

    public void addAdditionalIngredient(String name, double mass,
                                        double kCaloriesIn1KG, String type) {
        Ingredient additionalIngredient = new AdditionalIngredient(name, mass,
                kCaloriesIn1KG, type);
        addIngredient(additionalIngredient);
    }

    private void addIngredient(Ingredient ingredient) {
        addKCaloriesToTotal(ingredient);
        ingredients.add(ingredient);
    }

    private void addKCaloriesToTotal(Ingredient ingredient) {
        totalKCalories += ingredient.getKCalories();
    }

    public double getTotalKCalories() {
        return totalKCalories;
    }

    public List<Ingredient> getIngredientsInKCaloriesRange(double rangeMinValue,
                                                           double rangeMaxValue) {
        List<Ingredient> ingredientsInRange = new ArrayList<>();

        for (Ingredient ingredient : ingredients) {
            double calories = ingredient.getKCaloriesIn1KG();

            if (checkIfDoubleIsInRange(calories, rangeMinValue, rangeMaxValue)) {
                ingredientsInRange.add(ingredient);
            }
        }
        return ingredientsInRange;
    }

    private boolean checkIfDoubleIsInRange(double value, double rangeMinValue,
                                           double rangeMaxValue) {
        return value > rangeMinValue && value < rangeMaxValue
                || Double.compare(rangeMinValue, value) == 0
                || Double.compare(rangeMaxValue, value) == 0;
    }

    public void sort() {
        Collections.sort(ingredients);
    }

}
