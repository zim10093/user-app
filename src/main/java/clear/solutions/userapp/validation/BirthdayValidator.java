package clear.solutions.userapp.validation;

import java.time.LocalDate;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Value;

public class BirthdayValidator implements ConstraintValidator<Birthday, LocalDate> {
    @Value("${min.user.age}")
    private int minUserAge;

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext constraintValidatorContext) {
        if (date == null) {
            return true;
        }
        return date.plusYears(minUserAge).isBefore(LocalDate.now());
    }
}
