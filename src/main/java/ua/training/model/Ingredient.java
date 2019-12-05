package ua.training.model;

import ua.training.view.StringsContainer;

import static ua.training.view.View.bundle;

class Ingredient implements Comparable<Ingredient> {
    private String name;
    private double mass;
    private double kCaloriesIn1KG;
    private double kCalories;

    Ingredient(String name, double mass, double kCaloriesIn1KG) {
        this.mass = mass;
        this.kCaloriesIn1KG = kCaloriesIn1KG;
        kCalories = calculateCaloriesInMass(mass, kCaloriesIn1KG);
    }

    double calculateCaloriesInMass(double mass, double kCaloriesIn1KG) {
        return mass * kCaloriesIn1KG;
    }

    String getName() {
        return name;
    }

    double getMass() {
        return mass;
    }

    double getKCaloriesIn1KG() {
        return kCaloriesIn1KG;
    }

    double getKCalories() {
        return kCalories;
    }

    void addMore(double mass) {
        this.mass += mass;
    }

    @Override
    public int compareTo(Ingredient ingredient) {
        return Double.compare(kCaloriesIn1KG, ingredient.kCaloriesIn1KG);
    }

    @Override
    public String toString() {
        return StringsContainer.OPEN_CURLY_BRACE
                + bundle.getString(StringsContainer.NAME_WORD)
                + StringsContainer.SPACE_SIGN + StringsContainer.EQUAL_SIGN
                + StringsContainer.SPACE_SIGN + name
                + StringsContainer.COMMA_SIGN + StringsContainer.SPACE_SIGN
                + bundle.getString(StringsContainer.K_CALORIES_IN_1_KG_WORD)
                + StringsContainer.SPACE_SIGN + StringsContainer.EQUAL_SIGN
                + StringsContainer.SPACE_SIGN + kCaloriesIn1KG
                + StringsContainer.COMMA_SIGN + StringsContainer.SPACE_SIGN
                + bundle.getString(StringsContainer.K_CALORIES_WORD)
                + StringsContainer.SPACE_SIGN + StringsContainer.EQUAL_SIGN
                + StringsContainer.SPACE_SIGN + kCalories;
    }

}
