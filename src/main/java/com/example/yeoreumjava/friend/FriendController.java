package com.example.yeoreumjava.friend;

import com.example.yeoreumjava.friend.domain.Friend;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/friends")
@RequiredArgsConstructor
public class FriendController {
    private final FriendService friendService;

    @PostMapping("{receiverId}")
    public ResponseEntity<String> applyFriend(@PathVariable("receiverId") Long receiverId) {

        return ResponseEntity.ok("신청 완료");
    }

//    @GetMapping("")
//    public ResponseEntity<List<Friend>> loadFriendList() {
//        return ResponseEntity.ok()
//    }
}
