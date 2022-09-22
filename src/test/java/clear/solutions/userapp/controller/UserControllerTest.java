package clear.solutions.userapp.controller;

import clear.solutions.userapp.model.User;
import clear.solutions.userapp.service.UserService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    private static final String USER_EMAIL = "email@gmail.com";
    private static final String USER_FIRST_NAME = "First name";
    private static final String USER_LAST_NAME = " Last name";
    private static final LocalDate USER_BIRTH_DATE = LocalDate.now();
    private static final String USER_PHONE = "+11 222 333 44 55";
    private static final String USER_ADDRESS = "Some street, some city";
    private static final String TO_DATE = "2020-12-20";
    private static final String FROM_DATE = "2000-01-01";
    private static final String POST_REQUEST_BODY = "{\"email\":\"2email@dot.com\", "
            + "\"firstName\":\"2first name\", \"lastName\":\"2last name\", "
            + "\"birthDate\":\"2000-04-25\", \"phoneNumber\":\"2+380634765761\"}";

    @MockBean
    private UserService userService;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    public void createUser_ok() {
        Mockito.when(userService.create(Mockito.any(User.class))).thenReturn(getUser(1L));

        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .body(POST_REQUEST_BODY)
                .when()
                .post("users")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("id", Matchers.equalTo(1))
                .body("email", Matchers.equalTo(USER_EMAIL))
                .body("firstName", Matchers.equalTo(USER_FIRST_NAME))
                .body("lastName", Matchers.equalTo(USER_LAST_NAME))
                .body("birthDate", Matchers.equalTo(
                        LocalDate.now().format(DateTimeFormatter.ISO_DATE)))
                .body("phoneNumber", Matchers.equalTo(USER_PHONE))
                .body("address", Matchers.equalTo(USER_ADDRESS));
    }

    @Test
    public void patchUser_ok() {
        Mockito.when(userService.patch(Mockito.any(Long.class), Mockito.any(User.class)))
                .thenReturn(getUser(1L));

        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .body(POST_REQUEST_BODY)
                .when()
                .patch("users/1")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("id", Matchers.equalTo(1));
    }

    @Test
    public void updateUser_ok() {
        Mockito.when(userService.update(Mockito.any(Long.class), Mockito.any(User.class)))
                .thenReturn(getUser(1L));

        RestAssuredMockMvc.given()
                .contentType(ContentType.JSON)
                .body(POST_REQUEST_BODY)
                .when()
                .put("users/1")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("id", Matchers.equalTo(1));
    }

    @Test
    public void delete_ok() {
        RestAssuredMockMvc.when()
                .delete("users/1")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void findAllByDate_ok() {
        Mockito.when(userService.findAllByBirthDateBetween(Mockito.any(String.class),
                        Mockito.any(String.class), Mockito.any(PageRequest.class)))
                .thenReturn(List.of(getUser(1L), getUser(2L)));

        RestAssuredMockMvc.given()
                .queryParam("fromDate", FROM_DATE)
                .queryParam("toDate", TO_DATE)
                .when()
                .get("users")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("size()", Matchers.equalTo(2));
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
