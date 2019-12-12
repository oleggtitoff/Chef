package ua.training.model;

import ua.training.view.StringsContainer;

import static ua.training.view.View.bundle;

/**
 * This class represents ingredient of salad.
 *
 * @author Oleh Titov
 * @version 1.0
 */
abstract class Ingredient implements Comparable<Ingredient> {
    private String name;
    private double mass;
    private double kCaloriesIn1KG;
    private double kCalories;

    /**
     * Constructor initializes class fields
     *
     * @param name           represents name of Ingredient
     * @param mass           is decimal value in kilograms
     * @param kCaloriesIn1KG is decimal value that represents how much
     *                       kilocalories are in one kg of this Ingredient
     */
    Ingredient(String name, double mass, double kCaloriesIn1KG) {
        this.name = name;
        this.mass = mass;
        this.kCaloriesIn1KG = kCaloriesIn1KG;
        kCalories = calculateCaloriesInMass(mass, kCaloriesIn1KG);
    }

    /**
     * Method calculates calories for current Ingredients mass
     *
     * @param mass           of Ingredient in kilograms
     * @param kCaloriesIn1KG represents amount of kilocalories in 1 kg of mass
     * @return the value corresponding to current Ingredient mass
     */
    double calculateCaloriesInMass(double mass, double kCaloriesIn1KG) {
        return mass * kCaloriesIn1KG;
    }

    /**
     * Getter
     *
     * @return name of Ingredient as String
     */
    String getName() {
        return name;
    }

    /**
     * Getter
     *
     * @return mass of Ingredient as double value in kilograms
     */
    double getMass() {
        return mass;
    }

    /**
     * Getter
     *
     * @return double value - amount of kilocalories in one kilo of Ingredient
     */
    double getKCaloriesIn1KG() {
        return kCaloriesIn1KG;
    }

    /**
     * Getter
     *
     * @return double value - amount of kilocalories in current mass of Ingredient
     */
    double getKCalories() {
        return kCalories;
    }

    /**
     * Method adds more mass to Ingredient and recalculates current amount of
     * kilocalories.
     *
     * @param mass to be added to Ingredient
     */
    void addMore(double mass) {
        this.mass += mass;
        this.kCalories += calculateCaloriesInMass(mass, this.kCaloriesIn1KG);
    }

    /**
     * Method compares current Ingredient with another by amount of kilocalories
     * in one kilo of Ingredient. This method allows to use sort() method in
     * order to sort a list of Ingredient objects.
     *
     * @param ingredient is another object to compare
     * @return {@code -1} if this (current) object is smaller
     * {@code  1} if this object is bigger
     * {@code  0} if objects are equal
     */
    @Override
    public int compareTo(Ingredient ingredient) {
        return Double.compare(kCaloriesIn1KG, ingredient.kCaloriesIn1KG);
    }

    /**
     * Method is intended to
     *
     * @return the value of the Ingredient fields in String representation
     */
    @Override
    public String toString() {
        return StringsContainer.OPEN_CURLY_BRACE
                + bundle.getString(StringsContainer.NAME_WORD)
                + StringsContainer.SPACE_SIGN + StringsContainer.EQUAL_SIGN
                + StringsContainer.SPACE_SIGN + name
                + StringsContainer.COMMA_SIGN + StringsContainer.SPACE_SIGN
                + bundle.getString(StringsContainer.MASS_WORD)
                + StringsContainer.SPACE_SIGN + StringsContainer.EQUAL_SIGN
                + StringsContainer.SPACE_SIGN + mass
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
