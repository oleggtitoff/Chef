package ua.training.controller;

import ua.training.view.StringsContainer;
import ua.training.view.View;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UtilityController {
    private View view;
    private Scanner scanner;

    UtilityController(View view) {
        this.view = view;
        scanner = new Scanner(System.in);
    }

    double inputNotNegativeDoubleWithScanner(String message) {
        double inputValue = inputDoubleWithScanner(message);

        while (inputValue < 0) {
            view.printWrongInputMessage();
            inputValue = inputDoubleWithScanner(message);
        }
        return inputValue;
    }

    private double inputDoubleWithScanner(String message) {
        view.printBundleLine(message);
        while (!scanner.hasNextDouble()) {
            view.printWrongInputAndBundleLine(message);
            scanner.next();
        }
        return scanner.nextDouble();
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
