package com.timnjonjo.robotapocalypse.utils.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author TMwaura on 02/06/2022
 * @Project robot-apocalypse
 */
public class EnumClassValidator implements ConstraintValidator<ValidEnum, String> {

    private Set<String> validEnumValues;
    private String message;

    @Override
    public void initialize(ValidEnum constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        validEnumValues = Arrays.stream(constraintAnnotation.enumClass().getEnumConstants()).map(Enum::name).map( String::toLowerCase).collect(Collectors.toSet());
        message = "Invalid value %s. Allowed Values : " + validEnumValues;
    }

    @Override
    public boolean isValid(String inputValue, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();
        message = String.format(message, inputValue);
        constraintValidatorContext
                .buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
        return validEnumValues.contains(inputValue.toLowerCase(Locale.ROOT));
    }
}
