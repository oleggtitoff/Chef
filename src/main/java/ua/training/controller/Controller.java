package ua.training.controller;

import ua.training.model.Salad;
import ua.training.view.View;

public class Controller {
    private Salad salad;
    private View view;

    Controller(Salad salad, View view) {
        this.salad = salad;
        this.view = view;
    }

    public void processUser() {
        // TODO
    }

}
