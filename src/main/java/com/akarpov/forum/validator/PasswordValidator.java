package com.akarpov.forum.validator;

import com.akarpov.forum.annotation.ValidPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    private final static String NUM_REGEX = ".*\\d+.*";
    private final static String LOWER_CHAR_REGEX = ".*[a-zа-я]+.*";
    private final static String UPPER_CHAR_REGEX = ".*[A-ZА-Я]+.*";
    private final static String SPECIAL_CHARS_REGEX = ".*[!@#$%]+.*";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.length() >= 8
                && value.matches(NUM_REGEX)
                && value.matches(LOWER_CHAR_REGEX)
                && value.matches(UPPER_CHAR_REGEX)
                && value.matches(SPECIAL_CHARS_REGEX);
    }

}
