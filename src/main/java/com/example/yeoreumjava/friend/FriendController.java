package com.example.yeoreumjava.friend;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/friends")
@RequiredArgsConstructor
public class FriendController {
    private final FriendService friendService;

    @PostMapping("{receiverId}")
    public ResponseEntity<String> applyFriend(@PathVariable("receiverId") Long receiverId) {

        return ResponseEntity.ok("신청 완료");
    }
}
