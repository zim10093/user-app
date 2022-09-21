package clear.solutions.userapp.dto.request;

import clear.solutions.userapp.validation.Birthday;
import clear.solutions.userapp.validation.Email;
import clear.solutions.userapp.validation.NotEmptyIfNotNull;
import java.time.LocalDate;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
public class UserPatchRequestDto {
    @Email
    private String email;
    @NotEmptyIfNotNull
    private String firstName;
    @NotEmptyIfNotNull
    private String lastName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Birthday
    private LocalDate birthDate;
    private String phoneNumber;
    private String address;
}
