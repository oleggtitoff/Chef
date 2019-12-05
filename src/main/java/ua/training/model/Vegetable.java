package ua.training.model;

import ua.training.view.StringsContainer;

import static ua.training.view.View.bundle;

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

    @Override
    public String toString() {
        return bundle.getString(StringsContainer.VEGETABLE_WORD)
                + StringsContainer.SPACE_SIGN + super.toString()
                + StringsContainer.CLOSE_CURLY_BRACE;
    }

}
