package clear.solutions.userapp.service.impl;

import clear.solutions.userapp.model.User;
import clear.solutions.userapp.repository.UserRepository;
import clear.solutions.userapp.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(Long id, User user) {
        return null;
    }

    @Override
    public User patch(Long id, User user) {
        return null;
    }

    @Override
    public List<User> findAllByBirthDateBetween(String fromDate, String toDate) {
        return null;
    }

    public User deleteById(Long id) {
        return userRepository.deleteUserById(id);
    }
}
