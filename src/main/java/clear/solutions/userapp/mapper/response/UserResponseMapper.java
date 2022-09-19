package clear.solutions.userapp.mapper.response;

import clear.solutions.userapp.dto.response.UserResponseDto;
import clear.solutions.userapp.mapper.ToDtoMapper;
import clear.solutions.userapp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper implements ToDtoMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto toDto(User model) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(model.getId());
        dto.setEmail(model.getEmail());
        dto.setFirstName(model.getFirstName());
        dto.setLastName(model.getLastName());
        dto.setBirthDate(model.getBirthDate());
        dto.setPhoneNumber(model.getPhoneNumber());
        return dto;
    }
}
