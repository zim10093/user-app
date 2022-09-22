package clear.solutions.userapp.validation;

import java.time.LocalDate;
import javax.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest
class BirthdayValidatorTest {

    private BirthdayValidator birthdayValidator;
    private ConstraintValidatorContext constraintValidatorContext;
    @Value("${min.user.age}")
    private int minUserAge;

    @BeforeEach
    public void setUp() {
        birthdayValidator = new BirthdayValidator();
        ReflectionTestUtils.setField(birthdayValidator, "minUserAge", minUserAge);
        constraintValidatorContext = Mockito.mock(ConstraintValidatorContext.class);
    }

    @Test
    public void isValid_ok() {
        Assertions.assertTrue(birthdayValidator.isValid(LocalDate.now().minusYears(18)
                        .minusDays(1),
                constraintValidatorContext));
    }

    @Test
    public void isValid_notEnoughYears_notOk() {
        Assertions.assertFalse(birthdayValidator.isValid(LocalDate.now().minusYears(16),
                constraintValidatorContext));
    }
}
