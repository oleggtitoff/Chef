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

    public void sort() {
        Collections.sort(ingredients);
    }

}
