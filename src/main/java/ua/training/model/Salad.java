package ua.training.model;

import ua.training.view.StringsContainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ua.training.view.View.bundle;

public class Salad {
    private List<Ingredient> ingredients = new ArrayList<>();
    private double totalKCalories;

    public void addVegetable(String name, double mass, double kCaloriesIn1KG) {
        Vegetable vegetable = new Vegetable(name, mass, kCaloriesIn1KG);
        vegetable.checkAndClean();
        addIngredient(vegetable);
    }

    public void addAdditionalIngredient(String name, double mass,
                                        double kCaloriesIn1KG, String type) {
        Ingredient additionalIngredient = new AdditionalIngredient(name, mass,
                kCaloriesIn1KG, type);
        addIngredient(additionalIngredient);
    }

    private void addIngredient(Ingredient ingredient) {
        Ingredient oldIngredient = getIngredientIfItIsAddedYet(ingredient);

        if (oldIngredient == null) {
            ingredients.add(ingredient);
        } else {
            oldIngredient.addMore(ingredient.getMass());
        }
        addKCaloriesToTotal(ingredient);
    }

    private Ingredient getIngredientIfItIsAddedYet(Ingredient newIngredient) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equals(newIngredient.getName())) {
                return ingredient;
            }
        }
        return null;
    }

    private void addKCaloriesToTotal(Ingredient ingredient) {
        totalKCalories += ingredient.getKCalories();
    }

    public double getTotalKCalories() {
        return totalKCalories;
    }

    public String getIngredientsInKCaloriesRangeToString(double rangeMinValue,
                                                         double rangeMaxValue) {
        StringBuilder resultString = new StringBuilder();
        List<Ingredient> ingredientsInRange
                = getIngredientsInKCaloriesRange(rangeMinValue, rangeMaxValue);

        buildInKCaloriesRangeString(resultString, ingredientsInRange);
        return resultString.toString();
    }

    private void buildInKCaloriesRangeString(StringBuilder resultString, List<Ingredient> ingredientsInRange) {
        resultString.append(StringsContainer.OPEN_CURLY_BRACE);
        appendAllIngredientsToString(resultString, ingredientsInRange);
        resultString.append(StringsContainer.CLOSE_CURLY_BRACE);
    }

    List<Ingredient> getIngredientsInKCaloriesRange(double rangeMinValue,
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

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();

        buildSaladString(resultString);
        return resultString.toString();
    }

    private void buildSaladString(StringBuilder resultString) {
        appendSaladWordAndCurlyBraceToString(resultString);
        appendAllIngredientsToString(resultString, ingredients);
        resultString.append(StringsContainer.CLOSE_CURLY_BRACE);
    }

    private void appendSaladWordAndCurlyBraceToString(StringBuilder resultString) {
        resultString.append(bundle.getString(StringsContainer.SALAD_WORD));
        resultString.append(StringsContainer.SPACE_SIGN);
        resultString.append(StringsContainer.OPEN_CURLY_BRACE);
    }

    private void appendAllIngredientsToString(StringBuilder resultString,
                                              List<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            resultString.append(ingredient.toString());
            resultString.append(System.lineSeparator());
        }
    }

}
