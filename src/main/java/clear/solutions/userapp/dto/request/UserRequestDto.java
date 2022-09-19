package clear.solutions.userapp.dto.request;

import clear.solutions.userapp.validation.Birthday;
import clear.solutions.userapp.validation.Email;
import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
public class UserRequestDto {
    @Email
    @NotNull
    private String email;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull
    @Birthday
    private LocalDate birthDate;
    private String phoneNumber;
    private String address;
}
