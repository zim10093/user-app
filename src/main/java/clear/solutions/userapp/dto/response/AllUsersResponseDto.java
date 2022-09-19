package clear.solutions.userapp.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AllUsersResponseDto {
    private List<UserResponseDto> users;
}
