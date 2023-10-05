package com.example.yeoreumjava.friend.repository;

import com.example.yeoreumjava.friend.domain.Friend;
import com.example.yeoreumjava.friend.domain.QFriend;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.repository.UserRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class FriendRepositoryImpl implements FriendRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final UserRepository userRepository;

        @Override
    public List<Friend> findAllById(User user) {
        QFriend qFriend = QFriend.friend;
            return jpaQueryFactory.selectFrom(qFriend)
                                  .where(qFriend.sender.eq(user).or(qFriend.receiver.eq(user)))
                                  .fetch();
    }
}
