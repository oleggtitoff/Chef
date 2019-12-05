package ua.training.model;

import ua.training.view.StringsContainer;

public class AdditionalIngredient extends Ingredient {
    private String type;

    AdditionalIngredient(String name, double mass, double kCaloriesIn1KG,
                         String type) {
        super(name, mass, kCaloriesIn1KG);
        this.type = type;
    }

    String getType() {
        return type;
    }

    @Override
    public String toString() {
        return StringsContainer.ADDITIONAL_INGREDIENT_WORD
                + StringsContainer.SPACE_SIGN + super.toString()
                + StringsContainer.COMMA_SIGN + StringsContainer.SPACE_SIGN
                + StringsContainer.TYPE_WORD + StringsContainer.SPACE_SIGN
                + StringsContainer.EQUAL_SIGN + StringsContainer.SPACE_SIGN
                + type + StringsContainer.CLOSE_CURLY_BRACE;
    }

}
