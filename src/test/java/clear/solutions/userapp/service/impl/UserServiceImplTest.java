package clear.solutions.userapp.service.impl;

import clear.solutions.userapp.model.User;
import clear.solutions.userapp.repository.UserRepository;
import clear.solutions.userapp.service.UserService;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.Mockito;

class UserServiceImplTest {
    private static final String USER_EMAIL = "email@gmail.com";
    private static final String USER_FIRST_NAME = "First name";
    private static final String USER_LAST_NAME = " Last name";
    private static final LocalDate USER_BIRTH_DATE = LocalDate.now();
    private static final String USER_PHONE = "+11 222 333 44 55";
    private static final String USER_ADDRESS = "Some street, some city";
    private static final String TO_DATE = "2020-12-20";
    private static final String FROM_DATE = "2000-01-01";
    private UserService userService;
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void createUser_ok() {
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(getUser(1L));
        User returnedUser = userService.create(getUser(null));
        Assertions.assertNotNull(returnedUser);
        Assertions.assertEquals(1L, returnedUser.getId());
        Assertions.assertEquals(USER_EMAIL, returnedUser.getEmail());
        Assertions.assertEquals(USER_FIRST_NAME, returnedUser.getFirstName());
        Assertions.assertEquals(USER_LAST_NAME, returnedUser.getLastName());
        Assertions.assertEquals(USER_BIRTH_DATE, returnedUser.getBirthDate());
        Assertions.assertEquals(USER_PHONE, returnedUser.getPhoneNumber());
        Assertions.assertEquals(USER_ADDRESS, returnedUser.getAddress());
    }

    @Test
    void updateUser_ok() {
        Mockito.when(userRepository.save(Mockito.any(User.class)))
                .then(AdditionalAnswers.returnsFirstArg());
        User returnedUser = userService.update(2L, getUser(null));
        Assertions.assertEquals(2L, returnedUser.getId());
    }

    @Test
    public void patchUser_ok() {
        Mockito.when(userRepository.getReferenceById(1L)).thenReturn(getUser(1L));
        Mockito.when(userRepository.save(Mockito.any(User.class)))
                .then(AdditionalAnswers.returnsFirstArg());

        User patchUser = new User();
        String newFirstName = "new first name";
        String newLastName = "new last name";
        patchUser.setFirstName(newFirstName);
        patchUser.setLastName(newLastName);
        User returnedUser = userService.patch(1L, patchUser);
        Assertions.assertNotNull(returnedUser.getEmail());
        Assertions.assertNotNull(returnedUser.getBirthDate());
        Assertions.assertNotNull(returnedUser.getPhoneNumber());
        Assertions.assertNotNull(returnedUser.getAddress());
        Assertions.assertEquals(newFirstName, returnedUser.getFirstName());
        Assertions.assertEquals(newLastName, returnedUser.getLastName());
    }

    @Test
    public void findAllByBirthDateBetween_ok() {
        Mockito.when(userRepository.findAllByBirthDateBetween(Mockito.any(), Mockito.any()))
                .thenReturn(List.of(getUser(1L), getUser(2L)));
        List<User> users = userService.findAllByBirthDateBetween(FROM_DATE, TO_DATE);
        Assertions.assertEquals(2, users.size());
    }

    @Test
    public void findAllByBirthDateBetween_wrongOrderDate_notOk() {
        Assertions.assertThrows(RuntimeException.class,
                () -> userService.findAllByBirthDateBetween(TO_DATE, FROM_DATE));
    }

    private User getUser(Long id) {
        User user = new User();
        user.setId(id);
        user.setEmail(USER_EMAIL);
        user.setFirstName(USER_FIRST_NAME);
        user.setLastName(USER_LAST_NAME);
        user.setBirthDate(USER_BIRTH_DATE);
        user.setPhoneNumber(USER_PHONE);
        user.setAddress(USER_ADDRESS);
        return user;
    }
}
