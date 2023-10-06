package com.example.yeoreumjava.profile;

import com.example.yeoreumjava.user.domain.dto.UserResponse;
import com.example.yeoreumjava.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

//    @GetMapping("/{id}")
//    public ResponseEntity<UserResponse> findUserById(@PathVariable("id") Long id) {
//        return ResponseEntity.ok(UserMapper.instance.toDto(userService.loadUser(id)));
//    }
}
