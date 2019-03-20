package pl.dawidkaszuba.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class DraftValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return ValidationDraft.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
