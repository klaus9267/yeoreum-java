package com.example.yeoreumjava.friend;

import com.example.yeoreumjava.friend.domain.Friend;
import com.example.yeoreumjava.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/friends")
@RequiredArgsConstructor
public class FriendController {
    private final FriendService friendService;

    @PostMapping("{receiverId}")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<String> applyFriend(@PathVariable("receiverId") Long receiverId,
                                              @AuthenticationPrincipal User user) {
        friendService.applyFriend(user.getId(), receiverId);
        return ResponseEntity.ok("신청 완료");
    }

    @PostMapping("{senderId}")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<String> acceptFriend(@PathVariable("senderId") Long senderId,
                                              @AuthenticationPrincipal User user) {
        friendService.acceptFriend(senderId, user.getId());
        return ResponseEntity.ok("신청 완료");
    }

    @GetMapping("")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<List<Friend>> loadFriendList(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(friendService.loadFriendList(user.getId()));
    }
}
