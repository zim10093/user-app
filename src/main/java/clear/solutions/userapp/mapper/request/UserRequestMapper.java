package clear.solutions.userapp.mapper.request;

import clear.solutions.userapp.dto.request.UserRequestDto;
import clear.solutions.userapp.mapper.ToModelMapper;
import clear.solutions.userapp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserRequestMapper implements ToModelMapper<UserRequestDto, User> {
    @Override
    public User toModel(UserRequestDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setBirthDate(dto.getBirthDate());
        user.setPhoneNumber(dto.getPhoneNumber());
        return user;
    }
}
