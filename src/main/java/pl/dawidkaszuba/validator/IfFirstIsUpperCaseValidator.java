package pl.dawidkaszuba.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IfFirstIsUpperCaseValidator implements ConstraintValidator<IfFirstIsUpperCase, String> {

    @Override
    public void initialize(IfFirstIsUpperCase constraintAnnotation) {

    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return Character.isUpperCase(name.charAt(0));
    }
}
