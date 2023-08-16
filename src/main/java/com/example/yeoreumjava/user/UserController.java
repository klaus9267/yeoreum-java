package com.example.yeoreumjava.user;

import com.example.yeoreumjava.user.domain.UserDTO;
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
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> userDTOList = userService.findAll();

        return ResponseEntity.ok(userDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable("id") Long id) {
        UserDTO userDTO = userService.findUserById(id);

        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO userDTO) {
        System.out.println("1111111");
        userService.createUser(userDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body("가입 완료");
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
