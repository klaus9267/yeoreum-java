package com.example.yeoreumjava.friend;

import com.example.yeoreumjava.friend.domain.Friend;
import com.example.yeoreumjava.friend.repository.FriendRepository;
import com.example.yeoreumjava.user.UserService;
import com.example.yeoreumjava.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final FriendRepository friendRepository;
    private final UserService userService;

    public void applyFriend(Long senderId, Long receiverId) {
        User sender = userService.findUserById(senderId);
        User receiver = userService.findUserById(receiverId);

        Friend friend = Friend.builder().sender(sender).receiver(receiver).build();
        friendRepository.save(friend);
    }
}
