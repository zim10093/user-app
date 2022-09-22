package clear.solutions.userapp.controller;

import clear.solutions.userapp.dto.request.UserPatchRequestDto;
import clear.solutions.userapp.dto.request.UserRequestDto;
import clear.solutions.userapp.dto.response.UserResponseDto;
import clear.solutions.userapp.mapper.ToDtoMapper;
import clear.solutions.userapp.mapper.ToModelMapper;
import clear.solutions.userapp.model.User;
import clear.solutions.userapp.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ToModelMapper<UserRequestDto, User> userRequestMapper;
    private final ToDtoMapper<UserResponseDto, User> userResponseMapper;
    private final ToModelMapper<UserPatchRequestDto, User> userPatchRequestMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto createUser(@RequestBody @Valid UserRequestDto dto) {
        return userResponseMapper.toDto(userService.create(userRequestMapper.toModel(dto)));
    }

    @PatchMapping("/{id}")
    public UserResponseDto patchUser(@PathVariable Long id,
                                     @RequestBody @Valid UserPatchRequestDto dto) {
        return userResponseMapper.toDto(userService.patch(id, userPatchRequestMapper.toModel(dto)));
    }

    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Long id,
                                      @RequestBody @Valid UserRequestDto dto) {
        return userResponseMapper.toDto(userService.update(id, userRequestMapper.toModel(dto)));
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @GetMapping
    public List<UserResponseDto> findAllByDate(
            @RequestParam (defaultValue = "2000-01-01") String fromDate,
            @RequestParam (defaultValue = "2030-01-01") String toDate,
            @RequestParam (defaultValue = "50") Integer count,
            @RequestParam (defaultValue = "0") Integer page) {
        PageRequest pageRequest = PageRequest.of(page, count);
        return userService.findAllByBirthDateBetween(fromDate, toDate, pageRequest).stream()
                .map(userResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
