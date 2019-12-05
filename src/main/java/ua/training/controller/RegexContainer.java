package ua.training.controller;

public interface RegexContainer {
    String NAME_REGEX_ENG = "^[A-Z][a-z]{1,20}$";
    String NAME_REGEX_UKR = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    String YES_NO_REGEX_ENG = "^Y|N$";
    String YES_NO_REGEX_UKR = "^Т|Н$";
    String VEGETABLE_OR_ADDITIONAL_INGREDIENT_REGEX_ENG = "^V|A$";
    String VEGETABLE_OR_ADDITIONAL_INGREDIENT_REGEX_UKR = "^О|Д$";
}
