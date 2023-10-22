package com.example.yeoreumjava.friend;

import com.example.yeoreumjava.friend.domain.Friend;
import com.example.yeoreumjava.friend.repository.FriendRepository;
import com.example.yeoreumjava.friend.repository.FriendCustomRepository;
import com.example.yeoreumjava.user.UserService;
import com.example.yeoreumjava.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final FriendRepository friendRepository;
    private final FriendCustomRepository friendCustomRepository;

    private final UserService userService;

    public List<Friend> loadFriendList(Long userId) {
        User user = userService.loadUser(userId);
        return friendCustomRepository.findAllByUser(user);
    }
    public void applyFriend(Long senderId, Long receiverId) {
        User sender = userService.loadUser(senderId);
        User receiver = userService.loadUser(receiverId);

        Friend friend = Friend.builder().sender(sender).receiver(receiver).build();
        friendRepository.save(friend);
    }

    public void acceptFriend(Long senderId, Long receiverId) {
        Friend friend = findOne(receiverId, senderId);
        friend.setAccepted(true);
        friendRepository.save(friend);
    }

    public void deleteFriend(Long loginUserId, Long targetUserId) {
        Friend friend = findOne(loginUserId, targetUserId);
        friendRepository.delete(friend);
    }

    public Friend findOne(Long loginUserId, Long targetUserId) {
        User loginUser = userService.loadUser(loginUserId);
        User targetUser = userService.loadUser(targetUserId);

        return friendCustomRepository.isFriend(loginUser, targetUser)
                                     .orElseThrow(()->new NoSuchElementException("친구 상태가 아닙니다."));
    }
}
