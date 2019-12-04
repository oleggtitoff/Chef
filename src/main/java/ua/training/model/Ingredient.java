package ua.training.model;

class Ingredient {
    private double mass;
    private double kCaloriesIn1KG;
    private double kCalories;

    Ingredient(double mass, double kCaloriesIn1KG) {
        this.mass = mass;
        this.kCaloriesIn1KG = kCaloriesIn1KG;
        kCalories = calculateCaloriesInMass(mass, kCaloriesIn1KG);
    }

    double calculateCaloriesInMass(double mass, double kCaloriesIn1KG) {
        return mass * kCaloriesIn1KG;
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

}
