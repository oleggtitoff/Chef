package ua.training.model;

public class AdditionalIngredient extends Ingredient {
    private String type;

    AdditionalIngredient(double mass, double kCaloriesIn1KG, String type) {
        super(mass, kCaloriesIn1KG);
        this.type = type;
    }

    String getType() {
        return type;
    }

}
