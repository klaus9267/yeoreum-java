package com.example.yeoreumjava.user;

import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.UserDTO;
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

    @GetMapping("")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable("id") Long id) {
        UserDTO user = userService.findUserById(id);

        return ResponseEntity.ok(user);
    }

    @PostMapping("")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);

        return ResponseEntity.ok(userDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
        userService.updateUser(id, userDTO);

        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);

        return ResponseEntity.status(HttpStatus.OK).body("삭제 성공");
    }
}
