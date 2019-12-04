package ua.training.model;

class Vegetable extends Ingredient {
    private boolean isClean;

    Vegetable(String name, double mass, double kCaloriesIn1KG) {
        super(name, mass, kCaloriesIn1KG);
    }

    void checkAndClean() {
        if (!checkIfIsClean()) {
            clean();
        }
    }

    boolean checkIfIsClean() {
        return isClean;
    }

    void clean() {
        isClean = true;
    }

}
