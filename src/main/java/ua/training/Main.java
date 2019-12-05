package ua.training;

import ua.training.controller.Controller;
import ua.training.model.Salad;
import ua.training.view.View;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new Salad(), new View());

        //controller.processEnumInput();
        controller.processUser();
    }

}
