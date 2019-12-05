package ua.training.controller;

import ua.training.view.StringsContainer;
import ua.training.view.View;

import java.util.Scanner;
import java.util.regex.Pattern;

class UtilityController {
    private View view;
    private Scanner scanner;

    UtilityController(View view) {
        this.view = view;
        scanner = new Scanner(System.in);
    }

    String getYesOrNoRegexLocal() {
        return getRegexLocal(RegexContainer.YES_NO_REGEX_ENG,
                RegexContainer.YES_NO_REGEX_UKR);
    }

    String getVegetableOrNotRegexLocal() {
        return getRegexLocal(
                RegexContainer.VEGETABLE_OR_ADDITIONAL_INGREDIENT_REGEX_ENG,
                RegexContainer.VEGETABLE_OR_ADDITIONAL_INGREDIENT_REGEX_UKR);
    }

    String getNameRegexLocal() {
        return getRegexLocal(RegexContainer.NAME_REGEX_ENG,
                RegexContainer.NAME_REGEX_UKR);
    }

    private String getRegexLocal(String eng, String ukr) {
        return (String.valueOf(View.bundle.getLocale()).equals("en")) ? eng : ukr;
    }

    String getRegexFromTypesEnum() {
        StringBuilder regex = new StringBuilder();

        buildTypesRegexString(regex);
        return regex.toString();
    }

    private void buildTypesRegexString(StringBuilder regex) {
        regex.append(StringsContainer.CARET_SIGN);
        appendTypesWithBarSymbolToString(regex);
        regex.setLength(regex.length() - 1);
        regex.append(StringsContainer.DOLLAR_SIGN);
    }

    private void appendTypesWithBarSymbolToString(StringBuilder regex) {
        for (Types type : Types.values()) {
            regex.append(type);
            regex.append(StringsContainer.VERTICAL_BAR_SYMBOL);
        }
    }

    double inputMaxRangeValueWithScanner(double minValue) {
        return inputDoubleNotLessThanSomeValueWithScanner(StringsContainer.RANGE_MAX_PROMPT,
                minValue);
    }

    double inputNotNegativeDoubleWithScanner(String message) {
        return inputDoubleNotLessThanSomeValueWithScanner(message, 0);
    }

    private double inputDoubleNotLessThanSomeValueWithScanner(String message, double threshold) {
        double inputValue = inputDoubleWithScanner(message);

        while (inputValue < threshold) {
            view.printWrongInputMessage();
            inputValue = inputDoubleWithScanner(message);
        }
        return inputValue;
    }

    private double inputDoubleWithScanner(String message) {
        view.printBundleLine(message);
        while (!scanner.hasNextDouble()) {
            view.printWrongInputAndBundleLine(message);
            scanner.nextLine();
        }
        return Double.parseDouble(scanner.nextLine());
    }

    boolean getAndCheckUserAnswer(String message, String potentialAnswer,
                                  String regex) {
        String inputString = inputStringWithScannerByRegex(message, regex);

        return checkUserAnswer(potentialAnswer, inputString);
    }

    private boolean checkUserAnswer(String potentialAnswer, String answer) {
        return potentialAnswer.equals(answer);
    }

    String inputStringWithScannerByRegex(String message, String regex) {
        String inputString;

        view.printBundleLine(message);
        inputString = scanner.nextLine();
        while (!matchStringToRegex(inputString, regex)) {
            view.printWrongInputAndBundleLine(message);
            inputString = scanner.nextLine();
        }
        return inputString;
    }

    private boolean matchStringToRegex(String message, String regex) {
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(message).matches();
    }

}
