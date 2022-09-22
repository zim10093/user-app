package clear.solutions.userapp.validation;

import javax.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class NotEmptyOfNotNullValidatorTest {
    private NotEmptyOfNotNullValidator notEmptyOfNotNullValidator;
    private ConstraintValidatorContext constraintValidatorContext;

    @BeforeEach
    public void setUp() {
        notEmptyOfNotNullValidator = new NotEmptyOfNotNullValidator();
        constraintValidatorContext = Mockito.mock(ConstraintValidatorContext.class);
    }

    @Test
    public void isValid_nullValue_ok() {
        Assertions.assertTrue(notEmptyOfNotNullValidator
                .isValid(null, constraintValidatorContext));
    }

    @Test
    public void isValid_notEmpty_ok() {
        Assertions.assertTrue(notEmptyOfNotNullValidator
                .isValid("not empty", constraintValidatorContext));
    }

    @Test
    public void isValid_Empty_notOk() {
        Assertions.assertFalse(notEmptyOfNotNullValidator
                .isValid("", constraintValidatorContext));
    }
}
