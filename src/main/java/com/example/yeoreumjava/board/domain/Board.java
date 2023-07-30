package com.example.yeoreumjava.board.domain;

import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.user.domain.User;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @Column(nullable = false)
    private String title;
//    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User writer;

    @OneToOne
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @CreatedDate
    private LocalDateTime createAt;
    @LastModifiedDate
    private LocalDateTime updateAt;
}
