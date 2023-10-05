package com.example.yeoreumjava.friend;

import com.example.yeoreumjava.friend.domain.Friend;
import com.example.yeoreumjava.friend.repository.FriendRepository;
import com.example.yeoreumjava.user.UserService;
import com.example.yeoreumjava.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

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

    public void deleteFriend(Long receiverId, Long senderId) {

    }

    public void findOne(Long senderId, Long receiverId) {
        User sender = userService.findUserById(senderId);
        User receiver = userService.findUserById(receiverId);

        Friend friend = friendRepository.findBySenderAndReceiver(sender, receiver)
                                        .orElseThrow(() -> new NoSuchElementException("친구 "));
    }
}
