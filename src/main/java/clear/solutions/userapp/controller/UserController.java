package clear.solutions.userapp.controller;

import clear.solutions.userapp.dto.request.UserRequestDto;
import clear.solutions.userapp.dto.response.AllUsersResponseDto;
import clear.solutions.userapp.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
@RequiredArgsConstructor
public class UserController {

    @PostMapping()
    public User createUser(@RequestBody UserRequestDto dto) {
        //TODO + validate
        return null;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserRequestDto dto) {
        //TODO
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        //TODO
        return "delete success!";
    }

    @GetMapping
    public AllUsersResponseDto findAllByDate(@PathVariable String date) {
        //TODO
        return null;
    }
}
