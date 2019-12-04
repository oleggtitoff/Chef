package ua.training.model;

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

}
