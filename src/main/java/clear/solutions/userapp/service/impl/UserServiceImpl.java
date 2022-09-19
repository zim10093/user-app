package clear.solutions.userapp.service.impl;

import clear.solutions.userapp.model.User;
import clear.solutions.userapp.repository.UserRepository;
import clear.solutions.userapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public User deleteUserById(Long id) {
        return userRepository.deleteUserById(id);
    }
}
