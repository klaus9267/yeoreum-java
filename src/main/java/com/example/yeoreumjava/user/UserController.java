package com.example.yeoreumjava.user;

import com.example.yeoreumjava.user.domain.dto.UserRequest;
import com.example.yeoreumjava.user.domain.dto.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<List<UserResponse>> findAll() {
        List<UserResponse> userResponseList = userService.findAll();

        return ResponseEntity.ok(userResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findUserById(@PathVariable("id") Long id) {
        UserResponse userResponse = userService.findUserResponseById(id);

        return ResponseEntity.ok(userResponse);
    }

    @PostMapping("")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body("가입 완료");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id, @RequestBody
    UserRequest userRequest) {
        userService.updateUser(id, userRequest);

        return ResponseEntity.ok("수정 완료");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);

        return ResponseEntity.status(HttpStatus.OK).body("삭제 성공");
    }
}
