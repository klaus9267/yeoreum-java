package com.example.yeoreumjava.common;

import com.example.yeoreumjava.friend.FriendService;
import com.example.yeoreumjava.major.MajorService;
import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.major.domain.dto.MajorRequest;
import com.example.yeoreumjava.user.UserService;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DBInit implements InitializingBean {
    private final UserService userService;
    private final MajorService majorService;
    private final FriendService friendService;

    @Override
    public void afterPropertiesSet() throws Exception {

        if (majorService.findMajor(1L).isEmpty()) {
            Major major = majorService.createMajor(MajorRequest.builder()
                                                               .name("컴소")
                                                               .build());
        }
        if (majorService.findMajor(2L).isEmpty()) {
            Major major = majorService.createMajor(MajorRequest.builder()
                                                               .name("기계")
                                                               .build());
        }

        if (userService.findUser(1L).isEmpty()) {
            User user = userService.createUser(UserRequest.builder()
                                                    .name("user1")
                                                    .majorId(1L)
                                                    .build());
//            userService.addAuthority(user.getUserId(), "ROLE_USER");
        }
        if (userService.findUser(2L).isEmpty()) {
            User user = userService.createUser(UserRequest.builder()
                                                    .name("user2")
                                                    .majorId(1L)
                                                    .build());
//            userService.addAuthority(user.getUserId(), "ROLE_USER");
        }
        if (userService.findUser(3L).isEmpty()) {
            User user = userService.createUser(UserRequest.builder()
                                                    .name("user3")
                                                    .majorId(2L)
                                                    .build());
//            userService.addAuthority(user.getUserId(), "ROLE_USER");
        }

//        if (friendService.findUser(3L).isEmpty()) {
//            User user = userService.createUser(UserRequest.builder()
//                                                    .name("user3")
//                                                    .majorId(2L)
//                                                    .build());
////            userService.addAuthority(user.getUserId(), "ROLE_USER");
//        }
    }
}
