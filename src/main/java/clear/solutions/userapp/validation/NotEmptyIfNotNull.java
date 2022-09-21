package clear.solutions.userapp.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = NotEmptyOfNotNullValidator.class)
@Target({ ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEmptyIfNotNull {
    String message() default "Field must be not empty if present";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
