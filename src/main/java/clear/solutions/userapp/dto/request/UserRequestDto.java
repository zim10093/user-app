package clear.solutions.userapp.dto.request;

import java.time.LocalDate;
import lombok.Getter;

@Getter
public class UserRequestDto {
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String phoneNumber;
}
