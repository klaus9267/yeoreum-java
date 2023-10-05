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
public class FriendRepositoryImpl implements FriendRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final UserRepository userRepository;

    @Override
    public List<Friend> findAllByUser(User user) {
        QFriend qFriend = QFriend.friend;

        return jpaQueryFactory.selectFrom(qFriend)
                              .where(qFriend.sender.eq(user).or(qFriend.receiver.eq(user)))
                              .fetch();
    }

    @Override
    public List<Friend> isFriend(User loginUser, User targetUser) {
        QFriend qFriend = QFriend.friend;

        return jpaQueryFactory.selectFrom(qFriend)
                              .where((qFriend.sender.eq(loginUser).and(qFriend.receiver.eq(targetUser)))
                                             .or(qFriend.sender.eq(loginUser).and(qFriend.receiver.eq(targetUser))))
                              .fetch();
    }
}
