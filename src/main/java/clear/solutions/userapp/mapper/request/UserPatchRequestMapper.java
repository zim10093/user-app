package clear.solutions.userapp.mapper.request;

import clear.solutions.userapp.dto.request.UserPatchRequestDto;
import clear.solutions.userapp.mapper.ToModelMapper;
import clear.solutions.userapp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserPatchRequestMapper implements ToModelMapper<UserPatchRequestDto, User> {
    @Override
    public User toModel(UserPatchRequestDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setBirthDate(dto.getBirthDate());
        user.setPhoneNumber(dto.getPhoneNumber());
        return user;
    }
}
