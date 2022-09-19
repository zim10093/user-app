package clear.solutions.userapp.mapper.response;

import clear.solutions.userapp.dto.response.AllUsersResponseDto;
import clear.solutions.userapp.dto.response.UserResponseDto;
import clear.solutions.userapp.mapper.ToDtoMapper;
import clear.solutions.userapp.model.User;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AllUserResponseMapper implements ToDtoMapper<AllUsersResponseDto, List<User>> {
    private final ToDtoMapper<UserResponseDto, User> toUserDtoMapper;

    @Override
    public AllUsersResponseDto toDto(List<User> model) {
        AllUsersResponseDto allUsersDto = new AllUsersResponseDto();
        allUsersDto.setUsers(model.stream()
                .map(toUserDtoMapper::toDto)
                .collect(Collectors.toList()));
        return allUsersDto;
    }
}
