package ua.training.model;

class Vegetable extends Ingredient {
    private boolean isClean;

    Vegetable(double mass, double kCaloriesIn1KG) {
        super(mass, kCaloriesIn1KG);
    }

    boolean checkIfIsClean() {
        return isClean;
    }

}
