package clear.solutions.userapp.service;

import clear.solutions.userapp.model.User;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User create(User user);

    User update(Long id, User user);

    User patch(Long id, User user);

    List<User> findAllByBirthDateBetween(String fromDate, String toDate, Pageable pageable);

    void deleteById(Long id);
}
