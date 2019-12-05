package ua.training.controller;

import static ua.training.controller.Types.SPECIES;

public enum Input {
    POTATO("Potato", 0.3, 800, null),
    CARROT("Carrot", 0.2, 310, null),
    TOMATO("Tomato", 0.250, 190, null),
    ONION("Onion", 0.1, 300, null),
    MAYONNAISE("Mayonnaise", 0.080, 6000, "SAUCES"),
    SALT("Salt", 0.005, 0, "SPECIES");

    private final String name;
    private final double mass;
    private final double kCaloriesIn1KG;
    private final String type;

    Input(String name, double mass, double kCaloriesIn1KG, String type) {
        this.name = name;
        this.mass = mass;
        this.kCaloriesIn1KG = kCaloriesIn1KG;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }

    public double getkCaloriesIn1KG() {
        return kCaloriesIn1KG;
    }

    public String getType() {
        return type;
    }

}
