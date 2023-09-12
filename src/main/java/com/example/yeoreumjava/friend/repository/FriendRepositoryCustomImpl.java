package com.example.yeoreumjava.friend.repository;

import com.example.yeoreumjava.friend.domain.Friend;
import com.example.yeoreumjava.friend.domain.QFriend;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class FriendRepositoryCustomImpl implements FriendRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Friend> findAllById(Long id) {
        QFriend qFriend = QFriend.friend;
        return jpaQueryFactory.selectFrom(qFriend);
    }
}
