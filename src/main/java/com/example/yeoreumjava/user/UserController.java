package com.example.yeoreumjava.user;

import com.example.yeoreumjava.user.domain.User;
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
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id) {
        User user = userService.findUserById(id);

        return ResponseEntity.ok(user);
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.createUser(user);

        return ResponseEntity.ok(user);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        userService.updateUser(id, user);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);

        return ResponseEntity.status(HttpStatus.OK).body("삭제 성공");
    }
}
