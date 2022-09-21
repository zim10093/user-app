package clear.solutions.userapp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotEmptyOfNotNullValidator implements ConstraintValidator<NotEmptyIfNotNull, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return (value == null) || (!value.isEmpty());
    }
}
