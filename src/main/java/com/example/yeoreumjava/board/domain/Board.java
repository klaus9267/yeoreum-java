package com.example.yeoreumjava.board.domain;

import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.user.domain.User;
import lombok.NonNull;

import javax.persistence.*;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;
    @NonNull
    @Column(nullable = false)
    private String title;
    @NonNull
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_no")
    private User writerNo;

    @OneToOne
    @JoinColumn(name = "meeting_no")
    private Meeting meetingNo;
}
