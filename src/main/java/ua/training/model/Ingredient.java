package ua.training.model;

class Ingredient {
    private double mass;
    private double kCalories;

    Ingredient(double mass, double kCaloriesIn1KG) {
        this.mass = mass;
        kCalories = calculateCaloriesInMass(mass, kCaloriesIn1KG);
    }

    double calculateCaloriesInMass(double mass, double kCaloriesIn1KG) {
        return mass * kCaloriesIn1KG;
    }

    double getMass() {
        return mass;
    }

    double getKCalories() {
        return kCalories;
    }

    void addMore(double mass) {
        this.mass += mass;
    }

}
