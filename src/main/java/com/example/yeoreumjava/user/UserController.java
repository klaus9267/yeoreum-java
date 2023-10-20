package com.example.yeoreumjava.user;

import com.example.yeoreumjava.security.utils.JwtUtil;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.dto.LoginDto;
import com.example.yeoreumjava.user.domain.dto.UserRequest;
import com.example.yeoreumjava.user.domain.dto.UserResponse;
import com.example.yeoreumjava.user.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/join")
    public ResponseEntity<String> join(@Valid @RequestBody UserRequest userRequest) {
        userService.join(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("가입 완료");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDto loginDto) {
        User user = userService.login(loginDto);
        return ResponseEntity.ok(jwtUtil.createToken(user.getUsername(), loginDto.getPassword(),user.getId()));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<UserResponse> findUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(UserMapper.instance.toDto(userService.loadUser(id)));
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<String> updateUser(@PathVariable("id") Long id,
                                             @RequestBody UserRequest userRequest) {
//        userService.updateUser(id, userRequest);
        return ResponseEntity.ok("수정 완료");
    }

    @DeleteMapping("")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<String> deleteUser(@AuthenticationPrincipal User user) {
        userService.deleteUser(user);

        return ResponseEntity.ok("삭제 성공");
    }

}
