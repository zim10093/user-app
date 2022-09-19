package clear.solutions.userapp.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = BirthdayValidator.class)
@Target({ ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Birthday {
    String message() default "Too young! User should be older then 18 years";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
