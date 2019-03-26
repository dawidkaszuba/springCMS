package pl.dawidkaszuba.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Collection;

public class ListSizeValidator implements ConstraintValidator<ListSize, Collection> {
    @Override
    public void initialize(ListSize annotation) {

    }

    @Override
    public boolean isValid(Collection collection, ConstraintValidatorContext constraintValidatorContext) {
        return collection.size()>0;
    }
}
