package ua.training.controller;

import ua.training.model.Salad;
import ua.training.view.StringsContainer;
import ua.training.view.View;

import static ua.training.view.View.bundle;

public class Controller {
    private Salad salad;
    private View view;
    private UtilityController utilityController;

    public Controller(Salad salad, View view) {
        this.salad = salad;
        this.view = view;
        this.utilityController = new UtilityController(view);
    }

    public void processEnumInput() {
        for (int i = 0; i < 4; i++) {
            salad.addVegetable(Input.values()[i].getName(),
                    Input.values()[i].getMass(),
                    Input.values()[i].getkCaloriesIn1KG());
        }

        for (int i = 4; i < 6; i++) {
            salad.addAdditionalIngredient(Input.values()[i].getName(),
                    Input.values()[i].getMass(),
                    Input.values()[i].getkCaloriesIn1KG(),
                    Input.values()[i].getType());
        }

        salad.sort();
        view.printBundleLine(StringsContainer.RANGE_MESSAGE);
        view.printLine(salad.getIngredientsInKCaloriesRangeToString(190, 400));

        view.printBundleLine(StringsContainer.TOTAL_CALORIES_MESSAGE);
        view.printLine(Double.toString(salad.getTotalKCalories()));

        view.printBundleLine(StringsContainer.INGREDIENTS_MESSAGE);
        view.printLine(salad.toString());
    }

    public void processUser() {
        inputCycle();
        askIfAndSort();
        askIfAndShowIngredientsInSomeRange();
        showTotalCalories();
        showAllIngredients();
    }

    private void inputCycle() {
        while (askIfAndAddNewIngredient()) {
        }
    }

    private boolean askIfAndAddNewIngredient() {
        if (askIfAddIngredient()) {
            addNewIngredient();
            return true;
        }
        return false;
    }

    private boolean askIfAddIngredient() {
        String regex = utilityController.getYesOrNoRegexLocal();

        return utilityController.getAndCheckUserAnswer(
                StringsContainer.INPUT_INGREDIENT_QUESTION,
                bundle.getString(StringsContainer.USER_YES_ANSWER), regex);
    }

    private void addNewIngredient() {
        boolean isVegetable = askIfAddVegetable();
        String name = inputName();
        String type;
        double mass = inputMass();
        double kCaloriesIn1KG = inputKCaloriesIn1KG();

        if (isVegetable) {
            salad.addVegetable(name, mass, kCaloriesIn1KG);
            view.printBundleLine(StringsContainer.INGREDIENT_ADDED_MESSAGE);
            return;
        }
        type = inputType();
        salad.addAdditionalIngredient(name, mass, kCaloriesIn1KG, type);
        view.printBundleLine(StringsContainer.INGREDIENT_ADDED_MESSAGE);
    }

    private String inputName() {
        String regex = utilityController.getNameRegexLocal();

        return utilityController.inputStringWithScannerByRegex(
                StringsContainer.NAME_PROMPT, regex);
    }

    private double inputMass() {
        return utilityController.inputNotNegativeDoubleWithScanner(
                StringsContainer.MASS_PROMPT);
    }

    private double inputKCaloriesIn1KG() {
        return utilityController.inputNotNegativeDoubleWithScanner(
                StringsContainer.K_CALORIES_PROMPT);
    }

    private boolean askIfAddVegetable() {
        String regex = utilityController.getVegetableOrNotRegexLocal();

        return utilityController.getAndCheckUserAnswer(
                StringsContainer.WHAT_INGREDIENT_QUESTION,
                bundle.getString(StringsContainer.USER_VEGETABLE_ANSWER), regex);
    }

    private String inputType() {
        String regex = utilityController.getRegexFromTypesEnum();

        return utilityController.inputStringWithScannerByRegex(
                StringsContainer.TYPE_PROMPT, regex);
    }

    private void askIfAndSort() {
        if (askIfSort()) {
            salad.sort();
            view.printBundleLine(StringsContainer.SORT_MESSAGE);
        }
    }

    private boolean askIfSort() {
        String regex = utilityController.getYesOrNoRegexLocal();

        return utilityController.getAndCheckUserAnswer(
                StringsContainer.SORT_QUESTION,
                bundle.getString(StringsContainer.USER_YES_ANSWER), regex);
    }

    private void askIfAndShowIngredientsInSomeRange() {
        if (askIfShowInSomeRange()) {
            showIngredientsInSomeRange();
        }
    }

    private boolean askIfShowInSomeRange() {
        String regex = utilityController.getYesOrNoRegexLocal();

        return utilityController.getAndCheckUserAnswer(
                StringsContainer.RANGE_QUESTION,
                bundle.getString(StringsContainer.USER_YES_ANSWER), regex);
    }

    private void showIngredientsInSomeRange() {
        double minRangeValue = inputMinRangeValue();
        double maxRangeValue = inputMaxRangeValue(minRangeValue);
        String ingredientsInRange
                = salad.getIngredientsInKCaloriesRangeToString(minRangeValue,
                maxRangeValue);

        view.printBundleLine(StringsContainer.RANGE_MESSAGE);
        view.printLine(ingredientsInRange);
    }

    private double inputMinRangeValue() {
        return utilityController.inputNotNegativeDoubleWithScanner(
                StringsContainer.RANGE_MIN_PROMPT);
    }

    private double inputMaxRangeValue(double minRangeValue) {
        return utilityController.inputMaxRangeValueWithScanner(minRangeValue);
    }

    private void showTotalCalories() {
        view.printBundleLine(StringsContainer.TOTAL_CALORIES_MESSAGE);
        view.printLine(Double.toString(salad.getTotalKCalories()));
    }

    private void showAllIngredients() {
        view.printBundleLine(StringsContainer.INGREDIENTS_MESSAGE);
        view.printLine(salad.toString());
    }

}
