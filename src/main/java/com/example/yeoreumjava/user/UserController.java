package com.example.yeoreumjava.user;

import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.dto.UserRequest;
import com.example.yeoreumjava.user.domain.dto.UserResponse;
import com.example.yeoreumjava.user.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(UserMapper.instance.toDto(userService.loadUser(id)));
    }

    @PostMapping("")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserRequest userRequest) {
        userService.createUser(UserMapper.instance.toEntity(userRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body("가입 완료");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id, @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok("수정 완료" + userService.updateUser(id, userRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);

        return ResponseEntity.ok("삭제 성공");
    }

}
