package clear.solutions.userapp.service.impl;

import clear.solutions.userapp.model.User;
import clear.solutions.userapp.repository.UserRepository;
import clear.solutions.userapp.service.UserService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public User patch(Long id, User user) {
        User originUser = userRepository.getReferenceById(id);
        return userRepository.save(patchFields(user, originUser));
    }

    @Override
    public List<User> findAllByBirthDateBetween(String fromDate, String toDate) {
        LocalDate from = LocalDate.parse(fromDate);
        LocalDate to = LocalDate.parse(toDate);
        return userRepository.findAllByBirthDateBetween(from, to);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    private User patchFields(User patchedUser, User originUser) {
        if (patchedUser.getEmail() != null) {
            originUser.setEmail(patchedUser.getEmail());
        }
        if (patchedUser.getFirstName() != null) {
            originUser.setFirstName(patchedUser.getFirstName());
        }
        if (patchedUser.getLastName() != null) {
            originUser.setLastName(patchedUser.getLastName());
        }
        if (patchedUser.getBirthDate() != null) {
            originUser.setBirthDate(patchedUser.getBirthDate());
        }
        if (patchedUser.getPhoneNumber() != null) {
            originUser.setPhoneNumber(patchedUser.getPhoneNumber());
        }
        return originUser;
    }
}
